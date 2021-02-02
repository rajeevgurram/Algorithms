package Educative.O1_PatternSlidingWindow;

import java.util.*;

/**
 * 04. Fruits into Baskets (medium)
 *
 * Problem Statement #
 * Given an array of characters where each character represents a
 * fruit tree, you are given two baskets and your goal is to put
 * maximum number of fruits in each basket. The only restriction
 * is that each basket can have only one type of fruit.
 *
 * You can start with any tree, but once you have started you can’t
 * skip a tree. You will pick one fruit from each tree until you
 * cannot, i.e., you will stop when you have to pick from a third
 * fruit type.
 *
 * Write a function to return the maximum number of fruits in both
 * the baskets.
 *
 * Example 1:
 *
 * Input: Fruit=['A', 'B', 'C', 'A', 'C']
 * Output: 3
 * Explanation: We can put 2 'C' in one basket and one 'A' in the
 * other from the subarray ['C', 'A', 'C']
 * Example 2:
 *
 * Input: Fruit=['A', 'B', 'C', 'B', 'B', 'C']
 * Output: 5
 * Explanation: We can put 3 'B' in one basket and two 'C' in the
 * other basket.
 * This can be done if we start with the second letter:
 * ['B', 'C', 'B', 'B', 'C']
 */
public class P_04_FruitsIntoBaskets {
    public static void main(String[] args) {
        final Character[] fruits = {'A', 'B', 'C', 'B', 'B', 'C'};
        System.out.println(findMaxNumberOfFruitsInAllBaskets(fruits));
    }

    private static int findMaxNumberOfFruitsInAllBaskets(final Character[] fruits) {
        if(fruits.length <= 2) {
            return fruits.length;
        }

        int totalMax = Integer.MIN_VALUE;
        int windowStart = 0;

        Map<Character, Integer> baskets = new HashMap<>();

        for(int windowEnd = 0; windowEnd < fruits.length; windowEnd ++) {
            Character fruit = fruits[windowEnd];
            baskets.put(fruit, baskets.getOrDefault(fruit, 0) + 1);

            while (baskets.size() > 2) {
                baskets.put(fruits[windowStart], baskets.get(fruits[windowStart]) - 1);
                if(baskets.get(fruits[windowStart]) == 0) {
                    baskets.remove(fruits[windowStart]);
                    windowStart++;
                }
            }

            totalMax = Math.max(totalMax, windowEnd - windowStart + 1);
        }

        return totalMax;
    }

    private static Character findDiscardingBasket(final Character previousBasket,
                                                  final Map<Character, List<Character>> baskets) {
        for(Character basket : baskets.keySet()) {
            if(previousBasket != basket) {
                return basket;
            }
        }

        return null;
    }
}
