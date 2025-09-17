/*****************************************************
 * @software: IntelliJ IDEA
 * @author: Lionel Johnson
 * @contact: https://fairy.host
 * @organization: https://github.com/FairylandFuture
 * @datetime: 2025-09-11 14:25:36 UTC+08:00
 ****************************************************/
package host.fairy.queue;

/**
 * Queue interface.
 *
 * @author Lionel Johnson
 * @version 1.0
 */
public interface Queue<E> {
    /**
     * Insert into end of queue.
     *
     * @param value Value.
     * @return Successfully added.
     */
    Boolean offer(E value);
    
    /**
     * Get value from queue head, but not remove.
     *
     * @return Value or null if the queue is empty.
     */
    E peek();
    
    /**
     * Get value from queue head and remove node.
     *
     * @return Value or null if the queue is empty.
     */
    E poll();
    
    /**
     * Check the queue is empty.
     *
     * @return Ture expression empty, otherwise false.
     */
    Boolean isEmpty();
    
    /**
     * Check the queue is full.
     *
     * @return Ture expression full, otherwise false.
     */
    Boolean isFull();
}
