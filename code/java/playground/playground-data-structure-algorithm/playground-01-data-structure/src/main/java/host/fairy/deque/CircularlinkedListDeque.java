/*****************************************************
 * @software: IntelliJ IDEA
 * @author: Lionel Johnson
 * @contact: https://fairy.host
 * @organization: https://github.com/FairylandFuture
 * @datetime: 2025-09-16 21:47:29 UTC+08:00
 ****************************************************/
package host.fairy.deque;

import java.util.Iterator;

/**
 * Deque implement based on Circular linked list.
 *
 * @param <E> Deque element type.
 * @author Lionel Johnson
 * @version 1.0
 * @see Deque
 * @see Iterable
 */
public class CircularlinkedListDeque<E> implements Deque<E>, Iterable<E> {
    private final Node<E> sentinel = new Node<>(null, null, null);
    private final int size;
    private int index;
    
    public CircularlinkedListDeque(int size) {
        sentinel.next = this.sentinel;
        sentinel.prev = this.sentinel;
        this.size = size;
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
        Node<E> prev = this.sentinel;
        Node<E> next = this.sentinel.next;
        Node<E> node = new Node<>(value, prev, next);
        prev.next = node;
        next.prev = node;
        this.index++;
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
        Node<E> prev = this.sentinel.prev;
        Node<E> next = this.sentinel;
        Node<E> node = new Node<>(value, prev, next);
        prev.next = node;
        next.prev = node;
        this.index++;
        return true;
    }
    
    /**
     * Get value from head of deque, but not remove.
     *
     * @return Value or null if deque is empty.
     */
    @Override
    public E peekFirst() {
        if (this.isFull()) {
            return null;
        }
        return this.sentinel.next.value;
    }
    
    /**
     * Get value from the tail of deque, but not remove.
     *
     * @return Value or null if deque is empty.
     */
    @Override
    public E peekLast() {
        if (this.isFull()) {
            return null;
        }
        return this.sentinel.prev.value;
    }
    
    /**
     * Get value from head of deque and remove value.
     *
     * @return Value of null if deque is empty.
     */
    @Override
    public E pollFirst() {
        if (this.isFull()) {
            return null;
        }
        Node<E> node = this.sentinel.next;
        this.sentinel.next = node.next;
        node.next.prev = this.sentinel;
        this.index--;
        return node.value;
    }
    
    /**
     * Get value from the tail of deque and remove value.
     *
     * @return Value of null if deque is empty.
     */
    @Override
    public E pollLast() {
        if (this.isFull()) {
            return null;
        }
        Node<E> node = this.sentinel.prev;
        this.sentinel.prev = node.prev;
        node.prev.next = this.sentinel;
        this.index--;
        return node.value;
    }
    
    /**
     * Check the deque is empty.
     *
     * @return If deque is empty, return ture, otherwise false.
     */
    @Override
    public boolean isEmpty() {
        return this.index == 0;
    }
    
    /**
     * Check the deque is full.
     *
     * @return If deque is full, retuen true, otherwise false.
     */
    @Override
    public boolean isFull() {
        return this.index == this.size;
    }
    
    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            Node<E> node = sentinel.next;
            
            @Override
            public boolean hasNext() {
                return node != sentinel;
            }
            
            @Override
            public E next() {
                E value = node.value;
                node = node.next;
                return value;
            }
        };
    }
    
    /**
     * Node of circular linked list.
     *
     * @param <E> Node value type.
     */
    static class Node<E> {
        E value;
        Node<E> prev;
        Node<E> next;
        
        public Node(E value, Node<E> prev, Node<E> next) {
            this.value = value;
            this.prev = prev;
            this.next = next;
        }
    }
}
