package CoreJava.Threads.DeadLock;

import lombok.SneakyThrows;

public class Class2 implements Runnable {
    Object o1, o2;

    public Class2(Object o1, Object o2) {
        this.o1 = o1;
        this.o2 = o2;
    }

    @SneakyThrows
    @Override
    public void run() {
        synchronized (o2) {
            System.out.println("Class :  " +
                    this.getClass().getSimpleName() +
                    ", Thread : " + Thread.currentThread().getName() +
                    ", Aquired O2");

            Thread.sleep(1000);

            synchronized (o1) {
                System.out.println("Class :  " +
                        this.getClass().getSimpleName() +
                        ", Thread : " + Thread.currentThread().getName() +
                        ", Aquired O1");
            }
        }
    }
}
