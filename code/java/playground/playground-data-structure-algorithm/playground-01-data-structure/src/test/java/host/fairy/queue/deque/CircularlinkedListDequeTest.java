/*****************************************************
 * @software: IntelliJ IDEA
 * @author: Lionel Johnson
 * @contact: https://fairy.host
 * @organization: https://github.com/FairylandFuture
 * @datetime: 2025-09-16 22:15:15 UTC+08:00
 ****************************************************/
package host.fairy.queue.deque;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * @author Lionel Johnson
 * @version 1.0
 *
 */
public class CircularlinkedListDequeTest {
    @Test
    @DisplayName(" offer ")
    void offer() {
        CircularlinkedListDeque<Integer> deque = new CircularlinkedListDeque<>(20);
        deque.offerFirst(1);
        deque.offerFirst(2);
        deque.offerLast(3);
        deque.offerLast(4);
        
        deque.forEach(System.out::println);
    }
    
    @Test
    @DisplayName(" poll ")
    void poll() {
        CircularlinkedListDeque<Integer> deque = new CircularlinkedListDeque<>(20);
        deque.offerFirst(1);
        deque.offerFirst(2);
        deque.offerLast(3);
        deque.offerLast(4);
        System.out.println("deque.pollFirst() = " + deque.pollFirst());
        System.out.println("deque.pollLast() = " + deque.pollLast());
        
        deque.forEach(System.out::println);
    }
}
