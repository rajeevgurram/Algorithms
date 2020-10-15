package Leetcode.hard;

import java.util.HashMap;
import java.util.Map;

/**
 * TODO
 */
public class IntegerToEnglishWords {
    final static String[] LESS_THAN_20 = {"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
    final static String[] TENS = {"", "Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
    final static String[] BIG = {"", "Hundred", "Thousand", "Million", "Billion"};

    public static void main(String[] args) {
        String result = integerToEnglishWord(123);
        System.out.println(result);
    }

    public static String integerToEnglishWord(final int number) {
        if(number == 0) {
            return "Zero";
        }

        String result = "";
        char[] numbers = String.valueOf(number).toCharArray();
        for(int i = 0; i < numbers.length; i ++) {
            int digit = Integer.parseInt(String.valueOf(numbers[i]));
            result = result + " " + LESS_THAN_20[i + 1];
        }

        return result;
    }
}
