package Leetcode.medium;

import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses {
    public static void main(String[] args) {
        GenerateParentheses solution = new GenerateParentheses();
        int n = 20;
        List<String> list = new ArrayList<>();
        solution.solve(list, "", n, n);
        System.out.println(list);
    }

    private void solve(List<String> list, String currentString,
                       int left, int right) {
        if(left < 0 || left > right) {
            return;
        }

        if(left == 0 && right == 0) {
            list.add(currentString);
        }

        solve(list, currentString + "(", left - 1, right);
        solve(list, currentString + ")", left, right - 1);
    }
}
