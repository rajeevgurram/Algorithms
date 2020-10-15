package DataStructures.Stack;

import DataStructures.LinkedList.Single.LinkedList;

public class StackUsingLinkedList<T> implements Stacks<T> {
    private LinkedList<T> list = new LinkedList<>();

    @Override
    public void push(T data) {
        list.addFirst(data);
    }

    @Override
    public T pop() {
        return list.removeFirst();
    }

    @Override
    public void print() {
        list.print();
    }
}
