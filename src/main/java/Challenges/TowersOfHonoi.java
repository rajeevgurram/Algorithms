package Challenges;

/**
 * O(2^n - 1)
 */
public class TowersOfHonoi {
    public static void main(String[] args) {
        solveHonoi('A', 'B', 'C', 3);
    }

    public static void solveHonoi(char from, char aux, char to, int noOfDisks) {
        if(noOfDisks <= 0) {
            return;
        }

        solveHonoi(from, to, aux, noOfDisks - 1);
        System.out.println(noOfDisks + " --> " + from + " ---> " + to);
        solveHonoi(aux, from, to, noOfDisks - 1);
    }
}
