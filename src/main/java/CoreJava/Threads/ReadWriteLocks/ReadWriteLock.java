package CoreJava.Threads.ReadWriteLocks;

import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReadWriteLock {
    ReentrantReadWriteLock lock = new ReentrantReadWriteLock();
    ReentrantReadWriteLock.ReadLock readLock = lock.readLock();
    ReentrantReadWriteLock.WriteLock writeLock = lock.writeLock();

    public void read() {
        readLock.lock();
        System.out.println(Thread.currentThread().getName() + " Aquired read lock");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        readLock.unlock();
    }

    public void write() {
        writeLock.lock();
        System.out.println(Thread.currentThread().getName() + " Aquired write lock");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        writeLock.unlock();
    }

    public static void main(String[] args) {
        ReadWriteLock obj = new ReadWriteLock();
        new Thread(() -> obj.read()).start();
        new Thread(() -> obj.read()).start();
        new Thread(() -> obj.read()).start();
        new Thread(() -> obj.write()).start();
        new Thread(() -> obj.write()).start();
    }
}
