package Interviews;

import java.util.*;

/***
 * Given list of strings, and pattern return the list of strings that matches the pattern
 *
 * ex: ["abc", "def", "book", "aba"], pattern: xyz.
 * output => ["abc", "def"]
 * book and aba patterns not matching either size or pattern
 *
 * ex2: ["aab", "abb", "aba", "zoo"], pattern: foo.
 * output => ["abb", "zoo"]
 */
public class FB_PatternMatching {
    public static void main(String[] args) {
        //String[] data = {"abc", "def", "book", "aba"};
        //final String pattern = "xyz";
        String[] data = {"aab", "abb", "aba", "zoo"};
        final String pattern = "foo";

        List<String> list = new ArrayList(Arrays.asList(data));
        //System.out.println(getMatchedList(list, pattern));
        System.out.println(getMatchedList_Solution2(list, pattern));
    }

    // Solution 1.
    private static List<String> getMatchedList(final List<String> dict, final String pattern) {
        List<String> result = new ArrayList<>();

        char[] patternChars = pattern.toCharArray();

        for(int i = 0; i < dict.size(); i ++) {
            String word = dict.get(i);

            if(pattern.length() != word.length()) {
                continue;
            }

            boolean matched = true;
            Map<Character, Integer> patternMap = new HashMap<>();
            Map<Character, Integer> wordMap = new HashMap<>();

            for(int j = 0; j < patternChars.length; j ++) {
                if(patternMap.get(patternChars[j]) != wordMap.get(word.charAt(j))) {
                    matched = false;
                    break;
                } else {
                    patternMap.put(patternChars[j], j);
                    wordMap.put(word.charAt(j), j);
                }
            }

            if(matched) {
                result.add(word);
            }
        }

        return result;
    }

    // Solution 2
    private static List<String> getMatchedList_Solution2(final List<String> dict, final String pattern) {

        class StringPattern {
            public int getPatternFromString(final String pattern) {
                char[] chars = pattern.toCharArray();
                int index = 0;
                Map<Character, Integer> charMap = new HashMap<>();
                String result = "";

                for(char c : chars) {
                    Integer data = charMap.get(c);

                    if(data == null) {
                        charMap.put(c, index ++);
                    }

                    result += charMap.get(c);
                }

                return Integer.valueOf(result);

            }
        }

        final List<String> result = new ArrayList<>();
        StringPattern stringPattern = new StringPattern();
        int patternInt = stringPattern.getPatternFromString(pattern);

        for(String word : dict) {
            int wordPattern = stringPattern.getPatternFromString(word);
            if(patternInt == wordPattern) {
                result.add(word);
            }
        }

        return result;
    }
}
