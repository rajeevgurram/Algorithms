package DynamicProgramming;

import java.util.HashMap;
import java.util.Map;

/**
 *  F(N) = F(N-1) + F(N-2)
 */
public class Fibonacci {
    public static void main(String[] args) {
        Fibonacci solution = new Fibonacci();
        int n = 10000;
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("From Recursive Solution: " + solution.fibanocci_recursive_solution(n));
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("From Dynamic Solution: " + solution.fibanocci_dynamic_solution(n));

            }
        }).start();
    }

    private int fibanocci_recursive_solution(int n) {
        if(n == 1) return 1;
        if(n == 0) return 0;

        return fibanocci_recursive_solution(n - 1) +
                fibanocci_recursive_solution(n - 2);
    }

    private Map<Integer, Integer> memoize;
    public Fibonacci() {
        memoize = new HashMap<>();
        memoize.put(0, 0);
        memoize.put(1, 1);
    }
    private int fibanocci_dynamic_solution(int n) {
        if(memoize.containsKey(n)) {
            return memoize.get(n);
        }

        memoize.put(n - 1, fibanocci_dynamic_solution(n - 1));
        memoize.put(n - 2, fibanocci_dynamic_solution(n - 2));

        int result = memoize.get(n - 1) + memoize.get(n - 2);
        memoize.put(n, result);
        return result;
    }
}
