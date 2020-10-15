package Leetcode.medium;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode.com/problems/set-matrix-zeroes/
 *
 * Given a m x n matrix, if an element is 0, set its entire row and column to 0. Do it in-place.
 *
 * Example 1:
 *
 * Input:
 * [
 *   [1,1,1],
 *   [1,0,1],
 *   [1,1,1]
 * ]
 * Output:
 * [
 *   [1,0,1],
 *   [0,0,0],
 *   [1,0,1]
 * ]
 *
 * Example 2:
 *
 * Input:
 * [
 *   [0,1,2,0],
 *   [3,4,5,2],
 *   [1,3,1,5]
 * ]
 * Output:
 * [
 *   [0,0,0,0],
 *   [0,4,5,0],
 *   [0,3,1,0]
 * ]
 */
public class SetMatrixZeroes {
    static int[][] matrix = {
            {1, 1, 2, 1},
            {3, 4, 5, 2},
            {1, 3, 0, 5}
    };
    private static Set<String> visitedSet = new HashSet<>();

    public static void main(String[] args) {
        SetMatrixZeroes solution = new SetMatrixZeroes();
        solution.print();
        solution.setZeroes(matrix);
        solution.print();
    }

    private void solve1(int[][] matrix) {
        for(int i = 0; i < matrix.length; i ++) {
            for(int j = 0; j < matrix[i].length; j ++) {
                if(matrix[i][j] == 0 && !visitedSet.contains(i + "-" + j)) {
                    makeZero(i, j);
                }
            }
        }
    }

    private void makeZero(int row, int column) {
        // Row
        for(int i = 0; i < matrix[row].length; i ++) {
            if(matrix[row][i] != 0) {
                matrix[row][i] = 0;
                visitedSet.add(row + "-" + i);
            }
        }

        // Column
        for(int i = 0; i < matrix.length; i ++) {
            if (matrix[i][column] != 0) {
                matrix[i][column] = 0;
                visitedSet.add(i + "-" + column);
            }
        }
    }

    private void print() {
        for(int i = 0; i < matrix.length; i ++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println("");
        }
        System.out.println("\n");
    }

    public void setZeroes(int[][] matrix) {

        // The below two vars store the state of first row and first col
        boolean isFirstRowZero = false , isFirstColZero = false;

        for(int i=0; i<matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    if (i == 0) isFirstRowZero = true;       // Store state of firstRow
                    if (j == 0) isFirstColZero = true;       // Store state of firstCol
                    matrix[0][j] = 0;                       // Store state of other row in firstRow
                    matrix[i][0] = 0;                       // Store state of other col in firstCol
                }
            }
        }

        for(int i=1; i<matrix.length; i++) {
            for (int j = 1; j < matrix[0].length; j++) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) {  // If the first cell of row or col is zero
                    matrix[i][j] = 0;                       // Mark the current cell as 0
                }
            }
        }

        if(isFirstRowZero) {                                 // if entire firstRow is to be zero
            for (int i = 0; i < matrix[0].length; i++) {
                matrix[0][i] = 0;                           // make them all zero
            }
        }

        if(isFirstColZero) {                                 // if entire firstCol is to be zero
            for (int i = 0; i < matrix.length; i++) {
                matrix[i][0] = 0;                           // make them all zero
            }
        }
    }
}
