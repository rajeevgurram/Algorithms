package Challenges;

public class MergeTwoSortedArrays {
    public static void main(String[] args) {
        int[] a1 = {1, 6, 7, 10};
        int[] a2 = {1, 2, 5, 8, 11};
        int[] result = merge(a1, a2);

        for(int data : result) {
            System.out.println(data);
        }
    }

    public static int[] merge(int[] a1, int[] a2) {
        int[] result = new int[a1.length + a2.length];
        int i = 0, j = 0, index = 0;

        while (i < a1.length && j < a2.length) {
            if(a1[i] > a2[j]) {
                result[index++] = a2[j++];
            } else if(a1[i] < a2[j]) {
                result[index++] = a1[i++];
            } else {
                result[index++] = a1[i++];
            }
        }

        while (i < a1.length) {
            result[index++] = a1[i++];
        }

        while (j < a2.length) {
            result[index++] = a2[j++];
        }

        return result;
    }
}
