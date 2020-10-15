package CoreJava.Threads.DeadLock;

import lombok.SneakyThrows;

public class Class1 implements Runnable {
    Object o1, o2;

    public Class1(Object o1, Object o2) {
        this.o1 = o1;
        this.o2 = o2;
    }

    @SneakyThrows
    @Override
    public void run() {
        synchronized (o1) {
            System.out.println("Class :  " +
                    this.getClass().getSimpleName() +
                    ", Thread : " + Thread.currentThread().getName() +
                    ", Aquired O1");

            Thread.sleep(1000);

            synchronized (o2) {
                System.out.println("Class :  " +
                        this.getClass().getSimpleName() +
                        ", Thread : " + Thread.currentThread().getName() +
                        ", Aquired O2");
            }
        }
    }
}
