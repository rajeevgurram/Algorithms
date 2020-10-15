package Leetcode;


/*
    Given an array of integers, return indices of the two numbers such that they add up to a specific target.
    You may assume that each input would have exactly one solution, and you may not use the same element twice.

    Example:
    Given nums = [2, 7, 11, 15], target = 9,
    Because nums[0] + nums[1] = 2 + 7 = 9,
    return [0, 1].
*/

import Utils.Utils;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {
    private static final int NUMBER_OF_ELEMENTS = 500000000;
    public static void main(String[] args) {
        int[] elements = new int[NUMBER_OF_ELEMENTS];

        for(int i = 0; i < NUMBER_OF_ELEMENTS; i ++) {
            elements[i] = Utils.randomNumber(0, NUMBER_OF_ELEMENTS);
        }

        int target = Utils.randomNumber(0, NUMBER_OF_ELEMENTS);

         // Solution 1 Test
        long startTime = Utils.time();
        System.out.println("Searching for  " + target + " in the list");
        int[] result = TwoSum(elements, target);

        for(Integer i : result) {
            System.out.println("Index : " + i + ", Value : " + elements[i]);
        }

        long solution1DoneTime = Utils.time() - startTime;
        System.out.println("Solution 1 : Time took to get the result " + solution1DoneTime + " Ms");

        System.out.println("\n\n");

        // Solution 2 Test
        startTime = Utils.time();
        System.out.println("Searching for  " + target + " in the list");
        result = TwoSum(elements, target);

        for(Integer i : result) {
            System.out.println("Index : " + i + ", Value : " + elements[i]);
        }

        long solution2DoneTime = Utils.time() - startTime;
        System.out.println("Solution 2 : Time took to get the result " + solution2DoneTime + " Ms");

    }

    /*
        Solution 1:
        Time Complexity: O(n^2), because each element checks with other element
        Space Complexity: O(1)
    */
    private static int[] TwoSum(int[] arr, int target) {
        for(int i = 0; i < arr.length; i ++) {
            for(int j = 0; j < arr.length; j ++) {
                if(i != j) {
                    if((arr[i] + arr[j]) == target) {
                        return new int[] {i, j};
                    }
                }
            }
        }
        return new int[2];
    }

    /*
        Solution 2:
        Time Complexity: O(n)
        Space Complexity: O(n) will store all elements in worse case
    */
    private static int[] TwoSum2(int[] arr, int target) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for(int i = 0; i < arr.length; i ++) {
            int secondElement = target - arr[i];
            if(map.containsKey(secondElement)) {
                return new int[] {map.get(secondElement), i};
            }

            map.put(arr[i], i);
        }
        return new int[2];
    }
}
