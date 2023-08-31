package Testw.Test2.Names;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/words")
public class WordController {

    private WordService wordService;


    @Autowired
    public WordController(WordService wordService) {
        this.wordService = wordService;
    }

    @PostMapping
    public ResponseEntity<String> addWord(@RequestBody String word) {
        wordService.addWord(word);
        return ResponseEntity.ok("Word added successfully.");
    }

    @GetMapping("/{word}")
    public String getWordCount(@PathVariable String word) {
        int count = wordService.getWordCount(word);
        return "Name was used " + count + " times";
    }

    @DeleteMapping("/{word}")
    public String getResetWordCount(@PathVariable String word){
        wordService.resetWordCount(word);
        return "Count for was reset for word: " + word;
    }

    @DeleteMapping("/")
    public String getResetAllWordCounts(){
        wordService.resetAllWordCounts();
        return "Count for all words was reset";
    }
}