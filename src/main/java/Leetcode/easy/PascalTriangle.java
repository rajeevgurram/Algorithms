package Leetcode.easy;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/pascals-triangle/
 */
public class PascalTriangle {
    public static void main(String[] args) {
        printPascalTriangle(10);
    }

    public static void printPascalTriangle(final int numRows) {
        List<List<Integer>> data = new ArrayList<List<Integer>>();
        if(numRows <= 0) {
            return;
        }

        List<Integer> newRow = new ArrayList<Integer>();
        newRow.add(1);
        data.add(newRow);

        for(int i = 1; i < numRows; i ++) {
            newRow = new ArrayList<Integer>();
            List<Integer> lastRow = data.get(i - 1);
            newRow.add(1);
            for(int value = 1; value < lastRow.size(); value ++) {
                int sum = lastRow.get(value) + lastRow.get(value - 1);
                newRow.add(sum);
            }
            newRow.add(1);
            data.add(newRow);
        }
        System.out.println(data);
    }
}
