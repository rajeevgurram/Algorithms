package Algorithms.Sorting.impl;

import Algorithms.Sorting.Sort;
import Utils.SortUtils;

/***
 * Most inefficient algorithm, it swap (every time) the small / big number when found.
 * Time Complexity: O(n2) (Quadratic)
 * Space Complexity: No new array created. (In-place algorithm)
 */

public class BubbleSort implements Sort {
    @Override
    public void sort(int[] numbers) {
        int steps = 0;
        for(int i = 0; i < numbers.length; i ++) {
            for(int j = i + 1; j < numbers.length; j ++) {
                steps ++;
                if(numbers[i] > numbers[j]) {
                    SortUtils.swap(numbers, i, j);
                }
            }
        }
        System.out.println("took (" + steps + ") steps to sort (" + numbers.length + ") numbers");
    }
}
