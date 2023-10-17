package Heap;

import java.util.ArrayList;
import java.util.List;

public class MinHeap {

    private List<Integer> heap;

    public MinHeap() {
        this.heap = new ArrayList<>();
    }

    public List<Integer> getHeap() {
        return new ArrayList<>(heap);
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

    private void swap(int index1, int index2) {
        int temp = heap.get(index1);
        heap.set(index1, heap.get(index2));
        heap.set(index2, temp);
    }

    public void insert(int value) {

        heap.add(value);
        int currentIndex = heap.size()-1;
        while (currentIndex > 0 && (heap.get(currentIndex) < heap.get(parent(currentIndex)))) {
            swap(currentIndex, parent(currentIndex));
            currentIndex = parent(currentIndex);
        }
    }

    public Integer remove() {
        if(heap == null || heap.isEmpty()) return null;

        if(heap.size() == 1) return heap.remove(0);

        int removed = heap.get(0);
        heap.set(0, heap.remove(heap.size()-1));
        sinkDown(0);

        return removed;
    }

    private void sinkDown(int index) {
        int minValue = index;
        while (true) {
            int left = leftChild(index);
            int right = rightChild(index);

            if(left < heap.size() && heap.get(minValue) > heap.get(left)) {
                minValue = left;
            }
            if(right < heap.size() && heap.get(minValue) > heap.get(right)) {
                minValue = right;
            }

            if(minValue != index) {
                swap(minValue,index);
                index = minValue;
            } else {
                return;
            }
        }
    }
}
