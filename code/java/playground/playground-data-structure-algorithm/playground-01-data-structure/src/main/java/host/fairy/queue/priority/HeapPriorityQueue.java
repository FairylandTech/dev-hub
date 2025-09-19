/*****************************************************
 * @software: IntelliJ IDEA
 * @author: Lionel Johnson
 * @contact: https://fairy.host
 * @organization: https://github.com/FairylandFuture
 * @datetime: 2025-09-17 19:09:08 UTC+08:00
 ****************************************************/
package host.fairy.queue.priority;

import host.fairy.queue.Queue;

/**
 * Priority Queue implement basedon Heap (Complete binary tree math).
 *
 * @param <E> Queue element type.
 * @author Lionel Johnson
 * @version 1.0
 * @see Queue
 * @see Priority
 */
public class HeapPriorityQueue<E extends Priority> implements Queue<E> {
    private final E[] array;
    private int index;
    
    @SuppressWarnings("unchecked")
    public HeapPriorityQueue(int size) {
        this.array = (E[]) new Priority[size];
    }
    
    private void swap(int i, int j) {
        E temp = this.array[i];
        this.array[i] = this.array[j];
        this.array[j] = temp;
    }
    
    private void downHeapify(int parent) {
        
    }
    
    /**
     * Insert into end of queue.
     *
     * @param value Value.
     * @return Successfully added.
     */
    @Override
    public Boolean offer(E value) {
        if (this.isFull()) {
            return false;
        }
        int child = this.index++;
        int parent = (child - 1) / 2;
        while (child > 0 && value.getPriority() > this.array[parent].getPriority()) {
            this.array[child] = this.array[parent];
            child = parent;
            parent = (child - 1) / 2;
        }
        this.array[child] = value;
        return true;
    }
    
    /**
     * Get value from queue head, but not remove.
     *
     * @return Value or null if the queue is empty.
     */
    @Override
    public E peek() {
        return null;
    }
    
    /**
     * Get value from queue head and remove node.
     *
     * @return Value or null if the queue is empty.
     */
    @Override
    public E poll() {
        if (this.isEmpty()) {
            return null;
        }
        this.swap(0, --this.index);
        E value = this.array[this.index];
        this.array[this.index] = null;  // Help GC.
        this.downHeapify(0);
        return value;
    }
    
    /**
     * Check the queue is empty.
     *
     * @return Ture expression empty, otherwise false.
     */
    @Override
    public Boolean isEmpty() {
        return null;
    }
    
    /**
     * Check the queue is full.
     *
     * @return Ture expression full, otherwise false.
     */
    @Override
    public Boolean isFull() {
        return null;
    }
}
