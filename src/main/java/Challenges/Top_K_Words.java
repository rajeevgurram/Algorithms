package Challenges;

import Utils.HttpUtils;

import java.util.*;

public class Top_K_Words {
    public static void main(String[] args) {
        final String URL = "https://en.wikipedia.org/wiki/Lists_of_Dutch_inventions_and_discoveries";
        final String data = HttpUtils.readDataFromURL(URL);
        getTopKWords(data);
    }

    private static void getTopKWords(final String data) {
        final String[] words = data.split("\\s");
        final Map<String, Integer> map = new HashMap<>();

        PriorityQueue<String> maxHeap = new PriorityQueue<String>(new Comparator<String>() {
            @Override
            public int compare(String w1, String w2) {
                return map.get(w1).equals(map.get(w2)) ?
                        w2.compareTo(w1) : map.get(w1) - map.get(w2);
            }
        });

        for(final String word : words) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }

        for (String word: map.keySet()) {
            maxHeap.offer(word);
            if (maxHeap.size() > 3) {
                maxHeap.poll();
            };
        }

        List<String> ans = new ArrayList();
        while (!maxHeap.isEmpty()) {
            ans.add(maxHeap.poll());
        }
        Collections.reverse(ans);
        System.out.println(ans);
    }
}
