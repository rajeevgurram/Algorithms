package Challenges;

public class NQueensProblem {
    int[][] board;
    int numberOfQueens;

    public NQueensProblem(int numberOfQueens) {
        board = new int[numberOfQueens][numberOfQueens];
        this.numberOfQueens = numberOfQueens;
    }

    public static void main(String[] args) {
        NQueensProblem problem = new NQueensProblem(4);
        problem.solve();
    }

    private void solve() {
        if(placeQueen(0)) {
            printBoard();
        } else {
            System.out.println("No solution");
        }
    }

    private boolean placeQueen(int colIndex) {
        if(colIndex == numberOfQueens) {
            return true;
        }

        for(int rowIndex = 0; rowIndex < board.length; rowIndex ++) {
            if(isPlaceValid(rowIndex, colIndex)) {
                board[rowIndex][colIndex] = 1;

                if(placeQueen(colIndex + 1)) {
                    return true;
                }

                //BACKTRACKING
                board[rowIndex][colIndex] = 0;
            }
        }

        return false;
    }

    private boolean isPlaceValid(int rowIndex, int colIndex) {
        // Checking if there is another queen
        // in the same row
        for(int i = 0; i < colIndex; i++) {
            if(board[rowIndex][i] == 1) {
                return false;
            }
        }

        // Diagonal
        for(int i = rowIndex, j = colIndex; i >= 0 && j >=0; i--, j--) {
            if(board[i][j] == 1) {
                return false;
            }
        }
        for(int i = rowIndex, j = colIndex; i < board.length && j >=0; i++, j--) {
            if(board[i][j] == 1) {
                return false;
            }
        }
        return true;
    }

    private void printBoard() {
        for(int i = 0; i < board.length; i ++) {
            for(int j = 0; j < board[i].length; j ++) {
                if(board[i][j] == 1) {
                    System.out.print(" * ");
                } else {
                    System.out.print(" - ");
                }
            }
            System.out.println();
        }
    }
}
