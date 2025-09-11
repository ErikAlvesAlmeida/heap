public class PriorityQueue {
    private Heap heap;
    private int capacity;

    public PriorityQueue() {
        this.capacity = 100; // default
        this.heap = new Heap(capacity);
    }

    // Construtor com capacidade específica
    public PriorityQueue(int capacity) {
        this.capacity = capacity;
        this.heap = new Heap(capacity);
    }

    public void insert(int value) {
        if (heap.isFull()) {
            throw new IllegalStateException("Fila cheia!");
        }
        heap.insert(value);
    }

    public int peek() {
        return heap.peek(); // retorna raiz do heap
    }

    public int extractMax() {
        return heap.extract(); // remove raiz do heap
    }

    public boolean isEmpty() {
        return heap.isEmpty();
    }

    public int size() {
        return heap.size();
    }

    public int getCapacity() {
        return this.capacity;
    }
}
