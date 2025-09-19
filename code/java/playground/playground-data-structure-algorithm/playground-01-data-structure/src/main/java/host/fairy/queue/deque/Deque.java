/*****************************************************
 * @software: IntelliJ IDEA
 * @author: Lionel Johnson
 * @contact: https://fairy.host
 * @organization: https://github.com/FairylandFuture
 * @datetime: 2025-09-16 21:37:10 UTC+08:00
 ****************************************************/
package host.fairy.queue.deque;

/**
 * {@code Deque} 双端队列
 *
 * @param <E> Deque element type.
 * @author Lionel Johnson
 * @version 1.0
 */
public interface Deque<E> {
    /**
     * Add value to head of deque.
     *
     * @param value Value.
     * @return Successfully added return true, otherwise false.
     */
    boolean offerFirst(E value);
    
    /**
     * Add value to the tail of deque.
     *
     * @param value Value.
     * @return Successfully added return true, otherwise flase.
     */
    boolean offerLast(E value);
    
    /**
     * Get value from head of deque, but not remove.
     *
     * @return Value or null if deque is empty.
     */
    E peekFirst();
    
    /**
     * Get value from the tail of deque, but not remove.
     *
     * @return Value or null if deque is empty.
     */
    E peekLast();
    
    /**
     * Get value from head of deque and remove value.
     *
     * @return Value of null if deque is empty.
     */
    E pollFirst();
    
    /**
     * Get value from the tail of deque and remove value.
     *
     * @return Value of null if deque is empty.
     */
    E pollLast();
    
    /**
     * Check the deque is empty.
     *
     * @return If deque is empty, return ture, otherwise false.
     */
    boolean isEmpty();
    
    /**
     * Check the deque is full.
     *
     * @return If deque is full, retuen true, otherwise false.
     */
    boolean isFull();
}
