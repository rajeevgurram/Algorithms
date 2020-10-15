package DataStructures.Queue;

public class QueueUsingArray<T> implements Queue<T> {
    private int arrayLength = 10;
    private T[] data = (T[])new Object[arrayLength];
    private int size = 0;

    @Override
    public void enqueue(T value) {
        if(size == data.length) {
            T[] temp = (T[]) new Object[data.length + arrayLength];
            for(int i = 0; i < data.length; i ++) {
                temp[i] = data[i];
            }

            data = temp;
        }
        data[size++] = value;
    }

    @Override
    public T dequeue() {
        T value = data[0];
        for(int i = 0; i < size; i ++) {
            data[i] = data[i + 1];
        }
        size --;
        return value;
    }

    @Override
    public void print() {
        for(int i = 0; i < size; i ++) {
            System.out.println(data[i]);
        }
    }
}
