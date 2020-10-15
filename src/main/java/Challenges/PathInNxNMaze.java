package Challenges;

import java.util.LinkedHashSet;
import java.util.Set;

/**
 * https://www.youtube.com/watch?v=keb6rP07Yqg&list=PLTZbNwgO5ebpqWBmBx0lpy9IYFMSQcrL-
 * Given a NXN maze, find a path from top left cell to bottom right
 * cell given that you can only move in cells for which M[i][j] = 1
 * you can make horizontal and vertical moves in the maze but no diagonal
 * move.
 */
public class PathInNxNMaze {
    private final int MAZE_SIZE = 5;
    private final int[][] MAZE = new int[][] {
            {1, 1, 1, 0, 0},
            {0, 0, 1, 0, 0},
            {1, 1, 1, 1, 0},
            {0, 1, 0, 0, 0},
            {0, 1, 1, 1, 1}
    };
    private final Set<String> path = new LinkedHashSet<>();
    private final int[] X_MOVES = new int[] {1, -1, 0, 0};
    private final int[] Y_MOVES = new int[] {0, 0, 1, -1};

    public static void main(String[] args) {
        PathInNxNMaze maze = new PathInNxNMaze();
        maze.solve();
    }

    private void solve() {
        if(MAZE[0][0] == 1) {
            MAZE[0][0] = 0;
            if(gotoNextPath(0, 0)) {
                print();
            } else {
                System.out.println("No feasible path found");
            }
        } else {
            System.out.println("Can't find path");
        }
    }

    private boolean gotoNextPath(int row, int column) {
        if(row == MAZE_SIZE - 1 && column == MAZE_SIZE - 1)  {
            return true;
        }

        for(int i = 0; i < X_MOVES.length; i ++) {
            int nextRow = row + X_MOVES[i];
            int nextColumn = column + Y_MOVES[i];

            if(isValidCell(nextRow, nextColumn)) {
                path.add(row + "->" + column);
                MAZE[nextRow][nextColumn] = 0;

                if(gotoNextPath(nextRow, nextColumn)) {
                    return true;
                }
                //BACKTRACKING
                path.remove(row + "->" + column);
                MAZE[nextRow][nextColumn] = 1;
            }
        }

        return false;
    }

    private boolean isValidCell(int row, int column) {
        if(row < 0 || row >= MAZE_SIZE ||
            column < 0 || column >= MAZE_SIZE) {
            return false;
        }

        if(MAZE[row][column] == 0) {
            return false;
        }

        return true;
    }

    private void print() {
        for(String s : path) {
            System.out.println(s);
        }
    }
}
