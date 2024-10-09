package worddistribution;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Console;


public class Main {
    public static void main(String[] args) throws FileNotFoundException, IOException {
        
        //Read the file
        File file = new File(args[0]);
        FileReader reader = new FileReader(file);
        BufferedReader bufferedReader = new BufferedReader(reader);
        Console cons = System.console();

        //Storage for the different words 
        Words wordList = new Words();

        String line = "a";
        String previousWord = null;

         while(line != null){
            line = bufferedReader.readLine();
            if (null == line){
                break;
            }
            String transformed =line.replaceAll("\\p{Punct}","").trim();
            transformed = transformed.toLowerCase();
            //System.out.println(line);
            for(String item: transformed.split(" ")){
                if (previousWord!=null){
                    Word next = new Word(item);
                    //System.out.println(next.getWord());
                    wordList.addWord(previousWord, next);
                }
                previousWord = item;
            }
            previousWord = null;
        }

        
        //for (String item : wordList.wordList.keySet()) {
          // System.out.printf("Word: %s\n", item);
           // for (Word word : wordList.wordList.get(item)) {
           //   System.out.printf("Next Word: %s, Appearance: %d\n", word.getWord(), word.getCounter());
         // }
          //System.out.println(" ");
        //   System.out.printf("Next Word: %s\n", wordList.chooseWord(item));
       // }

        //Write some words
        String word = cons.readLine("CMD> ").trim();
        reader.close();
        while(word != null){
            //for (Word item : wordList.wordList.get(word)) {
            //    System.out.printf("Word: %s, Appearance: %d\n", item.getWord(), item.getCounter());
            //}
            word = wordList.chooseWord(word);
            System.out.printf("%s ", word);
        }
    }
}
