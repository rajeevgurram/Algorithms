package DataStructures.LinkedList.Single;

public class Node<T> {
    private T data;
    private Node next;

    public Node(T data, Node next) {
        this.data = data;
        this.next = next;
    }

    public Node() {
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public Node<T> getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    @Override
    public String toString() {
        return this.data.toString();
    }
}
