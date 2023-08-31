package Testw.Test2.Names;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class WordServiceTest {

    private WordService wordService;

    @BeforeEach
    public void setUp() {
        wordService = new WordService();
    }

    @Test
    public void testInitialCountIsZero() {
        assertEquals(0, wordService.getWordCount("test"));
    }

    @Test
    public void testWordCountAfterOneAddition() {
        wordService.addWord("test");
        assertEquals(1, wordService.getWordCount("test"));
    }

    @Test
    public void testWordCountAfterTwoAdditions() {
        wordService.addWord("test");
        wordService.addWord("test");
        assertEquals(2, wordService.getWordCount("test"));
    }

    @Test
    public void testWordCountForDifferentWord() {
        wordService.addWord("test");
        assertEquals(0, wordService.getWordCount("other"));
    }

    @Test
    public void testResetWordCountForSpecificWord() {
        wordService.addWord("test");
        wordService.resetWordCount("test");
        assertEquals(0, wordService.getWordCount("test"));
    }

    @Test
    public void testResetAllWordCounts() {
        wordService.addWord("test1");
        wordService.addWord("test2");
        wordService.addWord("test3");
        wordService.resetAllWordCounts();
        assertEquals(0, wordService.getWordCount("test1"));
        assertEquals(0, wordService.getWordCount("test2"));
        assertEquals(0, wordService.getWordCount("test3"));
    }

    @Test
    public void testResetOneWordCounts(){
        wordService.addWord("test1");
        wordService.addWord("test2");
        wordService.addWord("test3");
        wordService.resetWordCount("test2");
        assertEquals(1, wordService.getWordCount("test1"));
        assertEquals(0, wordService.getWordCount("test2"));
        assertEquals(1, wordService.getWordCount("test3"));
    }
}
