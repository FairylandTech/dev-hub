/*****************************************************
 * @software: IntelliJ IDEA
 * @author: Lionel Johnson
 * @contact: https://fairy.host
 * @organization: https://github.com/FairylandFuture
 * @datetime: 2025-09-17 15:19:28 UTC+08:00
 ****************************************************/
package host.fairy.queue.priority;

import host.fairy.queue.Queue;

import java.util.Iterator;

/**
 * Prioritized queue, based on unordered array implementation
 *
 * @param <E> Queue element type.
 * @author Lionel Johnson
 * @version 1.0
 * @see Queue
 * @see Iterable
 * @see Priority
 */
public class ArrayPriorityQueue<E extends Priority> implements Queue<E>, Iterable<E> {
    private final E[] array;
    private int index;
    
    @SuppressWarnings("unchecked")
    public ArrayPriorityQueue(int size) {
        this.array = (E[]) new Priority[size];
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
        this.array[this.index++] = value;
        return true;
    }
    
    /**
     * Find index of max priority element.
     *
     * @return Index of max priority element.
     */
    private int findMaxPriorityIndex() {
        int maxIndex = 0;
        for (int i = 1; i < this.index; i++) {
            if (this.array[maxIndex].getPriority() < this.array[i].getPriority()) {
                maxIndex = i;
            }
        }
        return maxIndex;
    }
    
    /**
     * Remove element by max index.
     *
     * @param maxIndex Max index.
     */
    private void removeByIndex(int maxIndex) {
        if (maxIndex < this.index - 1) {
            System.arraycopy(this.array, maxIndex + 1, this.array, maxIndex, this.index - maxIndex - 1);
        }
        this.index--;
    }
    
    /**
     * Get value from queue head, but not remove.
     *
     * @return Value or null if the queue is empty.
     */
    @Override
    public E peek() {
        if (this.isEmpty()) {
            return null;
        }
        return this.array[this.findMaxPriorityIndex()];
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
        int maxIndex = this.findMaxPriorityIndex();
        E value = this.array[maxIndex];
        removeByIndex(maxIndex);
        return value;
    }
    
    /**
     * Check the queue is empty.
     *
     * @return Ture expression empty, otherwise false.
     */
    @Override
    public Boolean isEmpty() {
        return this.index == 0;
    }
    
    /**
     * Check the queue is full.
     *
     * @return Ture expression full, otherwise false.
     */
    @Override
    public Boolean isFull() {
        return this.index == this.array.length;
    }
    
    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            int loopIndex = 0;
            
            @Override
            public boolean hasNext() {
                return loopIndex < index;
            }
            
            @Override
            public E next() {
                return array[loopIndex++];
            }
        };
    }
}
