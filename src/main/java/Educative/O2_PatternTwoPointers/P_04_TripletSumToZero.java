package Educative.O2_PatternTwoPointers;

import java.util.*;

/**
 * Problem Statement #
 * Given an array of unsorted numbers, find all unique triplets in it that add up to zero.
 *
 * Example 1:
 *
 * Input: [-3, 0, 1, 2, -1, 1, -2]
 * Output: [-3, 1, 2], [-2, 0, 2], [-2, 1, 1], [-1, 0, 1]
 * Explanation: There are four unique triplets whose sum is equal to zero.
 * Example 2:
 *
 * Input: [-5, 2, -1, -2, 3]
 * Output: [[-5, 2, 3], [-2, -1, 3]]
 * Explanation: There are two unique triplets whose sum is equal to zero.
 */
public class P_04_TripletSumToZero {
    public static void main(String[] args) {
        int[] arr = {-3, 0, 1, 2, -1, 1, -2};
        System.out.println(Arrays.asList(solution(arr)));
    }

    private static List<List<Integer>> solution(final int[] arr) {
        Arrays.sort(arr);
        List<List<Integer>> response = new ArrayList<>();

        for(int i = 0; i < arr.length; i++) {
            searchPair(arr, -arr[i], i + 1, response);
        }

        return response;
    }

    private static void searchPair(int[] data, int target, int left, List<List<Integer>> response) {
        int right = data.length - 1;
        while (left < right) {
            int sum = data[left] + data[right];
            if(sum == target) {
                response.add(Arrays.asList(data[left], data[right], -target));
                left++;
                right--;
            } else if(sum > target) {
                right--;
            } else {
                left++;
            }
        }
    }
}
