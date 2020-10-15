package DataStructures.Heap;

public class Main {
    public static void main(String[] args) {
        MaxHeap heap = new MaxHeap();

        heap.add(11);
        heap.add(14);
        heap.add(32);
        heap.add(40);
        heap.add(30);
        heap.add(1);
        heap.add(60);
        System.out.println(heap.delete());
        System.out.println(heap.delete());
        System.out.println(heap.delete());
        System.out.println(heap.delete());
        System.out.println(heap.delete());
        System.out.println(heap.delete());
        System.out.println(heap.delete());

    }
}
