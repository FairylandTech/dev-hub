/*****************************************************
 * @software: IntelliJ IDEA
 * @author: Lionel Johnson
 * @contact: https://fairy.host
 * @organization: https://github.com/FairylandFuture
 * @datetime: 2025-09-15 00:19:09 UTC+08:00
 ****************************************************/
package host.fairy.queue;

import org.apache.commons.lang3.builder.ToStringBuilder;

import java.util.Iterator;

/**
 * Queue implement based on array
 *
 * @param <E> Queue elemant type.
 * @author Lionel Johnson
 * @version 1.0
 * @see Queue
 * @see Iterable
 */
public class ArrayQueuePlus<E> implements Queue<E>, Iterable<E> {
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
    
    /**
     * Queue current index.
     */
    private int index = 0;
    
    @SuppressWarnings("all")
    public ArrayQueuePlus(int size) {
        this.array = (E[]) new Object[size];
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
            throw new RuntimeException("Queue is full.");
        }
        this.array[this.tail] = value;
        this.tail = (this.tail + 1) % this.array.length;
        this.index++;
        return null;
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
        this.index--;
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
            Integer currentIndex = head;
            Integer total = 0;
            
            @Override
            public boolean hasNext() {
                return index > total;
            }
            
            @Override
            public E next() {
                E value = array[currentIndex];
                currentIndex = (currentIndex + 1) % array.length;
                total++;
                return value;
            }
        };
    }
    
    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("array", array)
                .append("head", head)
                .append("tail", tail)
                .append("index", index)
                .toString();
    }
}
