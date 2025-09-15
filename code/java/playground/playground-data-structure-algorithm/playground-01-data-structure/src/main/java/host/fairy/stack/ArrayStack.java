/*****************************************************
 * @software: IntelliJ IDEA
 * @author: Lionel Johnson
 * @contact: https://fairy.host
 * @organization: https://github.com/FairylandFuture
 * @datetime: 2025-09-16 00:19:57 UTC+08:00
 ****************************************************/
package host.fairy.stack;

import java.util.Iterator;

/**
 * Stack implement base on array.
 *
 * @author Lionel Johnson
 * @version 1.0
 * @see Stack
 * @see Iterable
 */
public class ArrayStack<E> implements Stack<E>, Iterable<E> {
    private final E[] array;
    private int topPointer;
    
    @SuppressWarnings("all")
    public ArrayStack(int size) {
        this.array = (E[]) new Object[size];
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
        this.array[this.topPointer++] = value;
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
        E value = this.array[--this.topPointer];
        this.array[this.topPointer] = null;  // remove reference for GC.
        return value;
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
        return this.array[--this.topPointer];
        
    }
    
    /**
     * Check the stack is empty.
     *
     * @return Ture expression empty, otherwise false.
     */
    @Override
    public boolean isEmpty() {
        return this.topPointer == 0;
    }
    
    /**
     * Check the stack is full.
     *
     * @return Ture expression full, otherwise false.
     */
    @Override
    public boolean isFull() {
        return this.topPointer == this.array.length;
    }
    
    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            int index = topPointer;
            
            @Override
            public boolean hasNext() {
                return index > 0;
            }
            
            @Override
            public E next() {
                return array[--index];
            }
        };
    }
}
