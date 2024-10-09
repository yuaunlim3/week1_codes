package words;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Arrays;

public class wordAlpha {
    public static final String[] stopWords = {
        "i", "me", "my", "myself", "we", "our", "ours", "ourselves", "you", "your", "yours", "yourself", "yourselves", "he", "him", "his", "himself", "she", "her", "hers", "herself", "it", "its", "itself", "they", "them", "their", "theirs", "themselves", "what", "which", "who", "whom", "this", "that", "these", "those", "am", "is", "are", "was", "were", "be", "been", "being", "have", "has", "had", "having", "do", "does", "did", "doing", "a", "an", "the", "and", "but", "if", "or", "because", "as", "until", "while", "of", "at", "by", "for", "with", "about", "against", "between", "into", "through", "during", "before", "after", "above", "below", "to", "from", "up", "down", "in", "out", "on", "off", "over", "under", "again", "further", "then", "once", "here", "there", "when", "where", "why", "how", "all", "any", "both", "each", "few", "more", "most", "other", "some", "such", "no", "nor", "not", "only", "own", "same", "so", "than", "too", "very", "s", "t", "can", "will", "just", "don", "should", "now"
    };
    public static void main(String[] args) throws FileNotFoundException, IOException{
        File file = new File(args[0]);
        FileReader reader = new FileReader(file);
        BufferedReader bufferedReader = new BufferedReader(reader);

        //Create Map:
         Map<String, Integer> words = new HashMap<String, Integer >();
         String line = "a";

         while(line != null){
            line = bufferedReader.readLine();
            if (null == line){
                break;
            }
            String transformed = line.replaceAll("\\p{Punct}","");

            boolean isStopWord = false;

            transformed = transformed.toLowerCase();
            for(String item: transformed.split(" ")){
                for (String word : stopWords) {
                    if (item.equals(word)) {
                        isStopWord = true;
                        break;  
                    }
                }
                if (!isStopWord) {
                    if (words.containsKey(item)) {
                        words.put(item, words.get(item) + 1);
                    } else {
                        words.put(item, 1);
                    }
                }     
            }
        }
        
        String[] keyArray = words.keySet().toArray(new String[0]);
        Arrays.sort(keyArray);

        for(String word: keyArray){
            System.out.printf("KEY: %s  VALUE: %d \n",word,words.get(word));
         }
        
       } 

}
