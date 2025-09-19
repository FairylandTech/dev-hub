/*****************************************************
 * @software: IntelliJ IDEA
 * @author: Lionel Johnson
 * @contact: https://fairy.host
 * @organization: https://github.com/FairylandFuture
 * @datetime: 2025-09-17 16:25:27 UTC+08:00
 ****************************************************/
package host.fairy.queue.priority;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * @author Lionel Johnson
 * @version 1.0
 * @see ArrayPriorityQueue
 * @see Entity
 */
public class ArrayPriorityQueueTest {
    @Test
    @DisplayName(" offer ")
    void offer() {
        ArrayPriorityQueue<Entity> queue = new ArrayPriorityQueue<>(10);
        queue.offer(Entity.builder().name("A").priority(3).build());
        queue.offer(Entity.builder().name("B").priority(5).build());
        queue.offer(Entity.builder().name("C").priority(1).build());
        queue.offer(Entity.builder().name("D").priority(4).build());
        queue.offer(Entity.builder().name("E").priority(2).build());
        
        System.out.println("queue.peek() = " + queue.peek());
        System.out.println("queue.poll() = " + queue.poll());
        System.out.println("queue.poll() = " + queue.poll());
        
        queue.forEach(System.out::println);
    }
}
