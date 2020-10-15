package Leetcode.medium;

/**
 * Given a 2D grid map of '1's (land) and '0's (water),
 * count the number of islands. An island is surrounded by water and
 * is formed by connecting adjacent lands horizontally or vertically.
 * You may assume all four edges of the grid are all surrounded by water.
 *
 *  Example 1:
 *  Input:
 *  11110
 *  11010
 *  11000
 *  00000
 * Output: 1
 *
 * Example 2:
 *  Input:
 *  11000
 *  11000
 *  00100
 *  00011
 * Output: 3
 */

import java.util.*;

/**
 * https://www.youtube.com/watch?v=CLvNe-8-6s8
 */
public class NumberOfIslands {
    public static void main(String[] args) {
        NumberOfIslands islands = new NumberOfIslands();
        char[][] grid = {{'1', '1', '1', '1', '0'},
                {'1', '1', '0', '1', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '0', '0', '0'}};
        System.out.println(islands.numberOfIslands(grid));

    }

    public int numberOfIslands(char[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }

        int islands = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                // We are interested if the value is 1
                // and increase the island count by 1
                if (grid[i][j] == '1') {
                    islands += bfs(grid, i, j);
                }
            }
        }
        return islands;
    }

    public int bfs(char[][] grid, int i, int j) {
        if (i < 0 || i >= grid.length ||
                j < 0 || j >= grid[i].length ||
                grid[i][j] == '0') {
            return 0;
        }

        // make 0's so we don't over count / revisit this again
        grid[i][j] = '0';
        bfs(grid, i + 1, j); // Down
        bfs(grid, i - 1, j); // Up
        bfs(grid, i, j + 1); // Right
        bfs(grid, i, j - 1); // Left
        return 1;
    }
}
