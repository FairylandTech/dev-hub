/*****************************************************
 * @software: IntelliJ IDEA
 * @author: Lionel Johnson
 * @contact: https://fairy.host
 * @organization: https://github.com/FairylandFuture
 * @datetime: 2025-09-04 17:27:12 UTC+08:00
 ****************************************************/
package host.fairy.linkedlist;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Lionel Johnson
 */
public class SinglyLinkedListSentinelTest {
    private static final List<Integer> linkedListTarget = Arrays.asList(1, 2, 3);
    
    @Test
    @DisplayName("添加元素到链表尾部")
    void test1() {
        SinglyLinkedListSentinel linkedList = new SinglyLinkedListSentinel();
        linkedList.addTail(1);
        linkedList.addTail(2);
        linkedList.addTail(3);
        
        assertIterableEquals(linkedListTarget, linkedList);
    }
    
    @Test
    @DisplayName("获取元素")
    void test2() {
        SinglyLinkedListSentinel linkedList = new SinglyLinkedListSentinel();
        linkedList.addTail(1);
        linkedList.addTail(2);
        linkedList.addTail(3);
        
        assertIterableEquals(linkedListTarget, linkedList);
        
        assertEquals(1, linkedList.get(0));
        assertEquals(2, linkedList.get(1));
        assertEquals(3, linkedList.get(2));
        assertThrows(IndexOutOfBoundsException.class, () -> linkedList.get(4));
    }
    
    @Test
    @DisplayName("插入元素")
    void test3() {
        SinglyLinkedListSentinel linkedList = new SinglyLinkedListSentinel();
        linkedList.addTail(1);
        linkedList.addTail(2);
        
        linkedList.insert(0, 0);
        linkedList.insert(3, 3);
        
        assertIterableEquals(Arrays.asList(0, 1, 2, 3), linkedList);
        assertThrows(IndexOutOfBoundsException.class, () -> linkedList.insert(5, 5));
    }
    
    @Test
    @DisplayName("删除元素")
    void test4() {
        SinglyLinkedListSentinel linkedList = new SinglyLinkedListSentinel();
        linkedList.addTail(1);
        linkedList.addTail(2);
        
        assertEquals(1, linkedList.remove(0));
        assertThrows(IndexOutOfBoundsException.class, () -> linkedList.remove(3));
        
        System.out.println("linkedList = " + linkedList);
    }
}
