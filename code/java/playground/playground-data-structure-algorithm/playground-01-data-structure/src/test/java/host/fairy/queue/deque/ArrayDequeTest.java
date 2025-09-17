/*****************************************************
 * @software: IntelliJ IDEA
 * @author: Lionel Johnson
 * @contact: https://fairy.host
 * @organization: https://github.com/FairylandFuture
 * @datetime: 2025-09-17 14:11:44 UTC+08:00
 ****************************************************/
package host.fairy.queue.deque;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * @author Lionel Johnson
 * @version 1.0
 *
 */
public class ArrayDequeTest {
    @Test
    @DisplayName(" offer ")
    void offer() {
        ArrayDeque<Integer> deque = new ArrayDeque<>(10);
        deque.offerFirst(1);
        deque.offerLast(2);
        deque.offerLast(3);
        
        System.out.println("deque.pollFirst() = " + deque.pollFirst());
        
        deque.offerFirst(4);
        deque.offerLast(11);
        deque.offerLast(12);
        deque.offerLast(13);
        deque.offerLast(14);
        deque.offerLast(15);
        deque.offerLast(16);
        deque.offerLast(17);
        deque.offerLast(18);
        
        deque.forEach(System.out::println);
    }
}
