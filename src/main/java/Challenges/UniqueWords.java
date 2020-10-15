/**
 *  Design a system that can efficiently scale and store 
 *  the count of all unique words from a very large 
 *  document-based corpus of text.   
 */
package Challenges;

import Utils.HttpUtils;
import java.util.HashMap;
import java.util.Map;

class UniqueWords {
    public static void main(final String[] args) {
        final String URL = "https://en.wikipedia.org/wiki/Lists_of_Dutch_inventions_and_discoveries";
        final String data = HttpUtils.readDataFromURL(URL);
        findUnique(data);
    }

    public static void findUnique(final String data) {
        int uniqueWords = 0;
        final String[] words = data.split("\\s");
        final Map<String, Integer> wordMap = new HashMap<>();

        for(String word : words) {
            if(!wordMap.containsKey(word)) {
                wordMap.put(word, 1);
                uniqueWords++;
            } else {
                wordMap.put(word, wordMap.get(word) + 1);
            }
        }

        System.out.println("Total Words: " + words.length);
        System.out.println("Unique Words: " + uniqueWords);
        System.out.println("Duplicate Words: " + (words.length - uniqueWords));
    }
}
