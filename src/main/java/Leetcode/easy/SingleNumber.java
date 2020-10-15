package Leetcode.easy;

import java.util.*;

public class SingleNumber {
    public int solution_1(int[] nums) {
        Set<Integer> dest = new HashSet<>();
        Set<Integer> temp = new HashSet<>();

        for (int i : nums) {
            if (dest.add(i)) {
                temp.add(i);
            }
            else {
                temp.remove(i);
            }
        }

        return temp.iterator().next();
    }

    public int solution_2(int[] nums) {
        int xornums = 0;

        for (int i : nums) {
            xornums ^= i;
        }

        return xornums;
    }
}
