package Challenges;

import java.util.HashMap;
import java.util.Map;

/**
 * First duplicate of smaller index
 * ex: [1, 2, 1, 2, 3, 3] => 1 (1st duplicate index is smaller than all)
 */
public class FirstDuplicate {
    public static void main(String[] args) {
        int[] array = {1, 2, 1, 2, 3, 3};
        System.out.println(firstDuplicate(array));
        System.out.println(firstDiplicateOptimized(array));
    }

    private static int firstDuplicate(int[] array) {
        int index = array.length;

        for(int i = 0; i < array.length; i ++) {
            for(int j = i + 1; j < array.length; j ++) {
                if(array[i] == array[j]) {
                    if(index > j) {
                        index = j;
                    }
                }
            }
        }

        if(index == array.length) return -1;
        return array[index];
    }

    private static int firstDiplicateOptimized(int[] array) {
        Map<Integer, Integer> data = new HashMap<>();
        int index = array.length;
        for(int i = 0; i < array.length; i ++) {
            Integer result = data.get(array[i]);
            if(result == null) {
                data.put(array[i], i);
            } else {
                index = index > result ? result : index;
            }
        }
        return index == array.length ? -1 : array[index];
    }
}
