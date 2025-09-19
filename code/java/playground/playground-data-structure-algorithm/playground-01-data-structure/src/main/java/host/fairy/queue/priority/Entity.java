/*****************************************************
 * @software: IntelliJ IDEA
 * @author: Lionel Johnson
 * @contact: https://fairy.host
 * @organization: https://github.com/FairylandFuture
 * @datetime: 2025-09-17 16:20:12 UTC+08:00
 ****************************************************/
package host.fairy.queue.priority;

import lombok.Builder;
import lombok.Data;

/**
 * Entity test.
 *
 * @author Lionel Johnson
 * @version 1.0
 * @see Priority
 */
@Data
@Builder
public class Entity implements Priority {
    private final String name;
    private final int priority;
    
    /**
     * Get priority, the smaller the value, the higher the priority.
     *
     * @return Priority value.
     */
    @Override
    public int getPriority() {
        return this.priority;
    }
}
