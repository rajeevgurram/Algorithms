package DataStructures.LinkedList;

public interface List<T> {
    void addFirst(T data);
    void addLast(T data);
    T removeFirst();
    T removeLast();
    void print();
    void reverse();
    List<Integer> mergeTwoLists(List<T> linkedList1, List<T> linkedList2);
}
