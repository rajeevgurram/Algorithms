package Challenges;

import java.util.PriorityQueue;

public class MergeNSortedArrays {
    public static void main(String[] args) {
        int[][] data = {
                {1, 5, 8, 15},
                {0, 4, 8, 11, 19, 20, 21},
                {16, 17, 18, 22, 30},
                {1, 2, 3, 6, 7, 9, 10, 12}
        };

        int[] result = new int[0];
        for(int i = 0; i < data.length; i ++) {
            result = MergeTwoSortedArrays.merge(result, data[i]);
        }

        for(int i : result) {
            System.out.print(i + ", ");
        }

        System.out.println("");
        int[] res = mergeKSortedArrays(data);
        for(int i : res) {
            System.out.print(i + ", ");
        }
    }

    // Using min heap
    // Add all to minHeap and retrieve it
    public static int[] mergeKArrays(int[][] data) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        int length = 0;
        for(int i = 0; i < data.length; i ++) {
            for(int j = 0; j < data[i].length; j ++) {
                minHeap.add(data[i][j]);
                length++;
            }
        }

        int[] result = new int[length];
        int index = 0;
        while (!minHeap.isEmpty()) {
            result[index++] = minHeap.poll();
        }

        return result;
    }

    private static class HeapNode {
        public int arrayNum;
        public int index;
        public int value;

        public HeapNode(int arrayNum, int index, int value) {
            this.arrayNum = arrayNum;
            this.index = index;
            this.value = value;
        }
    }

    // Using min heap
    // adding 3 elements at a time
    public static int[] mergeKSortedArrays(int[][] arrays) {

        if (arrays == null) return null;

        PriorityQueue<HeapNode> minHeap =
                new PriorityQueue<>(arrays.length,
                        (HeapNode a, HeapNode b) -> a.value - b.value);

        int size = 0;
        for (int i = 0; i < arrays.length; i++) {
            size += arrays[i].length;
        }
        int[] result = new int[size]; // k * n

        //add first elements in the array to this heap
        for (int i = 0; i < arrays.length; i++) {
            minHeap.add(new HeapNode(i, 0, arrays[i][0]));
        }

        //Complexity O(n * k * log k)
        for (int i = 0; i < size; i++) {
            //Take the minimum value and put into result
            HeapNode node = minHeap.poll();

            if (node != null) {
                result[i] = node.value;
                if (node.index + 1 < arrays[node.arrayNum].length) {
                    //Complexity of O(log k)
                    minHeap.add(new HeapNode(node.arrayNum,
                            node.index + 1,
                            arrays[node.arrayNum][node.index + 1]));
                }
            }
        }

        return result;
    }
}
