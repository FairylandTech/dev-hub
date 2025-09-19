/*****************************************************
 * @software: IntelliJ IDEA
 * @author: Lionel Johnson
 * @contact: https://fairy.host
 * @organization: https://github.com/FairylandFuture
 * @datetime: 2025-09-17 17:21:32 UTC+08:00
 ****************************************************/
package host.fairy.queue.priority;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * @author Lionel Johnson
 * @version 1.0
 * @see ArrayPriorityQueuePlus
 * @see Entity
 */
public class ArrayPriorityQueuePlusTest {
    @Test
    @DisplayName(" offer ")
    void offer() {
        ArrayPriorityQueuePlus<Entity> queue = new ArrayPriorityQueuePlus<>(10);
        queue.offer(Entity.builder().name("A").priority(3).build());
        queue.offer(Entity.builder().name("B").priority(1).build());
        queue.offer(Entity.builder().name("C").priority(2).build());
        queue.offer(Entity.builder().name("D").priority(4).build());
        queue.offer(Entity.builder().name("E").priority(2).build());
        
        
        
        System.out.println("queue = " + queue);
    }
}
