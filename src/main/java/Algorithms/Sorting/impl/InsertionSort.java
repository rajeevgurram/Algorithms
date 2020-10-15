package Algorithms.Sorting.impl;

import Algorithms.Sorting.Sort;

public class InsertionSort implements Sort {
    public void sort(int[] numbers) {
        for (int i = 1; i < numbers.length; i ++) {
            int newElement = numbers[i];
            int j;

            for (j = i; j > 0 && numbers[i - 1] > newElement; j--) {
                numbers[j] = numbers[j - 1];
            }
            numbers[j] = newElement;
        }
    }
}
