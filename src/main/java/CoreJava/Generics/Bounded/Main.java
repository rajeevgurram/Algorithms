package CoreJava.Generics.Bounded;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        BoundedGenerics<Integer> b1 = new BoundedGenerics<>(1, 2);
        b1.performCalc();

        ArrayList<String> a = new ArrayList<>();
        test(a);
        ArrayList<Integer> a1 = new ArrayList<>();
        test(a1);

        ArrayList<? super Integer> l = new ArrayList<Number>();
        l.add(10);
    }

    public static void test(ArrayList<?> a) {
        //a.add(10);
    }
}
