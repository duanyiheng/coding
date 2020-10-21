package sort.method;

/**
 * We start the array index from 1 for convenience. The parent of K is K/2 and the the children of it are 2K and 2K+1.
 *
 * @author duan_y
 */
public class Heap<T extends Comparable<T>> {
    private T[] heap;
    private int size = 0;

    public Heap(int maxSize) {
        this.heap = (T[]) new Comparable[maxSize + 1];
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    private boolean less(int i, int j) {
        return heap[i].compareTo(heap[j]) < 0;
    }

    private void swap(int i, int j) {
        T t = heap[i];
        heap[i] = heap[j];
        heap[j] = t;
    }

    private void swim(int k) {
        while (k > 1 && less(k / 2, k)) {
            swap(k / 2, k);
            k = k / 2;
        }
    }

    private void sink(int k) {
        while (2 * k <= size) {
            int j = 2 * k;
            if (j < size && less(j, j + 1)) {
                j++;
            }
            if (!less(k, j)) {
                break;
            }
            swap(k, j);
            k = j;
        }
    }

    private void insert(T v) {
        heap[++size] = v;
        swim(size);
    }

    private T deleteMax() {
        T max = heap[1];
        swap(1, size);
        heap[size] = null;
        size--;
        sink(1);
        return max;
    }
}
