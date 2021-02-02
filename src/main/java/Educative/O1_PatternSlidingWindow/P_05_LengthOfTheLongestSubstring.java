package Educative.O1_PatternSlidingWindow;

import java.util.HashMap;
import java.util.Map;

/**
 * Problem Statement #
 * Given a string, find the length of the longest substring which has no repeating characters.
 *
 * Example 1:
 *
 * Input: String="aabccbb"
 * Output: 3
 * Explanation: The longest substring without any repeating characters is "abc".
 * Example 2:
 *
 * Input: String="abbbb"
 * Output: 2
 * Explanation: The longest substring without any repeating characters is "ab".
 * Example 3:
 *
 * Input: String="abccde"
 * Output: 3
 * Explanation: Longest substrings without any repeating characters are "abc" & "cde".
 */
public class P_05_LengthOfTheLongestSubstring {
    public static void main(String[] args) {
        final String word = "aabccbb";
        System.out.println(findLengthOfLongestSubstring(word));
    }

    private static int findLengthOfLongestSubstring(final String word) {
        int windowStart = 0;
        int lengthOfLongestSubstring = Integer.MIN_VALUE;

        final Map<Character, Integer> characterIndexMap = new HashMap<>();
        for(int windowEnd = 0; windowEnd < word.length(); windowEnd ++) {
            char character = word.charAt(windowEnd);
            if(characterIndexMap.containsKey(character)) {
                windowStart = Math.max(windowStart, characterIndexMap.get(character) + 1);
            }
            characterIndexMap.put(character, windowEnd);
            lengthOfLongestSubstring = Math.max(lengthOfLongestSubstring, windowEnd - windowStart + 1);
        }

        return lengthOfLongestSubstring;
    }
}
