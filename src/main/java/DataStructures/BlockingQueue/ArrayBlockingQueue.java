package DataStructures.BlockingQueue;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

@SuppressWarnings("unchecked")
public class ArrayBlockingQueue<T> implements BlockingQueue<T> {
    private final T[] data;
    private int size;
    private final int defaultSize = 10;
    private final Lock lock;
    private final Condition empty, full;

    public ArrayBlockingQueue() {
        data = (T[]) new Object[defaultSize];
        lock = new ReentrantLock();
        empty = lock.newCondition();
        full = lock.newCondition();
    }

    @Override
    public T put(T element) {
        System.out.println("\n\n");
        try {
            System.out.println("[INSERT] trying to acquire lock to insert data " + element + ", thread: " + Thread.currentThread().getName());
            lock.lockInterruptibly();
            System.out.println("[INSERT] lock acquired to insert data " + element + ", thread: " + Thread.currentThread().getName());
            while (size >= data.length) {
                System.out.println("[INSERT] size reached it's limit. waiting for it to consume to insert " + element + ", thread: " + Thread.currentThread().getName());
                //Thread.sleep(1000);
                full.await();
                System.out.println("[INSERT] consumer consumed and signaled to insert " + element + ", thread: " + Thread.currentThread().getName());
            }
            System.out.println("[INSERT] inserting " + element + ", thread: " + Thread.currentThread().getName());
            data[size++] = element;
            System.out.println("[INSERT] signaling says queue not empty, thread: " + Thread.currentThread().getName());
            empty.signal();
            System.out.println("[INSERT] signaling done, thread: " + Thread.currentThread().getName());
            return element;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
        return null;
    }

    @Override
    public T take() {
        System.out.println("\n\n");
        try {
            System.out.println("[READ] trying to acquire lock to read data, thread: " + Thread.currentThread().getName());
            lock.lockInterruptibly();
            System.out.println("[READ] lock acquired to read data, thread: " + Thread.currentThread().getName());
            while (size == 0) {
                //Thread.sleep(1000);
                System.out.println("[READ] queue is empty, waiting for producer to produce elements, thread: " + Thread.currentThread().getName());
                empty.await();
                System.out.println("[READ] producer signaled that inserted data, thread: " + Thread.currentThread().getName());
            }
            T element = data[0];
            for(int i = 0; i < data.length - 1; i ++) {
                data[i] = data[i + 1];
            }
            size--;
            System.out.println("[READ] signaling producer that queue is not full, thread: " + Thread.currentThread().getName());
            full.signal();
            System.out.println("[READ] signaling producer that queue is not full, done, thread: " + Thread.currentThread().getName());
            return element;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
        return null;
    }
}
