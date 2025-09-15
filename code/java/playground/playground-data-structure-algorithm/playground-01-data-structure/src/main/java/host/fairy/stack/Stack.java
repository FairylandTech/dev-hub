/*****************************************************
 * @software: IntelliJ IDEA
 * @author: Lionel Johnson
 * @contact: https://fairy.host
 * @organization: https://github.com/FairylandFuture
 * @datetime: 2025-09-15 22:30:27 UTC+08:00
 ****************************************************/
package host.fairy.stack;

/**
 * {@code stack} interfce
 *
 * @param <E> Stack element type
 * @author Lionel Johnson
 * @version 1.0
 */
public interface Stack<E> {
    /**
     * Add value to top of stack.
     *
     * @param value Value.
     * @return Ture: successfully added, otherwise false.
     */
    boolean push(E value);
    
    /**
     * Pop Value from top of stack.
     *
     * @return Value or null if stack is empty.
     */
    E pop();
    
    /**
     * Peek value from top of stack, but not remove.
     *
     * @return Value or null if stack is empty.
     */
    E peek();
    
    /**
     * Check the stack is empty.
     *
     * @return Ture expression empty, otherwise false.
     */
    boolean isEmpty();
    
    /**
     * Check the stack is full.
     *
     * @return Ture expression full, otherwise false.
     */
    boolean isFull();
}
