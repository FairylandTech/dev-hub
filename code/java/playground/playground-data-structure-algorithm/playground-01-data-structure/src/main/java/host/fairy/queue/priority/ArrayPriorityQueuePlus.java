/*****************************************************
 * @software: IntelliJ IDEA
 * @author: Lionel Johnson
 * @contact: https://fairy.host
 * @organization: https://github.com/FairylandFuture
 * @datetime: 2025-09-17 16:50:04 UTC+08:00
 ****************************************************/
package host.fairy.queue.priority;

import host.fairy.queue.Queue;

import java.util.Iterator;

/**
 * Priority Queue based on array (asc)
 *
 * @param <E> Queue element type.
 * @author Lionel Johnson
 * @version 1.0
 * @see Queue
 * @see Iterable
 * @see Priority
 */
public class ArrayPriorityQueuePlus<E extends Priority> implements Queue<E>, Iterable<E> {
    private final E[] array;
    private int index;
    
    @SuppressWarnings("unchecked")
    public ArrayPriorityQueuePlus(int size) {
        this.array = (E[]) new Priority[size];
    }
    
    private void insert(E value) {
        int i = this.index - 1;
        while (i >= 0 && value.getPriority() < this.array[i].getPriority()) {
            array[i + 1] = array[i];
            i--;
        }
        array[i + 1] = value;
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
        insert(value);
        this.index++;
        return true;
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
        return this.array[this.index - 1];
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
        E value = this.array[this.index - 1];
        this.array[--this.index] = null;  // Help GC
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
    
    /**
     * Returns an iterator over elements of type {@code T}.
     *
     * @return an Iterator.
     */
    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            @Override
            public boolean hasNext() {
                return false;
            }
            
            @Override
            public E next() {
                return null;
            }
        };
    }
}
