/*****************************************************
 * @software: IntelliJ IDEA
 * @author: Lionel Johnson
 * @contact: https://fairy.host
 * @organization: https://github.com/FairylandFuture
 * @datetime: 2025-09-17 13:26:00 UTC+08:00
 ****************************************************/
package host.fairy.queue.deque;

import java.util.Iterator;

/**
 * Deque implement based on array.
 *
 * @author Lionel Johnson
 * @version 1.0
 * @see Deque
 * @see Iterable
 */
public class ArrayDeque<E> implements Deque<E>, Iterable<E> {
    private final E[] array;
    private int head;
    private int tail;
    
    @SuppressWarnings("all")
    public ArrayDeque(int size) {
        this.array = (E[]) new Object[size + 1];
    }
    
    /**
     * Calculate the next index.
     *
     * @param index Current index.
     * @return Next index.
     */
    private int addIndex(int index) {
        if (++index >= this.array.length) return 0;
        return index;
    }
    
    /**
     * Calculate the previous index.
     *
     * @param index Current index.
     * @return Previous index.
     */
    private int subIndex(int index) {
        if (--index < 0) return this.array.length - 1;
        return index;
    }
    
    /**
     * Add value to head of deque.
     *
     * @param value Value.
     * @return Successfully added return true, otherwise false.
     */
    @Override
    public boolean offerFirst(E value) {
        if (this.isFull()) {
            return false;
        }
        this.head = this.subIndex(this.head);
        this.array[this.head] = value;
        return true;
    }
    
    /**
     * Add value to the tail of deque.
     *
     * @param value Value.
     * @return Successfully added return true, otherwise flase.
     */
    @Override
    public boolean offerLast(E value) {
        if (this.isFull()) {
            return false;
        }
        this.array[this.tail] = value;
        this.tail = this.addIndex(this.tail);
        return true;
    }
    
    /**
     * Get value from head of deque, but not remove.
     *
     * @return Value or null if deque is empty.
     */
    @Override
    public E peekFirst() {
        if (this.isEmpty()) {
            return null;
        }
        return this.array[this.head];
    }
    
    /**
     * Get value from the tail of deque, but not remove.
     *
     * @return Value or null if deque is empty.
     */
    @Override
    public E peekLast() {
        if (this.isEmpty()) {
            return null;
        }
        return this.array[this.subIndex(this.tail)];
    }
    
    /**
     * Get value from head of deque and remove value.
     *
     * @return Value of null if deque is empty.
     */
    @Override
    public E pollFirst() {
        if (this.isEmpty()) {
            return null;
        }
        E value = this.array[this.head];
        this.array[this.head] = null; // Help GC
        this.head = this.addIndex(this.head);
        return value;
    }
    
    /**
     * Get value from the tail of deque and remove value.
     *
     * @return Value of null if deque is empty.
     */
    @Override
    public E pollLast() {
        if (this.isEmpty()) {
            return null;
        }
        this.tail = this.subIndex(this.tail);
        E value = this.array[this.tail];
        this.array[this.tail] = null; // Help GC
        return value;
    }
    
    /**
     * Check the deque is empty.
     *
     * @return If deque is empty, return ture, otherwise false.
     */
    @Override
    public boolean isEmpty() {
        return this.tail == this.head;
    }
    
    /**
     * Check the deque is full.
     *
     * @return If deque is full, retuen true, otherwise false.
     */
    @Override
    public boolean isFull() {
        if (this.tail > this.head) {
            return this.tail - this.head == this.array.length - 1;
        } else if (this.tail < this.head) {
            return this.head - this.tail == 1;
        } else {
            return false;
        }
    }
    
    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            int index = head;
            
            @Override
            public boolean hasNext() {
                return index != tail;
            }
            
            @Override
            public E next() {
                E value = array[index];
                if (++index >= array.length) index = 0;
                return value;
            }
        };
    }
}
