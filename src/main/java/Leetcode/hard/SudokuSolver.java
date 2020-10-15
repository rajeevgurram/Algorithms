package Leetcode.hard;

import java.util.Random;

public class SudokuSolver {
    final static int BOARD_SIZE = 9;
    final static int[][] BOARD = {
            {5,3,0,0,7,0,0,0,0},
            {6,0,0,1,9,5,0,0,0},
            {0,9,8,0,0,0,0,6,0},
            {8,0,0,0,6,0,0,0,3},
            {4,0,0,8,0,3,0,0,1},
            {7,0,0,0,2,0,0,0,6},
            {0,6,0,0,0,0,2,8,0},
            {0,0,0,4,1,9,0,0,5},
            {0,0,0,0,8,0,0,7,9}
    };
    final static int MIN_VALUE = 1;
    final static int MAX_VALUE = 9;

    public static void main(String[] args) {
        SudokuSolver sudokuSolver = new SudokuSolver();

//        for(int i = 0; i < BOARD_SIZE; i ++) {
//            for(int j = 0; j < BOARD_SIZE; j ++) {
//                BOARD[i][j] = 0;
//            }
//        }
//
//        Random rand = new Random();
//
//        for(int i = 0; i < 3; i ++) {
//            int randomRow = rand.nextInt((MAX_VALUE - 1 - MIN_VALUE) + 1) + MIN_VALUE;
//            int randomCol = rand.nextInt((MAX_VALUE - 1 - MIN_VALUE) + 1) + MIN_VALUE;
//            int randomValue = rand.nextInt((MAX_VALUE - MIN_VALUE) + 1) + MIN_VALUE;
//
//            BOARD[randomRow][randomCol] = randomValue;
//        }

        sudokuSolver.solve();
    }

    private void solve() {
        if(placeNumber(0, 0)) {
            printSudoku();
        } else {
            System.out.println("No feasible solution");
        }
    }

    private boolean placeNumber(int row, int column) {
        if(row == BOARD_SIZE && ++column == BOARD_SIZE) {
            return true;
        }

        if(row == BOARD_SIZE) {
            row = 0;
        }

        if(BOARD[row][column] != 0) {
            return placeNumber(row + 1, column);
        }

        for(int number = MIN_VALUE; number <= MAX_VALUE; number ++) {
            if(isValidNumberForCell(row, column, number)) {
                BOARD[row][column] = number;

                if(placeNumber(row + 1, column)) {
                    return true;
                }

                //BACKTRACK
                BOARD[row][column] = 0;
            }
        }

        return false;
    }

    private boolean isValidNumberForCell(final int row, final int column, final int number) {
        // checking in row if the number present.
        for(int i = 0; i < BOARD_SIZE; i ++) {
            if(BOARD[row][i] == number) {
                return false;
            }
        }

        // checking in column if the number present.
        for(int i = 0; i < BOARD_SIZE; i ++) {
            if(BOARD[i][column] == number) {
                return false;
            }
        }

        //checking in 3x3 matrix if the number present
        int currentMatrixRow = (row / 3) * 3;
        int currentMatrixCol = (column / 3) * 3;

        for(int i = 0; i < 3; i ++) {
            for(int j = 0; j < 3; j ++) {
                if(BOARD[currentMatrixRow + i][currentMatrixCol + j] == number) {
                    return false;
                }
            }
        }

        return true;
    }

    private void printSudoku() {
        for(int i = 0; i < BOARD_SIZE; i ++) {
            if(i % 3 == 0) {
                System.out.println("");
            }

            for(int j = 0; j < BOARD_SIZE; j ++) {
                if(j % 3 == 0) {
                    System.out.print(" ");
                }
                System.out.print(BOARD[i][j] + " ");
            }
            System.out.println("");
        }
    }
}
