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
     * @param value vaule.
     * @return success or not.
     */
    Boolean offer(E value);
    
    /**
     * Get value from queue head, but not remove.
     *
     * @return value or null if the queue is empty.
     */
    E peek();
    
    /**
     * Get value from queue head and remove node.
     *
     * @return value or null if the queue is empty.
     */
    E pool();
    
    /**
     * Check the queue is empty.
     *
     * @return empty or not.
     */
    Boolean isEmpty();
    
    /**
     * Check the queue is full.
     *
     * @return full or not.
     */
    Boolean isFull();
}
