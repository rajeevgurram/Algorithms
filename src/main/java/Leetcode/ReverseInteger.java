package Leetcode;

public class ReverseInteger {
    public static void main(String[] args) {
        System.out.println(reverse(-123));
    }

    private static int reverse(int number) {
        int reverse = 0;

        while(number != 0) {
            int mod = number % 10;
            number /= 10;

            if(reverse > Integer.MAX_VALUE / 10) return 0;
            if(reverse < Integer.MIN_VALUE / 10) return 0;

            reverse = (reverse * 10) + mod;
        }

        return reverse;
    }
}
