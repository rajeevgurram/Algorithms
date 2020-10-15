package Challenges;

public class MissingElementFromArrays {
    public static void main(String args[])
    {
        int arr1[] = { 4, 1, 5, 9, 7 };
        int arr2[] = { 7, 5, 9, 4 };
        int M = arr1.length;
        int N = arr2.length;
        findMissing(arr1, arr2, M, N);
    }

    static void findMissing(int arr1[], int arr2[],
                     int M, int N)
    {
        if (M != N - 1 && N != M - 1) {
            System.out.println("Invalid Input");
            return;
        }

        // Do XOR of all element
        int res = 0;
        for (int i = 0; i < M; i++)
            res = res ^ arr1[i];
        for (int i = 0; i < N; i++)
            res = res ^ arr2[i];

        System.out.println("Missing element is "
                + res);
    }
}
