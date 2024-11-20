import java.util.ArrayList;

public class GumeraHeap {
    private ArrayList<Integer> heap;

    public GumeraHeap() {
        heap = new ArrayList<>();
    }

    public void insert(int value) {
        heap.add(value);
        heapifyUp(heap.size() - 1);
    }

    public int remove() throws IllegalStateException {
        if (heap.isEmpty()) {
            throw new IllegalStateException("Heap is empty");
        }

        int root = heap.get(0);
        int last = heap.remove(heap.size() - 1);

        if (!heap.isEmpty()) {
            heap.set(0, last);
            heapifyDown(0);
        }

        return root;
    }

    private void heapifyUp(int index) {
        int parentIndex = (index - 1) / 2;

        while (index > 0 && heap.get(index) > heap.get(parentIndex)) {
            swap(index, parentIndex);
            index = parentIndex;
            parentIndex = (index - 1) / 2;
        }
    }

    private void heapifyDown(int index) {
        int size = heap.size();
        int largest = index;

        while (true) {
            int leftChild = 2 * index + 1;
            int rightChild = 2 * index + 2;

            if (leftChild < size && heap.get(leftChild) > heap.get(largest)) {
                largest = leftChild;
            }
            if (rightChild < size && heap.get(rightChild) > heap.get(largest)) {
                largest = rightChild;
            }

            if (largest == index) break;

            swap(index, largest);
            index = largest;
        }
    }

    private void swap(int i, int j) {
        int temp = heap.get(i);
        heap.set(i, heap.get(j));
        heap.set(j, temp);
    }

    public void printHeap() {
        System.out.println(heap);
    }

    public static void main(String[] args) {
        GumeraHeap maxHeap = new GumeraHeap();

        maxHeap.insert(10);
        maxHeap.insert(20);
        maxHeap.insert(5);
        maxHeap.insert(30);
        maxHeap.insert(25);

        System.out.println("Heap after insertions:");
        maxHeap.printHeap();

        System.out.println("Removed root: " + maxHeap.remove());
        System.out.println("Heap after removal:");
        maxHeap.printHeap();
    }
}
