package Educative.O1_PatternSlidingWindow;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Given a string, find the length of the longest substring in it
 * with no more than K distinct characters.
 *
 * Example 1:
 *
 * Input: String="araaci", K=2
 * Output: 4
 * Explanation: The longest substring with no more than '2' distinct characters is "araa".
 * Example 2:
 *
 * Input: String="araaci", K=1
 * Output: 2
 * Explanation: The longest substring with no more than '1' distinct characters is "aa".
 * Example 3:
 *
 * Input: String="cbbebi", K=3
 * Output: 5
 * Explanation: The longest substrings with no more than '3'
 * distinct characters are "cbbeb" & "bbebi".
 */
public class LongestSubstringWithKDistinctCharacters {
    public static void main(String[] args) {
        String str = "araaci";
        int k = 1;
        System.out.println(findLongestSubstringWithKDistinctCharacters(str, k));
    }

    private static int findLongestSubstringWithKDistinctCharacters(final String str, int k) {
        int longestStringSize = Integer.MIN_VALUE;
        int windowStart = 0;
        int windowLongestStringSize = 0;

        Set<Character> uniqueCharacterSet = new HashSet<>();

        for(int windowEnd = 0; windowEnd < str.length(); windowEnd++) {
            Character ch = str.charAt(windowEnd);
            if(!uniqueCharacterSet.contains(ch)) {
                uniqueCharacterSet.add(ch);
            }

            if(uniqueCharacterSet.size() > k) {
                windowLongestStringSize = windowEnd - windowStart;
                longestStringSize = Math.max(windowLongestStringSize, longestStringSize);
                uniqueCharacterSet.remove(str.charAt(windowStart++));
            }
        }

        return longestStringSize;
    }
}
