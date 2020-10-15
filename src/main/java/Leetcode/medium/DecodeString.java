package Leetcode.medium;

import java.util.Stack;

/**
 * https://leetcode.com/problems/decode-string/
 *
 * Given an encoded string, return its decoded string.
 *
 * The encoding rule is: k[encoded_string], where the encoded_string inside the square brackets is being repeated exactly k times. Note that k is guaranteed to be a positive integer.
 *
 * You may assume that the input string is always valid; No extra white spaces, square brackets are well-formed, etc.
 *
 * Furthermore, you may assume that the original data does not contain any digits and that digits are only for those repeat numbers, k. For example, there won't be input like 3a or 2[4].
 *
 * Examples:
 *
 * s = "3[a]2[bc]", return "aaabcbc".
 * s = "3[a2[c]]", return "accaccacc".
 * s = "2[abc]3[cd]ef", return "abcabccdcdcdef".
 */
public class DecodeString {
    public static void main(String[] args) {
        final String input1 = "3[a]2[bc]";
        final String input2 = "3[a2[c]]";

        DecodeString solution = new DecodeString();
        solution.solve(input1);
    }

    private String solve(final String input) {
        String response = "";
        final Stack<Integer> count = new Stack<>();
        final Stack<String> word = new Stack<>();
        int index = 0;

        while (index < input.length()) {
            char character = input.charAt(index);

            if(Character.isDigit(character)) {
                int number = 0;
                while (Character.isDigit(input.charAt(index))) {
                    number = number * 10 + (input.charAt(index) - '0');
                    index ++;
                }
                count.push(number);
            } else if(character == '[') {
                word.push(response);
                response = "";
                index++;
            } else if(character == ']') {
                StringBuilder sb = new StringBuilder(word.pop());
                int number = count.pop();

                for(int i = 0; i < number; i ++) {
                    sb.append(response);
                }

                response = sb.toString();
                index++;
            } else {
                response += character;
                index++;
            }
        }

        System.out.println(response);
        return response;
    }
}
