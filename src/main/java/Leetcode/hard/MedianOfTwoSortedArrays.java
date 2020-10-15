package Leetcode.hard;

public class MedianOfTwoSortedArrays {
    public static void main(String[] args) {
        MedianOfTwoSortedArrays solution = new MedianOfTwoSortedArrays();
        int[] array1 = {1, 2};
        int[] array2 = {3, 4};

        solution.solve(array1, array2);
    }

    private double solve(int[] array1, int[] array2) {
        if(array1.length > array2.length) {
            return solve(array2, array1);
        }

        int x = array1.length, y = array2.length;
        int low = 0, high = x;

        while (low <= high) {
            int partitionX = (low + high) / 2;
            int partitionY = ((x + y + 1) / 2) - partitionX;

            int x_max_left = partitionX <= 0 ? array1[0] : array1[partitionX - 1];
            int x_min_right = partitionX == x ? array1[array1.length - 1] : array1[partitionX];

            int y_max_left = partitionY <=0 ? array2[0] : array2[partitionY - 1];
            int y_min_right = partitionY == y ? array2[array2.length - 1] : array2[partitionY];

            if (x_max_left < y_min_right &&
                    y_max_left < x_min_right) {
                int median = (Math.min(x_max_left, y_max_left) +
                        Math.max(x_min_right, y_min_right)) / 2;
                System.out.println(median);
                return median;
            } else if (x_max_left > y_min_right) {
                high = partitionX - 1;
            } else {
                low = partitionX + 1;
            }
        }

        return -1;
    }
}
