package Algorithms.Sorting;

import Algorithms.Sorting.impl.BubbleSort;
import Algorithms.Sorting.impl.InsertionSort;
import Algorithms.Sorting.impl.MergeSort;
import Algorithms.Sorting.impl.SelectionSort;

import java.util.Arrays;

public class SortingTest {
    public static void main(String[] args) {
        Sort sort = new MergeSort();
        int[] numbers = {22, 55, 10, 1, -10, 43, 0};
        System.out.println("Before Sorting.\t" + Arrays.toString(numbers));
        sort.sort(numbers);
        System.out.println("After Sorting.\t" + Arrays.toString(numbers));
    }
}
