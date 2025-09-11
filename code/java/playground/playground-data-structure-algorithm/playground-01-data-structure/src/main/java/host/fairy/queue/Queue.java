/*****************************************************
 * @software: IntelliJ IDEA
 * @author: Lionel Johnson
 * @contact: https://fairy.host
 * @organization: https://github.com/FairylandFuture
 * @datetime: 2025-09-11 14:25:36 UTC+08:00
 ****************************************************/
package host.fairy.queue;

/**
 * @author Lionel Johnson
 * @version 1.0
 * @deprecated Queue: 队列接口
 */
public interface Queue<E> {
    Queue<E> enqueue(E e);
    
    E dequeue();
}
