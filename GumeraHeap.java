public class GumeraHeap {
    private int[] heap;
    private int size;
    private int capacity;

    public GumeraHeap(int capacity) {
        this.capacity = capacity;
        this.size = 0;
        heap = new int[capacity];
    }

    private int leftChild(int index) {
        return 2 * index + 1;
    }

    private int rightChild(int index) {
        return 2 * index + 2;
    }

    private int parent(int index) {
        return (index - 1) / 2;
    }

    private void swap(int i, int j) {
        int temp = heap[i];
        heap[i] = heap[j];
        heap[j] = temp;
    }

    private void heapify(int index) {
        int left = leftChild(index);
        int right = rightChild(index);
        int largest = index;

        if (left < size && heap[left] > heap[largest]) {
            largest = left;
        }
        if (right < size && heap[right] > heap[largest]) {
            largest = right;
        }

        if (largest != index) {
            swap(index, largest);
            heapify(largest);
        }
    }

    public void insert(int value) {
        if (size == capacity) {
            System.out.println("Heap is full!");
            return;
        }
        
        heap[size] = value;
        int current = size;
        size++;

        while (current > 0 && heap[current] > heap[parent(current)]) {
            swap(current, parent(current));
            current = parent(current);
        }
    }

    public int extractMax() {
        if (size <= 0) {
            return Integer.MIN_VALUE;
        }
        if (size == 1) {
            size--;
            return heap[0];
        }

        int root = heap[0];
        heap[0] = heap[size - 1];
        size--;

        heapify(0);

        return root;
    }

    public void printHeap() {
        for (int i = 0; i < size; i++) {
            System.out.print(heap[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        GumeraHeap heap = new GumeraHeap(10);

        heap.insert(10);
        heap.insert(20);
        heap.insert(5);
        heap.insert(30);
        heap.insert(25);

        heap.printHeap();

        System.out.println("Extracted Max: " + heap.extractMax());

        heap.printHeap();
    }
}
