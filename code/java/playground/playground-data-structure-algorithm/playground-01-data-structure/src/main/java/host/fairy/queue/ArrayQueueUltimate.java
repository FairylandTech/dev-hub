/*****************************************************
 * @software: IntelliJ IDEA
 * @author: Lionel Johnson
 * @contact: https://fairy.host
 * @organization: https://github.com/FairylandFuture
 * @datetime: 2025-09-15 01:02:19 UTC+08:00
 ****************************************************/
package host.fairy.queue;

import java.util.Iterator;

/**
 * Queue implement based on array, ultimate version.
 *
 * @author Lionel Johnson
 * @version 1.0
 * @see Queue
 * @see Iterable
 */
public class ArrayQueueUltimate<E> implements Queue<E>, Iterable<E> {
    private final E[] array;
    private int head = 0;
    private int tail = 0;
    
    @SuppressWarnings("all")
    public ArrayQueueUltimate(int size) throws IllegalArgumentException {
        if ((size & (size - 1)) != 0) {
            size = (int) Math.ceil(Math.log(size) / Math.log(2));
        }
        this.array = (E[]) new Object[size];
    }
    
    /**
     * Insert into end of queue.
     *
     * @param value Value.
     * @return Successfully added.
     * @throws RuntimeException If the queue is full.
     */
    @Override
    public Boolean offer(E value) throws RuntimeException {
        if (this.isFull()) {
            throw new RuntimeException("Queue is full.");
        }
        this.array[this.tail & (this.array.length - 1)] = value;
        this.tail++;
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
        return this.array[this.head & (this.array.length - 1)];
    }
    
    /**
     * Get value from queue head and remove node.
     *
     * @return Value or null if the queue is empty.
     */
    @Override
    public E pool() {
        if (this.isEmpty()) {
            return null;
        }
        
        E value = this.array[this.head & (this.array.length - 1)];
        this.head++;
        return value;
    }
    
    /**
     * Check the queue is empty.
     *
     * @return Ture expression empty, otherwise false.
     */
    @Override
    public Boolean isEmpty() {
        return this.head == this.tail;
    }
    
    /**
     * Check the queue is full.
     *
     * @return Ture expression full, otherwise false.
     */
    @Override
    public Boolean isFull() {
        return (Integer.toUnsignedLong(this.tail) - Integer.toUnsignedLong(this.head)) == this.array.length;
    }
    
    /**
     * An iterator, used loop
     *
     * @return Iterator
     */
    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            int currentIndex = head;
            
            @Override
            public boolean hasNext() {
                return currentIndex != tail;
            }
            
            @Override
            public E next() {
                E value = array[currentIndex & (array.length - 1)];
                currentIndex++;
                return value;
            }
        };
    }
}
