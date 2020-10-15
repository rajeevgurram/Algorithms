package Challenges;
/**
 * 1
 * 11
 * 21
 * 1211
 * 111221
 * 1312211
 * 13112221
 * 1113213211
 * 31131211131221
 * 13211311123113112211
 */
public class LookAndSay {
    public static void main(String[] args) throws IllegalArgumentException {
        lookAndSay(4);
    }

    private static void lookAndSay(final int numOfRows) throws IllegalArgumentException {
        if(numOfRows <=0 ) {
            throw new IllegalArgumentException("number of rows should be greater than 0");
        }

        String number = "11";
        for(int i = 3; i < numOfRows; i ++) {
            String temp = "";
            number += '$';
            String[] numbers = number.split("");
            int count = 1;

            for(int j = 1; j < numbers.length; j ++) {
                if(!numbers[j].equals(numbers[j - 1])) {
                    temp += count;
                    temp += numbers[j - 1];
                } else {
                    count ++;
                }
            }

            number = temp;

            System.out.println(i);
            System.out.println(number);
            System.out.println("");System.out.println("");
        }
    }
}
