package DataStructures.Queue;

import DataStructures.LinkedList.List;
import DataStructures.LinkedList.Single.LinkedList;

public class QueueUsingLinkedList<T> implements Queue<T> {
    private LinkedList<T> data = new LinkedList<>();

    @Override
    public void enqueue(T value) {
        data.addLast(value);
    }

    @Override
    public T dequeue() {
        T value = data.removeFirst();
        return value;
    }

    @Override
    public void print() {
        data.print();
    }
}
