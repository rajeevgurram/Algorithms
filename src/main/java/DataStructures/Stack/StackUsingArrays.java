package DataStructures.Stack;

public class StackUsingArrays<T> implements Stacks<T> {
    private int arrayLength = 10;
    private T[] data = (T[])new Object[arrayLength];
    private int size = 0;

    @Override
    public void push(T value) {
        if(size == data.length) {
            T[] temp = (T[])new Object[data.length + arrayLength];
            for(int i = 0; i < data.length; i ++) {
                temp[i] = data[i];
            }

            data = temp;
        }
        data[size++] = value;
    }

    @Override
    public T pop() {
        T value = data[size - 1];
        data[size - 1] = null;
        size --;
        return value;
    }

    @Override
    public void print() {
        for(int i = size - 1; i >= 0; i --) {
            System.out.println(data[i]);
        }
    }
}
