/*****************************************************
 * @software: IntelliJ IDEA
 * @author: Lionel Johnson
 * @contact: https://fairy.host
 * @organization: https://github.com/FairylandFuture
 * @datetime: 2025-09-15 22:48:43 UTC+08:00
 ****************************************************/
package host.fairy.stack;

import java.util.Iterator;

/**
 * Stack implement base on linkedlist.
 *
 * @author Lionel Johnson
 * @version 1.0
 * @see Stack
 * @see Iterable
 */
public class LinkedListStack<E> implements Stack<E>, Iterable<E> {
    /**
     * Stack head node (Sentinel)
     */
    private final Node<E> head = new Node<>(null, null);
    
    /**
     * Max stack size.
     */
    private final int size;
    
    /**
     * Current stack size.
     */
    private int index;
    
    public LinkedListStack(int size) {
        this.size = size;
    }
    
    /**
     * Add value to top of stack.
     *
     * @param value Value.
     * @return Ture: successfully added, otherwise false.
     */
    @Override
    public boolean push(E value) {
        if (this.isFull()) {
            return false;
        }
        this.head.next = new Node<>(value, this.head.next);
        this.index++;
        return true;
    }
    
    /**
     * Pop Value from top of stack.
     *
     * @return Value or null if stack is empty.
     */
    @Override
    public E pop() {
        if (this.isEmpty()) {
            return null;
        }
        
        Node<E> topNode = this.head.next;
        this.head.next = topNode.next;
        this.index--;
        return topNode.value;
    }
    
    /**
     * Peek value from top of stack, but not remove.
     *
     * @return Value or null if stack is empty.
     */
    @Override
    public E peek() {
        if (this.isEmpty()) {
            return null;
        }
        return this.head.next.value;
    }
    
    /**
     * Check the stack is empty.
     *
     * @return Ture expression empty, otherwise false.
     */
    @Override
    public boolean isEmpty() {
        return this.index == 0;
    }
    
    /**
     * Check the stack is full.
     *
     * @return Ture expression full, otherwise false.
     */
    @Override
    public boolean isFull() {
        return this.index == this.size;
    }
    
    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            Node<E> currentNode = head.next;
            
            @Override
            public boolean hasNext() {
                return currentNode != null;
            }
            
            @Override
            public E next() {
                E value = currentNode.value;
                currentNode = currentNode.next;
                return value;
            }
        };
    }
    
    /**
     * Link node definition.
     *
     * @param <E> Node value type.
     */
    private static class Node<E> {
        E value;
        Node<E> next;
        
        Node(E value, Node<E> next) {
            this.value = value;
            this.next = next;
        }
    }
}
