package Leetcode.easy;

/**
 * URL: https://leetcode.com/problems/toeplitz-matrix/
 *
 * A matrix is Toeplitz if every diagonal from top-left to bottom-right has the same element.
 *
 * Now given an M x N matrix, return True if and only if the matrix is Toeplitz.
 *
 *
 * Example 1:
 *
 * Input:
 * matrix = [
 *   [1,2,3,4],
 *   [5,1,2,3],
 *   [9,5,1,2]
 * ]
 * Output: True
 * Explanation:
 * In the above grid, the diagonals are:
 * "[9]", "[5, 5]", "[1, 1, 1]", "[2, 2, 2]", "[3, 3]", "[4]".
 * In each diagonal all elements are the same, so the answer is True.
 */
public class ToeplitzMatrix {
    public static void main(String[] args) {
        final int[][] matrix = {
                {1, 2, 3, 4},
                {5, 1, 2, 3},
                {9, 5, 1, 2}
        };
        final int M = matrix.length, N = matrix[0].length;

        ToeplitzMatrix solution = new ToeplitzMatrix();
        solution.solve(matrix, M, N);
        solution.isToeplitzMatrix(matrix);
    }

    private void solve(int[][] matrix, int rows, int columns) {
        boolean isValid = true;
        for(int i = 0; i < rows; i++) {
            for(int j = 0; j < columns; j ++) {
                if(!isToeplitzMatrix(matrix, i, j)) {
                    isValid = false;
                    break;
                }
            }
            if(!isValid) {
                break;
            }
        }

        if(isValid) {
            System.out.println("It is ToeplitzMatrix");
        } else {
            System.out.println("It is not ToeplitzMatrix");
        }
    }

    private boolean isToeplitzMatrix(int[][] matrix, int row, int column) {
        if(row < 0 || row >= matrix.length || row + 1 == matrix.length ||
            column < 0 || column >= matrix[0].length || column + 1 == matrix[0].length) {
            return true;
        }

        if(matrix[row][column] == matrix[row + 1][column + 1]) {
            return isToeplitzMatrix(matrix, row + 1, column + 1);
        }

        return false;
    }

    public boolean isToeplitzMatrix(int[][] matrix) {
        if(matrix.length < 1 && matrix[0].length < 1) {
            return true;
        }

        for(int i = 1; i < matrix.length; i ++) {
            for(int j = 1; j < matrix[i].length; j++) {
                if(matrix[i][j] != matrix[i-1][j-1]) {
                    return false;
                }
            }
        }
        return true;
    }
}
