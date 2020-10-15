package Challenges;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

public class KnightTourOnDialPad {
    int[][] dialPad = new int[][] {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9},
            {-1, 0, -1}
    };
    private final int[] X_MOVES = {2, 1, -1, -2, -2, -1, 1, 2};
    private final int[] Y_MOVES = {1, 2, 2, 1, -1, -2, -2, -1};

    Set<String> paths = new LinkedHashSet<>();

    public static void main(String[] args) {
        KnightTourOnDialPad tour = new KnightTourOnDialPad();
        tour.solve();
    }

    private void solve() {
        int index = 1;
        dialPad[0][0] = index++;
        placeKnight(index, 0, 0);
        print();
    }

    private void print() {
        for(String s : paths) {
            System.out.println(s);
        }
    }

    private boolean placeKnight(int index, int row, int column) {
        for(int i = 0; i < X_MOVES.length; i ++) {
            int newRow = row + X_MOVES[i];
            int newColumn = column + Y_MOVES[i];

            if(isValidMove(row, column, newRow, newColumn)) {
                paths.add(dialPad[row][column] + "->" + dialPad[newRow][newColumn]);
                if(placeKnight(index + 1, newRow, newColumn)) {
                    return true;
                }

                //BACKTRACKING
                //paths.remove(/*dialPad[row][column] +*/ "->" + dialPad[newRow][newColumn]);
            }
        }
        return false;
    }

    private boolean isValidMove(int row, int column, int newRow, int newColumn) {
        if(newRow < 0 || newRow >= dialPad.length ||
           newColumn < 0 || newColumn >= dialPad[0].length) {
            return false;
        }

        if(paths.contains(dialPad[row][column] + "->" + dialPad[newRow][newColumn])) {
            return false;
        }

        return true;
    }
}
