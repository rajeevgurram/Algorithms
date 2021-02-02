package Educative.O1_PatternSlidingWindow;

import java.util.HashMap;
import java.util.Map;

/**
 * Problem Statement #
 * Given a string with lowercase letters only, if you are allowed to replace no more than ‘k’
 * letters with any letter, find the length of the longest substring having the same letters after
 * replacement.
 *
 * Example 1:
 *
 * Input: String="aabccbb", k=2
 * Output: 5
 * Explanation: Replace the two 'c' with 'b' to have a longest repeating substring "bbbbb".
 * Example 2:
 *
 * Input: String="abbcb", k=1
 * Output: 4
 * Explanation: Replace the 'c' with 'b' to have a longest repeating substring "bbbb".
 * Example 3:
 *
 * Input: String="abccde", k=1
 * Output: 3
 * Explanation: Replace the 'b' or 'd' with 'c' to have the longest repeating substring "ccc".
 */
public class P_06_LongestSubstringWithSameLettersAfterReplacement {
    public static void main(String[] args) {
        System.out.println(solution("aabccbb", 2));
    }

    private static int solution(final String word, final int k) {
        int windowStart = 0;
        int maxLength = Integer.MIN_VALUE;
        int maxCharacterLength = Integer.MIN_VALUE;

        final Map<Character, Integer> countMap = new HashMap<>();

        for(int windowEnd = 0; windowEnd < word.length(); windowEnd ++) {
            Character rightChar = word.charAt(windowEnd);
            countMap.put(rightChar, countMap.getOrDefault(rightChar, 0) + 1);
            maxCharacterLength = Math.max(maxCharacterLength, countMap.get(rightChar));

            if(windowEnd - windowStart + 1 - maxCharacterLength > k) {
                Character leftChar = word.charAt(windowStart);
                countMap.put(leftChar, countMap.get(leftChar) - 1);
                windowStart++;
            }

            maxLength = Math.max(maxLength, windowEnd - windowStart + 1);
        }

        return maxLength;
    }
}
