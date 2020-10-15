package CoreJava.Threads.DeadLock;

public class Main {
    public static void main(String[] args) {
        Object o1 = new Object();
        Object o2 = new Object();

        Class1 c1 = new Class1(o1, o2);
        Class2 c2 = new Class2(o1, o2);

        new Thread(c1).start();
        new Thread(c2).start();
    }
}
