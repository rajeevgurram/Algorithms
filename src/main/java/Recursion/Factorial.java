package Recursion;

public class Factorial {
    public static void main(String[] args) {
        int number = 5;
        System.out.println(factorialIterative(number));
        System.out.println(factorialRecursion(number));
        System.out.println(factorialTailRecursion(number, 1));
    }

    private static double factorialIterative(final int number) {
        double result = 1;
        if(number == 0) {
            return result;
        }

        for(int i = number; i > 0; i --) {
            result *= i;
        }

        return result;
    }

    private static double factorialRecursion(final int number) {
        if(number == 0) {
            return 1;
        }

        return number * factorialRecursion(number - 1);
    }

    /**
     * Tail recursion doesn't do any computation before calling itself
     * so it doesn't need call stack
     * more performant than normal recursion.
     * @param number
     * @param result
     * @return
     */
    private static double factorialTailRecursion(final int number, int result) {
        if(number == 0) {
            return result;
        }

        return factorialTailRecursion(number - 1, number * result);
    }
}
