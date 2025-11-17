import java.util.Map;
import java.util.TreeMap;

public class WordFrequencyTreeMap {
    public static void main(String[] args){
        // Given text with punctuation
        String str = "Hello, world! Hello java. Java is fun, world!";

        // 1. Remove punctuation (keep letters and spaces)
        str = str.replaceAll("[^a-zA-Z]"," ");

        // 2. Convert to lowercase for case-insensitive count
        str = str.toLowerCase();

        // 3. Split text into words (handle multiple spaces)
        String[] words = str.split("\\s+");

        // 4. Create TreeMap to store word -> frequency
        TreeMap<String,Integer> freq = new TreeMap<>();

        for(String word : words){
            if (freq.containsKey(word)){
                freq.put(word,freq.get(word)+1);
            }
            else {
                freq.put(word,1);
            }
        }

        //display freq
        System.out.println("Word Frequencies:");
        for(Map.Entry<String, Integer> entry : freq.entrySet()){
            System.out.println(entry.getKey()+" = "+entry.getValue());
        }
    }
}
