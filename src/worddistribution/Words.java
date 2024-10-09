package worddistribution;

import java.util.*;
import java.security.SecureRandom;

public class Words {
    protected Map<String, List<Word>> wordList; // Use List instead of ArrayList

    public Words() {
        this.wordList = new HashMap<>();

    }
    public void addWord(String word, Word nextWord) {
            // Initialize the list if the word is not present
            if (!this.wordList.containsKey(word)) {
                this.wordList.put(word, new ArrayList<>());
            }
            
            // Get the list of next words for the current word
            List<Word> nextWords = this.wordList.get(word);
            boolean found = false; // Flag to check if nextWord already exists
    
            for (Word item :nextWords) {
                if (nextWord.getWord().equals(item.getWord())) {
                    // If word is already in the list, update its counter
                    item.setCounter(item.getCounter() + 1);
                    found = true; // Mark as found
                    break; // Exit the loop since we found the word
                }
            }
            
            // If nextWord was not found, add it as a new entry
            if (!found) {
                nextWords.add(nextWord); // Add the next word to the list
            }

            //for (Word item :nextWords){
            //    System.out.printf("ITEM: %s ,ADDED ITEM: %s\n",word ,item.getWord());
            //}

            //System.out.println("");
    }
    

    public ArrayList<String> key(){
        ArrayList<String> words = new ArrayList<String>();
        for(String item: this.wordList.keySet()){
            words.add(item);
        }

        return words;
    }

    public List<Word> get(String word){
        return this.wordList.get(word);
    }

    public String chooseWord(String name) {

        if (!this.wordList.containsKey(name)) {
            return null;  // Or handle the case where the word doesn't exist
        }

        ArrayList<Word> words = new ArrayList<>();
    
        // Populate the words list based on their counter
        for (Word word : this.wordList.get(name)) {
            // Change the loop condition here
            for (int i = 0; i < word.getCounter(); i++) {
                //System.out.println(word.getWord());
                words.add(word);
            }
        }

        //System.out.println(words.size());        
        int size = words.size();
        
        // Check if the list is empty before proceeding
        if (size == 0) {
            return null; // or throw an exception, or handle it as needed
        }

        //System.out.println(size);
    
        Random rand = new SecureRandom();
        int num = rand.nextInt(size);
        Word randWord = words.get(num);

        //System.out.println(randWord.getWord());
        //System.out.println("");

        return randWord.getWord();
    }
    
}
