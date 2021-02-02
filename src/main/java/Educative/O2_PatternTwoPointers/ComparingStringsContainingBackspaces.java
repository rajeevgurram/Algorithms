package Educative.O2_PatternTwoPointers;

import java.util.function.Function;

/**
 * Comparing Strings containing Backspaces (medium) #
 * Given two strings containing backspaces (identified by the character ‘#’), check if the two strings are equal.
 *
 * Example 1:
 *
 * Input: str1="xy#z", str2="xzz#"
 * Output: true
 * Explanation: After applying backspaces the strings become "xz" and "xz" respectively.
 * Example 2:
 *
 * Input: str1="xy#z", str2="xyz#"
 * Output: false
 * Explanation: After applying backspaces the strings become "xz" and "xy" respectively.
 * Example 3:
 *
 * Input: str1="xp#", str2="xyz##"
 * Output: true
 * Explanation: After applying backspaces the strings become "x" and "x" respectively.
 * In "xyz##", the first '#' removes the character 'z' and the second '#' removes the character 'y'.
 * Example 4:
 *
 * Input: str1="xywrrmp", str2="xywrrmu#p"
 * Output: true
 * Explanation: After applying backspaces the strings become "xywrrmp" and "xywrrmp" respectively.
 *
 */
public class ComparingStringsContainingBackspaces {
    public static void main(String[] args) {
        final String str1="xywrrmp", str2="xywrrmu#p";
        System.out.println(solution1(str1, str2));
    }

    private static boolean solution1(final String str1, final String str2) {
        Function<String, String> getString = s -> {
            char[] ch = new char[s.length()];
            int index = 0;
            for(int i = 0; i < s.length(); i++) {
                if(s.charAt(i) != '#') {
                    ch[index++] = s.charAt(i);
                } else {
                    ch[--index] = ' ';
                }
            }
            System.out.println(String.valueOf(ch));
            return String.valueOf(ch).trim();
        };

        return getString.apply(str1).equals(getString.apply(str2));
    }
}
