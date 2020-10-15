package Algorithms.Sorting.impl;

import Algorithms.Sorting.Sort;
import Utils.SortUtils;

/***
 * Selection sort finds the lowest number in each iteration and then
 * swaps.
 * Time Complexity: O(n2)
 * Space Complexity: In-Place Algorithm
 * Advantages: Less swaps than Bubble Sort.
 */
public class SelectionSort implements Sort {
    public void sort(int[] numbers) {
        for(int i = 0; i < numbers.length; i ++) {
            int smallNumberIndex = i;
            for(int j = i; j < numbers.length; j ++) {
                if(numbers[smallNumberIndex] > numbers[j]) {
                    smallNumberIndex = j;
                }
            }

            if(smallNumberIndex != i) {
                SortUtils.swap(numbers, i, smallNumberIndex);
            }
        }
    }
}
