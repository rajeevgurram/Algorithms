package Leetcode.medium;

public class LetterCombinationsOfAPhoneNumber {
    final char[][] keyboard = {
            {},
            {'a', 'b', 'c'},
            {'d', 'e', 'f'},

            {'d', 'e', 'f'},
            {'g', 'h', 'i'},
            {'j', 'k', 'l'},

            {'m', 'n', 'o'},
            {'p', 'q', 'r', 's'},
            {'t', 'u', 'v'},
            {'w', 'x', 'y', 'z'}
    };
    public static void main(String[] args) {
        LetterCombinationsOfAPhoneNumber solution = new LetterCombinationsOfAPhoneNumber();
        solution.solve(2, 3);
    }

    private void solve(int num1, int num2) {
        char[] num1Chars = keyboard[num1 - 1];
        char[] num2Chars = keyboard[num2 - 1];

        for(int i = 0; i < num1Chars.length; i ++) {
            for(int j = 0; j < num2Chars.length; j ++) {
                System.out.print(num1Chars[i] + "" + num2Chars[j] + ", ");
            }
            System.out.println();
        }
    }
}
