package DataStructures.Heap;

public class MaxHeap {
    private final int initialLength = 10;
    private final int[] data;
    private int size = 0;

    public MaxHeap() {
        data = new int[initialLength];
    }

    public void add(int value) {
        data[size++] = value;
        if(size > 1) {
            int newValueIndex = size - 1;
            int newValueParentIndex = size / 2;
            while (value > data[newValueParentIndex]) {
                int temp = data[newValueParentIndex];
                data[newValueParentIndex] = data[newValueIndex];
                data[newValueIndex] = temp;

                newValueIndex = newValueParentIndex;
                newValueParentIndex = (newValueIndex - 1) / 2;
            }
        }
    }

    public int delete() {
        int valueToBeDeleted = data[0];

        int lastElement = data[size - 1];
        data[0] = lastElement;
        data[size - 1] = 0;
        size--;
        heapifyDown();
        return valueToBeDeleted;
    }

    private void heapifyDown() {
        int index = 0;
        int leftChildrenIndex = (2 * index) + 1;
        int rightChildrenIndex = (2 * index) + 2;

        while (data[index] < data[leftChildrenIndex] ||
                data[index] < data[rightChildrenIndex]) {
            if(data[leftChildrenIndex] < data[rightChildrenIndex]) {
                swap(index, rightChildrenIndex);
                index = rightChildrenIndex;
            } else {
                swap(index, leftChildrenIndex);
                index = leftChildrenIndex;
            }

            leftChildrenIndex = (2 * index) + 1;
            rightChildrenIndex = (2 * index) + 2;

            if(rightChildrenIndex >= data.length) break;
        }
    }

    private void swap(int i, int j) {
        int temp = data[i];
        data[i] = data[j];
        data[j] = temp;
    }
}
