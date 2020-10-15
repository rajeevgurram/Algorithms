package DataStructures.LinkedList.Double;

public class LinkedList<T> {
    private Node<T> head, tail;
    private int size = 0;

    public void addFirst(T data) {
        Node<T> newNode = new Node<>(data, null, null);
        if(head == null) {
            head = tail = newNode;
        } else {
            newNode.setNext(head);
            head.setPrev(newNode);
            head = newNode;
        }
        size ++;
    }

    public void addLast(T data) {
        Node<T> newNode = new Node<>(data, null, null);
        if(head == null) {
            head = tail = newNode;
        } else {
            tail.setNext(newNode);
            newNode.setPrev(tail);
            tail = newNode;
        }
        size ++;
    }

    public T removeFirst() {
        if(head == null) {
            return null;
        }

        T data = head.getData();
        head = head.getNext();
        head.setPrev(null);
        size --;
        return data;
    }

    public T removeLast() {
        if(head == null) {
            return null;
        }

        T data = tail.getData();
        tail = tail.prev;
        tail.setNext(null);
        size --;
        return data;
    }

    public void print() {
        System.out.println("");
        Node<T> temp = head;
        while (temp != null) {
            System.out.print("-->" + temp.getData());
            temp = temp.getNext();
        }
    }

    public void printReverse() {
        System.out.println("");
        Node<T> temp = tail;
        while (temp != null) {
            System.out.print("-->" + temp.getData());
            temp = temp.getPrev();
        }
    }

    public void reverse() {
        reverseRecursive(head);
        //reverseIterative(head);

        Node<T> temp = head;
        head = tail;
        tail = temp;
    }

    private void reverseIterative(Node<T> list) {
        while (list != null) {
            Node<T> currentNode = list;
            Node<T> prevNode = currentNode.getPrev();
            Node<T> nextNode = currentNode.getNext();

            currentNode.setPrev(nextNode);
            currentNode.setNext(prevNode);
            list = nextNode;
        }
    }

    private void reverseRecursive(Node<T> list) {
        if(list == null) {
            return;
        }
        Node<T> prevNode = list.getPrev();
        Node<T> currentNode = list;
        Node<T> nextNode = list.getNext();

        reverseRecursive(nextNode);

        currentNode.setNext(prevNode);
        currentNode.setPrev(nextNode);
    }
}
