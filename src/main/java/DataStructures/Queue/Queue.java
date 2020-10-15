package DataStructures.Queue;

public interface Queue<T> {
    void enqueue(T data);
    T dequeue();
    void print();
}
