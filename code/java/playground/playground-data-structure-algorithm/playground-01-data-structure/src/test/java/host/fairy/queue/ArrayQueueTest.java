/*****************************************************
 * @software: IntelliJ IDEA
 * @author: Lionel Johnson
 * @contact: https://fairy.host
 * @organization: https://github.com/FairylandFuture
 * @datetime: 2025-09-15 00:01:56 UTC+08:00
 ****************************************************/
package host.fairy.queue;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * ArrayQueue Test
 *
 * @author Lionel Johnson
 * @version 1.0
 * @see ArrayQueue
 */
public class ArrayQueueTest {
    @Test
    @DisplayName(" offer ")
    void offer() {
        ArrayQueue<Integer> queue = new ArrayQueue<>(10);
        queue.offer(1);
        queue.offer(2);
        queue.offer(3);
        System.out.println();
        queue.forEach(System.out::println);
    }
    
    @Test
    @DisplayName(" peek ")
    void peek() {
        ArrayQueue<Integer> queue = new ArrayQueue<>(10);
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
        ArrayQueue<Integer> queue = new ArrayQueue<>(10);
        queue.offer(1);
        queue.offer(2);
        queue.offer(3);
        
        Integer first = queue.poll();
        System.out.println("first = " + first);
        Integer second = queue.poll();
        System.out.println("second = " + second);
        
        System.out.println();
        queue.forEach(System.out::println);
    }
}
