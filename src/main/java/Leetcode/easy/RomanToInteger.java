package Leetcode.easy;

import java.util.*;

/**
 * https://leetcode.com/problems/roman-to-integer/
 */
public class RomanToInteger {
    private Map<String, RomanNumber> map = new HashMap<>();

    public static void main(String[] args) {
        RomanToInteger romanToInteger = new RomanToInteger();
        System.out.println(romanToInteger.romanToInt("CCXXVI"));
    }

    public int romanToInt(String s) {

        map.put("I", new RomanNumber("I", Arrays.asList("V", "X"), 1));
        map.put("V", new RomanNumber("V", new ArrayList<>(), 5));
        map.put("X", new RomanNumber("X", Arrays.asList("L", "C"), 10));
        map.put("L", new RomanNumber("L", new ArrayList<>(), 50));
        map.put("C", new RomanNumber("C", Arrays.asList("D", "M"), 100));
        map.put("D", new RomanNumber("D", new ArrayList<>(), 500));
        map.put("M", new RomanNumber("M", new ArrayList<>(), 1000));

        char[] chars = s.toCharArray();
        int result = 0;

        if(chars.length == 1) {
            return map.get(String.valueOf(chars[0])).number;
        }

        for(int i = 1; i <= chars.length; i ++) {
            RomanNumber number = map.get(String.valueOf(chars[i - 1]));

            if(number.canBeAddedBefore.size() > 0) {
                RomanNumber currentNumber = chars.length == i ? null :
                        map.get(String.valueOf(chars[i]));

                if(currentNumber != null &&
                        number.canBeAddedBefore.indexOf(currentNumber.value) >= 0) {
                    result += currentNumber.number - number.number;
                    i++;
                    continue;
                }
            }

            result += number.number;
        }

        return result;

    }
}

class RomanNumber {
    public String value;
    public List<String> canBeAddedBefore;
    public int number;

    public RomanNumber(String value, List<String> canBeAddedBefore, int number) {
        this.value = value;
        this.canBeAddedBefore = canBeAddedBefore;
        this.number = number;
    }
}
