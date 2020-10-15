package Algorithms.Sorting.impl;

import Algorithms.Sorting.Sort;

/**
 * Divide and Conquer
 * Divide the whole array into half until each array has only
 * one element
 * Then merge left and right
 * O(nlogn)
 * NOT - IN Place Algorithm (So many new arrays.)
 * Consider this if memory is not a problem
 */
public class MergeSort implements Sort {
    @Override
    public void sort(int[] numbers) {
        mergeSort(numbers, 0, numbers.length);
    }

    private void mergeSort(int[] numbers, int start, int end) {
        if((end - start) < 2) {
            return;
        }

        int middleIndex = (start + end) / 2;
        mergeSort(numbers, start, middleIndex);
        mergeSort(numbers, middleIndex, end);
        merge(numbers, start, middleIndex, end);
    }

    private void merge(int[] numbers, int start, int mid, int end) {
        if(numbers[mid - 1] <= numbers[mid]) {
            return;
        }

        int i = start;
        int j = mid;

        int index = 0;
        int[] temp = new int[end - start];
        while (i < mid && j < end) {
            temp[index++] = numbers[i] < numbers[j]
                    ? numbers[i++] : numbers[j++];
        }
        while (i < mid) {
            temp[index++] = numbers[i++];
        }
        while (j < end) {
            temp[index++] = numbers[j++];
        }
        //System.arraycopy(numbers, i, numbers, start + index, mid - i);
        System.arraycopy(temp, 0, numbers, start, index);
    }
}
