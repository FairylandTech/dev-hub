/*****************************************************
 * @software: IntelliJ IDEA
 * @author: Lionel Johnson
 * @contact: https://fairy.host
 * @organization: https://github.com/FairylandFuture
 * @datetime: 2025-09-05 19:44:02 UTC+08:00
 ****************************************************/
package host.fairy.linkedlist;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * @author Lionel Johnson
 */
public class CircularLinkedListSentinelTest {
    @Test
    @DisplayName("添加")
    void test1() {
        CircularLinkedListSentinel linkedList = new CircularLinkedListSentinel();
        linkedList.add(1);
        linkedList.add(2);
        linkedList.add(3);
        
        linkedList.forEach(System.out::println);
    }
    
    @Test
    @DisplayName("插入")
    void test2() {
        CircularLinkedListSentinel linkedList = new CircularLinkedListSentinel();
        linkedList.add(0);
        linkedList.add(1);
        linkedList.add(2);
        linkedList.add(0, 10);
        
        linkedList.forEach(System.out::println);
    }
}
