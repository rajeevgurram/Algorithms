package CoreJava.Generics.Simple;

public class Main {
    public static void main(String[] args) {
        FirstGeneric<String> g1 = new FirstGeneric<>("Rajeev");
        System.out.println(g1.getData());

        FirstGeneric<Integer> g2 = new FirstGeneric<>(10);
        System.out.println(g2.getData());
    }
}
