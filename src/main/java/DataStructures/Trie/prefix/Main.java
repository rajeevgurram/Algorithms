package DataStructures.Trie.prefix;

import Utils.HttpUtils;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Trie trie = new Trie();
        TestPerformanceWithHashMap hashMap = new TestPerformanceWithHashMap();

        String data = HttpUtils.readDataFromURL("https://raw.githubusercontent.com/dwyl/english-words/master/words.txt");
        String[] words = data.split("\n");

        // adding the data to trie
        long startTime = System.currentTimeMillis();
        for(String word : words) {
            trie.add(word);
        }
        System.out.println("Took (" + (System.currentTimeMillis() - startTime) + ") MS to insert (" + words.length + ") Word(s) into Trie");

        // adding the data to hashMap
        startTime = System.currentTimeMillis();
        for(String word : words) {
            hashMap.add(word);
        }
        System.out.println("Took (" + (System.currentTimeMillis() - startTime) + ") MS to insert (" + words.length + ") Word(s) into HashMap");

        while (true) {
            System.out.println("\n\nEnter word to search");
            final String searchWord = new Scanner(System.in).nextLine();
            if(searchWord.equalsIgnoreCase("exit")) {
                break;
            }

            //Search in Trie
            startTime = System.currentTimeMillis();
            List<String> result = trie.search(searchWord);
            System.out.println(result);
            System.out.println("Took (" + (System.currentTimeMillis() - startTime) + ") MS to get (" + result.size() + ") Word(s) in Trie");
            System.out.println("\n");
            //Search in HashMap
            startTime = System.currentTimeMillis();
            result = hashMap.getWords(searchWord);
            System.out.println(result);
            System.out.println("Took (" + (System.currentTimeMillis() - startTime) + ") MS to get (" + result.size() + ") Word(s) in HashMap");
            System.out.println("====================================================================================");
        }
    }
}

class TestPerformanceWithHashMap {
    final Map<String, Integer> data = new HashMap<>();

    public void add(final String word) {
        data.put(word, 1);
    }

    public List<String> getWords(final String prefix) {
        List<String> words = new ArrayList<>();

        for(String word : data.keySet()) {
            if(word.startsWith(prefix)) {
                words.add(word);
            }
        }

        return words;
    }
}
