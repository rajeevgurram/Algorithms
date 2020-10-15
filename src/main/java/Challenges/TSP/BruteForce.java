package Challenges.TSP;

/**
 * Travelling salesman problem
 * Ref: https://www.youtube.com/watch?v=cY4HiiFHO1o
 */
public class BruteForce {
    private final int[][] matrix = {{0, 4, 1, 9},
                                    {3, 0, 6, 11},
                                    {4, 1, 0, 2},
                                    {6, 5, -4, 0}};

    public static void main(String[] args) {
        BruteForce solution = new BruteForce();
        solution.solve();
    }

    private void solve() {

    }
}
