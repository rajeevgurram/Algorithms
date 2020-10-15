/***
 * Given an array of strings with only lowercase letters, 
 * create a function that returns an array of those same strings, 
 * but each string has its letters rearranged such that it becomes a 
 * palindrome (if possible, if not, return -1).
 */
package Challenges;

import java.util.Arrays;

public class MakeStringPalinDrome {
    public static void main(String[] args) throws Exception {
        String[] words = {"aabbcc", "abc", "abcde", "abcba", "gfkdl", "RRAAJJE", "RRAAJE", "aac"};
        String[] output = new String[words.length];
        for(int i = 0; i < words.length; i ++) {
            output[i] = createPalindrome(words[i]);
            System.out.println(output[i]);
        }
    }

    /**
     * Create Palindorme from given string.
     * @param word
     * @return
     */
    private static String createPalindrome(final String word) {
        char[] chars = word.toCharArray();
        Arrays.sort(chars);

        StringBuilder builder = new StringBuilder();

        int length = Math.abs(chars.length / 2);
        //divide whole word into left and right. ex: aabbccdde left: abcde, right: abcd
        char[] right = new char[length];
        Character middleChar = null;
        Boolean basicCheckPassed = false;

        int index = 0;
        //divide whole word into left and right. ex: aabbccdde left: abcde, right: abcd
        for(int i = 0; i < chars.length - 1; i += 2) {
            if(chars[i] != chars[i + 1]) {
                if(middleChar != null) {
                    return "-1";
                }
                middleChar = chars[i];
                i -= 1;
            } else {
                basicCheckPassed = true;
                builder.append(chars[i]);
                right[index++] = chars[i+1];
            }
        }

        if(!basicCheckPassed) {
            return "-1";
        }

        // Adding middle / last element in the middle.
        if(middleChar != null) {
            builder.append(middleChar);
        } else {
            if(chars.length % 2 != 0) {
                builder.append(chars[chars.length - 1]);
            }
        }
        
        // Reverse adding the right part to the builder to make it a palindrome
        for(int i = right.length - 1; i >= 0; i --) {
            builder.append(right[i]);
        }
 
        return builder.toString();
    }
}
