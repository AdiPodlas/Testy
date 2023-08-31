package Testw.Test2.Names;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;


@Component
@Service
public class WordService {

    private Map<String, Integer> wordCountMap;

    public WordService() {
        this.wordCountMap = new HashMap<>();
    }

    public void addWord(String word) {
        wordCountMap.put(word, getWordCount(word) + 1);
        System.out.println("Dodajemy słowo" + word);
    }

    public int getWordCount(String word) {
      //  Integer count = wordCountMap.get(word);
      //  if (count == null){
      //      return 0;
      //  }
      //  return count;
       System.out.println("Zliczamy ile razy słowo zostalo dodane" + word);
        return wordCountMap.getOrDefault (word, 0);
    }

    public void resetWordCount(String word) {
        wordCountMap.remove(word);
    }

    public void resetAllWordCounts() {
        wordCountMap.clear();
    }
}