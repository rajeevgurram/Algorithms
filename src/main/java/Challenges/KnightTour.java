package Challenges;

/**
 * Knight Tour on a 8x8 Chess board
 */
public class KnightTour {
    private final int BOARD_LENGTH = 8;
    int[][] board = new int[BOARD_LENGTH][BOARD_LENGTH];
    private int index = 0;

    private final int[] X_MOVES = {2, 1, -1, -2, -2, -1, 1, 2};
    private final int[] Y_MOVES = {1, 2, 2, 1, -1, -2, -2, -1};

    public static void main(String[] args) {
        KnightTour tour = new KnightTour();
        tour.solve();
    }

    public void solve() {
        board[0][0] = 1;
        if(placeKnight(2, 0, 0)) {
            print();
        } else {
            System.out.println("No feasible solution");
        }
    }

    private boolean placeKnight(int index, int row, int column) {
        if(index == BOARD_LENGTH * BOARD_LENGTH + 1) {
            return true;
        }

        for(int i = 0; i < BOARD_LENGTH; i ++) {
            int newRow = row + X_MOVES[i];
            int newColumn = column + Y_MOVES[i];

            if(isValidCell(newRow, newColumn)) {
                board[newRow][newColumn] = index;

                if (placeKnight(index + 1, newRow, newColumn)) {
                    return true;
                }

                //BACKTRACKING
                board[newRow][newColumn] = 0;
            }
        }

        return false;
    }

    private boolean isValidCell(int row, int column) {
        if(row < 0 || row >= BOARD_LENGTH ||
           column < 0 || column >= BOARD_LENGTH ||
           board[row][column] != 0) {
            return false;
        }

        return true;
    }

    private void print() {
        for(int i = 0; i < BOARD_LENGTH; i ++) {
            for(int j = 0; j < BOARD_LENGTH; j ++) {
                System.out.print(board[i][j] + "\t");
            }
            System.out.println("\r");
        }
    }
}
