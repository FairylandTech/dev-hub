/*****************************************************
 * @software: IntelliJ IDEA
 * @author: Lionel Johnson
 * @contact: https://fairy.host
 * @organization: https://github.com/FairylandFuture
 * @datetime: 2025-09-14 23:19:04 UTC+08:00
 ****************************************************/
package host.fairy.queue;

import java.util.Iterator;
import java.util.Objects;

/**
 * Queue implement based on array.
 *
 * @param <E> Queue elemant type.
 * @author Lionel Johnson
 * @version 1.0
 * @see Queue
 * @see Iterable
 */
public class ArrayQueue<E> implements Queue<E>, Iterable<E> {
    /**
     * Array to store queue.
     */
    private final E[] array;
    
    /**
     * Queue head index.
     */
    private int head = 0;
    
    /**
     * Queue tail index.
     */
    private int tail = 0;
    
    @SuppressWarnings("all")
    public ArrayQueue(int size) {
        this.array = (E[]) new Object[size + 1];
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
            throw new RuntimeException("Queue is full");
        }
        this.array[this.tail] = value;
        this.tail = (this.tail + 1) % this.array.length;
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
        
        return this.array[this.head];
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
        
        E value = this.array[this.head];
        this.head = (this.head + 1) % this.array.length;
        
        return value;
    }
    
    /**
     * Check the queue is empty.
     *
     * @return Ture expression empty, otherwise false.
     */
    @Override
    public Boolean isEmpty() {
        return this.tail == this.head;
    }
    
    /**
     * Check the queue is full.
     *
     * @return Ture expression full, otherwise false.
     */
    @Override
    public Boolean isFull() {
        return (this.tail + 1) % this.array.length == this.head;
    }
    
    /**
     * An iterator, used loop.
     *
     * @return Iterator
     */
    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            Integer currentIndex = head;
            
            @Override
            public boolean hasNext() {
                return !Objects.equals(currentIndex, tail);
            }
            
            @Override
            public E next() {
                E value = array[currentIndex];
                currentIndex = (currentIndex + 1) % array.length;
                return value;
            }
        };
    }
}
