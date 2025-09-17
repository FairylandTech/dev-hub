/*****************************************************
 * @software: IntelliJ IDEA
 * @author: Lionel Johnson
 * @contact: https://fairy.host
 * @organization: https://github.com/FairylandFuture
 * @datetime: 2025-09-14 20:55:18 UTC+08:00
 ****************************************************/
package host.fairy.queue;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * LinkedListQueue Test
 *
 * @author Lionel Johnson
 * @version 1.0
 * @see LinkedListQueue
 */
public class LinkedListQueueTest {
    @Test
    @DisplayName(" offer ")
    void offer() {
        LinkedListQueue<Integer> queue = new LinkedListQueue<>();
        queue.offer(1);
        queue.offer(2);
        queue.offer(3);
        queue.forEach(System.out::println);
        System.out.println();
        System.out.println("queue.isEmpty() = " + queue.isEmpty());
    }
    
    @Test
    @DisplayName(" peek ")
    void peek() {
        LinkedListQueue<Integer> queue = new LinkedListQueue<>();
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
        LinkedListQueue<Integer> queue = new LinkedListQueue<>();
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
    
    @Test
    @DisplayName(" is full ")
    void isFull() {
        LinkedListQueue<Integer> queue = new LinkedListQueue<>();
        LinkedListQueue<Object> fullQueue = new LinkedListQueue<>();
        for (int i = 0; i < 15; i++) {
            queue.offer(i);
        }
        for (int i = 0; i < 20; i++) {
            fullQueue.offer(i);
        }
        System.out.println("queue.isFull() = " + queue.isFull());
        System.out.println("fullQueue.isFull() = " + fullQueue.isFull());
    }
}
