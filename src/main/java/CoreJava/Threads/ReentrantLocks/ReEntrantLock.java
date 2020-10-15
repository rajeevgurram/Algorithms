package CoreJava.Threads.ReentrantLocks;

import java.util.concurrent.locks.ReentrantLock;

public class ReEntrantLock {
    public static void main(String[] args) {
        Display o1 = new Display();

        MyThread t1 = new MyThread(o1, "ABC");
        MyThread t2 = new MyThread(o1, "DEF");
        MyThread t3 = new MyThread(o1, "GHI");

        t1.start();
        t2.start();
        t3.start();
    }
}

class MyThread extends Thread {
    Display o1;
    String name;

    public MyThread(Display o1, String name) {
        this.o1 = o1;
        this.name = name;
    }

    public void run() {
        o1.print(name);
    }
}

class Display {
    ReentrantLock lock = new ReentrantLock();
    public void print(String name) {
        lock.lock();
        for(int i = 0; i < 3; i ++) {
            lock.lock();
            System.out.print(Thread.currentThread().getName() + ": ");
            try {
                Thread.sleep(1000);
            } catch (Exception e) {
            }
            System.out.println(name);
            lock.unlock();
        }
        lock.unlock();
    }
}