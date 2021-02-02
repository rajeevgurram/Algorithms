package Challenges.Threads;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class TwoThreadsPrintNumbersInSequential {
    int count = 0;

    public static void main(String[] args) {
        TwoThreadsPrintNumbersInSequential solution =
                new TwoThreadsPrintNumbersInSequential();
        solution.solution1();
    }

    public void solution1() {
        Lock lock = new ReentrantLock();
        Condition condition = lock.newCondition();

        new Thread(() -> {
            while (true) {
                lock.lock();
                condition.signal();
                System.out.println(Thread.currentThread().getName() + " : " + count++);
                try {
                    condition.await();
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                lock.unlock();
            }
        }).start();

        new Thread(() -> {
            while (true) {
                lock.lock();
                condition.signal();
                System.out.println(Thread.currentThread().getName() + " : " + count++);
                try {
                    condition.await();
                    Thread.sleep(1000);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                lock.unlock();
            }
        }).start();
    }
}
