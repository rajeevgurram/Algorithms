package Interviews;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/***
 * Given array perform k number of operations, so that the
 * sum of all numbers in array are smaller
 */
public class REALTOR_MinimumSum {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<Integer>();
        list.add(2);
        list.add(2);
        list.add(3);

        int k = 1;

        System.out.println(minSum(list, k));
    }

    private static int minSum(List<Integer> list, int k) {
        int result = 0;

        for(int i = 0; i < k; i ++) {
                Collections.sort(list);
            int largestNumber = list.remove(list.size() - 1);
            int ceil = (int) Math.ceil((double)largestNumber / 2);
            list.add(ceil);
        }

        for(Integer i : list) {
            result += i;
        }
        return result;
    }
}
