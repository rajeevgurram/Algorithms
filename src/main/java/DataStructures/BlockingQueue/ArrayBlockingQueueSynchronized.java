package DataStructures.BlockingQueue;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

@SuppressWarnings("unchecked")
public class ArrayBlockingQueueSynchronized<T> implements BlockingQueue<T> {
    private final T[] data;
    private int size;
    private final int defaultSize = 10;

    public ArrayBlockingQueueSynchronized() {
        data = (T[]) new Object[defaultSize];
    }

    @Override
    public synchronized T put(T element) {
        System.out.println("\n\n");
        try {
            System.out.println("[INSERT] lock acquired to insert data " + element + ", thread: " + Thread.currentThread().getName());
            while (size >= data.length) {
                System.out.println("[INSERT] size reached it's limit. waiting for it to consume to insert " + element + ", thread: " + Thread.currentThread().getName());
                //Thread.sleep(1000);
                wait();
                System.out.println("[INSERT] consumer consumed and signaled to insert " + element + ", thread: " + Thread.currentThread().getName());
            }
            System.out.println("[INSERT] inserting " + element + ", thread: " + Thread.currentThread().getName());
            data[size++] = element;
            System.out.println("[INSERT] signaling says queue not empty, thread: " + Thread.currentThread().getName());
            notify();
            System.out.println("[INSERT] signaling done, thread: " + Thread.currentThread().getName());
            return element;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
        }
        return null;
    }

    @Override
    public synchronized T take() {
        System.out.println("\n\n");
        try {
            System.out.println("[READ] lock acquired to read data, thread: " + Thread.currentThread().getName());
            while (size == 0) {
                //Thread.sleep(1000);
                System.out.println("[READ] queue is empty, waiting for producer to produce elements, thread: " + Thread.currentThread().getName());
                wait();
                System.out.println("[READ] producer signaled that inserted data, thread: " + Thread.currentThread().getName());
            }
            T element = data[0];
            for(int i = 0; i < data.length - 1; i ++) {
                data[i] = data[i + 1];
            }
            size--;
            System.out.println("[READ] signaling producer that queue is not full, thread: " + Thread.currentThread().getName());
            notify();
            System.out.println("[READ] signaling producer that queue is not full, done, thread: " + Thread.currentThread().getName());
            return element;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
        }
        return null;
    }
}
