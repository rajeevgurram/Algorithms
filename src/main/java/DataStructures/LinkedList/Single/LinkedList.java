package DataStructures.LinkedList.Single;

public class LinkedList<T> {
    private Node<T> head = null, tail = null;
    private int size = 0;

    public void addFirst(T data) {
        Node<T> newNode = new Node<>(data, null);
        newNode.setNext(head);

        head = newNode;
        if(size == 0) {
            tail = head;
        }

        size++;
    }

    public void addLast(T data) {
        Node<T> newNode = new Node<>(data, null);
        if(head == null) {
            head = newNode;
        } else {
            tail.setNext(newNode);
        }
        tail = newNode;

        size++;
    }

    public T removeFirst() {
        if(head == null) {
            return null;
        }

        T deletedElement = head.getData();
        head = head.getNext();
        size --;
        if(head == null) {
            tail = null;
        }

        return deletedElement;
    }


    public T removeLast() {
        if(head == null) {
            return null;
        }

        if(head.getNext() == null) {
            head = tail = null;
        }

        Node<T> temp = head;
        while(temp.getNext().getNext() != null) {
            temp = temp.getNext();
        }

        T deletedNode = temp.getNext().getData();
        temp.setNext(null);
        tail = temp;

        size --;

        return deletedNode;
    }

    public void print() {
        System.out.println("");
        Node<T> temp = head;
        while(temp != null) {
            System.out.print("-->" + temp.getData());
            temp = temp.getNext();
        }
    }

    public void reverse() {
        if(size <= 1) {
            return;
        }

        Node<T> temp = head;
        //reverseRecursive(temp);
        reverseIterative(temp);

        head = tail;
        tail = temp;
    }

    public LinkedList<Integer> mergeTwoLists(LinkedList<Integer> linkedList1, LinkedList<Integer> linkedList2) {
        LinkedList<Integer> list = new LinkedList<>();
        Node<Integer> list1 = linkedList1.head;
        Node<Integer> list2 = linkedList2.head;

        while(list1 != null && list2 != null) {
            if(Integer.parseInt(list1.getData().toString()) > Integer.parseInt(list2.getData().toString())) {
                list.addLast(Integer.parseInt(list2.getData().toString()));
                list2 = list2.getNext();
            } else if(Integer.parseInt(list1.getData().toString()) < Integer.parseInt(list2.getData().toString())) {
                list.addLast(Integer.parseInt(list1.getData().toString()));
                list1 = list1.getNext();
            } else {
                list.addLast(Integer.parseInt(list1.getData().toString()));
                list1 = list1.getNext();
            }
        }

        while(list1 != null) {
            list.addLast(Integer.parseInt(list1.getData().toString()));
            list1 = list1.getNext();
        }

        while(list2 != null) {
            list.addLast(Integer.parseInt(list2.getData().toString()));
            list2 = list2.getNext();
        }

        return list;
    }

    private void reverseRecursive(Node<T> data) {
        if(data.getNext() == null) {
            return;
        }

        Node<T> currentNode = data;
        Node<T> nextNode = data.getNext();
        reverseRecursive(nextNode);

        nextNode.setNext(currentNode);
        currentNode.setNext(null);
    }

    private void reverseIterative(Node<T> data) {
        Node<T> currentNode = data;
        Node<T> nextNode = currentNode.getNext();
        currentNode.setNext(null);

        while (nextNode != null) {
            Node<T> temp = nextNode.getNext();
            nextNode.setNext(currentNode);
            currentNode = nextNode;
            nextNode = temp;
        }
    }
}
