package Leetcode;

public class PalindromeNumber {
    public static void main(String[] args) {
        System.out.println(isPalindrome_2(121));
    }

    // O(n) Solution
    private static boolean isPalindrome(int number) {
        if(number < 0) return false;

        int reverse = 0;
        int temp = number;
        while(number != 0) {
            int mod = number % 10;
            number /= 10;

            if(reverse > Integer.MAX_VALUE / 10) return false;
            if(reverse < Integer.MIN_VALUE / 10) return false;

            reverse = (reverse * 10) + mod;
        }
        return temp == reverse;
    }

    // O(n/2) Solution
    private static boolean isPalindrome_2(int number) {
        if(number < 0) return false;

        String number_str = String.valueOf(number);
        int start = 0, end = number_str.length() - 1;

        while(start < end) {
            if(number_str.charAt(start++) != number_str.charAt(end--)) return false;
        }
        return true;
    }
}
