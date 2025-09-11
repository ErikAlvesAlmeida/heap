public class Heap {
    private int[] heap;
    private int capacity;
    private int size;

    public Heap(int capacity){
        this.size = 0;
        this.capacity = capacity;
        this.heap = new int[capacity];
    }

    //MÉTODOS PRINCIPAIS
    public void insert(int value){
        if(isFull()) throw new IllegalStateException("Heap Cheia!");
        heap[this.size] = value;
        int curr = this.size;
        this.size++;
        //heapfy-up. Vai corrigir subindo pra colocar o valor na posição correta. A complexidade disso é O(log n).
        while(curr > 0 && heap[curr] > heap[parent(curr)]){
            swap(curr, parent(curr));
            curr = parent(curr);
        }
    }

    public int peek(){
        if(isEmpty()) throw new IllegalStateException("Heap Vazia!");
        return heap[0];
    }

    public int extract(){
        if(isEmpty()) throw new IllegalStateException("Heap Vazia!");
        int max = peek(); // pega o maior elemento;
        heap[0] = heap[this.size - 1]; // coloca o último valor na primeira casa;
        this.size--; // decrementa o size pra ele desconsiderar a última casa;
        heapfy(0); // arruma o array de cima pra baixo;
        return max; // retorna o valor removido;
    }

    public void buildHeap(int[] arr){
        if(arr.length > capacity) return;
        this.heap = arr;
        this.size = arr.length;
        for(int i = parent(this.size - 1); i >= 0; i--){
            heapfy(i);
        }
    }

    //MÉTODOS AUXILIARES
    public int size(){
        return this.size;
    }

    public boolean isEmpty(){
        return this.size == 0;
    }

    public boolean isFull(){
        return this.size == this.capacity;
    }

    private int parent(int i){
        return (i-1)/2;
    }

    private int leftChild(int i){
        return 2*i+1;
    }

    private int rightChild(int i){
        return 2*i+2;
    }

    private void heapfy(int i){
        int largest = i;
        int left = leftChild(i);
        int right = rightChild(i);
        if(left < size && heap[left] > heap[largest]) largest = left;
        if(right < size && heap[right] > heap[largest]) largest = right;
        if(largest != i){
            swap(i, largest);
            heapfy(largest);
        }
    }

    private void swap(int i, int j){
        int temp = heap[i];
        heap[i] = heap[j];
        heap[j] = temp;
    }
}
