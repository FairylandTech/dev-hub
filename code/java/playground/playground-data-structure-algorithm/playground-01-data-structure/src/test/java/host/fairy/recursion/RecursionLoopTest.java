/*****************************************************
 * @software: IntelliJ IDEA
 * @author: Lionel Johnson
 * @contact: https://fairy.host
 * @organization: https://github.com/FairylandFuture
 * @datetime: 2025-09-05 22:14:06 UTC+08:00
 ****************************************************/
package host.fairy.recursion;

import host.fairy.linkedlist.SinglyLinkedList;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

/**
 * @author Lionel Johnson
 */
public class RecursionLoopTest {
    
    @Test
    @DisplayName("递归遍历单向链表")
    void test1() {
        SinglyLinkedList linkedList = new SinglyLinkedList();
        
        linkedList.addTail(0);
        linkedList.addTail(1);
        linkedList.addTail(2);
        linkedList.addTail(3);
        linkedList.addTail(4);
        linkedList.addTail(5);
        linkedList.addTail(6);
        linkedList.addTail(7);
        linkedList.addTail(8);
        linkedList.addTail(9);
        
        ArrayList<Integer> result = new ArrayList<>();
        RecursionLoop.getElement(linkedList.findNode(0), result);
        System.out.println("result = " + result);
    }
}
