package DataStructures.BlockingQueue;

public interface BlockingQueue<T> {
    T put(T element);
    T take();
}
