package Challenges;

import java.util.*;

public class SuffixesOfString {
    public static void main(String[] args) {
        createSuffix("minimize");
    }

    private static List<String> createSuffix(final String word) {
        List<String> result = new ArrayList<>();

        for(int i = word.length() - 1; i >= 0; i --) {
            int space = 0;
            while(space++ < i) {
                System.out.print(" ");
            }
            String subString = word.substring(i);
            System.out.println(subString);
            result.add(subString);
        }

        System.out.println(result);
        return result;
    }
}
