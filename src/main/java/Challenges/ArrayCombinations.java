package Challenges;

public class ArrayCombinations {
    public static void main(String[] args) {
        ArrayCombinations solution = new ArrayCombinations();
        int[] arr = {1, 2, 3, 4, 5, 6};
        int r = 3;
        solution.solve(arr, r);
    }

    private void solve(int[] arr, int r) {
        // A temporary array to store
        // all combination one by one
        int[] data = new int[r];

        // Print all combination using
        // temporary array 'data[]'
        combinationUtil(arr, data, 0, arr.length-1, 0, r);
    }

    void combinationUtil(int arr[], int data[],
                         int start, int end,
                         int index, int r) {
        // Current combination is ready, to be printed, print it
        if (index == r) {
            for (int j = 0; j < r; j++) {
                System.out.print(data[j]);
            }
            System.out.println("");
            return;
        }

        for (int i = start; i <= end; i++) {
            data[index] = arr[i];
            combinationUtil(arr, data, i+1, end, index+1, r);
        }
    }
}
