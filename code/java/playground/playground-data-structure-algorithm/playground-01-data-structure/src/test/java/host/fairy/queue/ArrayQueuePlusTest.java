/*****************************************************
 * @software: IntelliJ IDEA
 * @author: Lionel Johnson
 * @contact: https://fairy.host
 * @organization: https://github.com/FairylandFuture
 * @datetime: 2025-09-15 00:43:08 UTC+08:00
 ****************************************************/
package host.fairy.queue;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * ArrayQueuePlus Test
 *
 * @author Lionel Johnson
 * @version 1.0
 * @see ArrayQueuePlus
 */
public class ArrayQueuePlusTest {
    @Test
    @DisplayName(" offer ")
    void offer() {
        ArrayQueuePlus<Integer> queue = new ArrayQueuePlus<>(10);
        queue.offer(1);
        queue.offer(2);
        queue.offer(3);
        System.out.println("queue = " + queue);
        queue.forEach(System.out::println);
    }
    
    @Test
    @DisplayName(" peek ")
    void peek() {
        ArrayQueuePlus<Integer> queue = new ArrayQueuePlus<>(10);
        queue.offer(1);
        queue.offer(2);
        queue.offer(3);
        
        Integer first = queue.peek();
        System.out.println("first = " + first);
        System.out.println();
        queue.forEach(System.out::println);
    }
    
    @Test
    @DisplayName(" poll ")
    void poll() {
        ArrayQueuePlus<Integer> queue = new ArrayQueuePlus<>(10);
        queue.offer(1);
        queue.offer(2);
        queue.offer(3);
        
        Integer first = queue.poll();
        System.out.println("first = " + first);
        Integer second = queue.poll();
        System.out.println("second = " + second);
        
        System.out.println("queue = " + queue);
        queue.forEach(System.out::println);
    }
}
