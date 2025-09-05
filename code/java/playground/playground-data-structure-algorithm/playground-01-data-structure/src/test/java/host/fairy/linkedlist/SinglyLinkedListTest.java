/*****************************************************
 * @software: IntelliJ IDEA
 * @author: Lionel Johnson
 * @contact: https://fairy.host
 * @organization: https://github.com/FairylandFuture
 * @datetime: 2025-09-03 10:49:18 UTC+08:00
 ****************************************************/
package host.fairy.linkedlist;

import host.fairy.linkedlist.SinglyLinkedList;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * @author Lionel Johnson
 */
public class SinglyLinkedListTest {
    public static void main(String[] args) {
        SinglyLinkedList singlyLinkedList = new SinglyLinkedList();
        singlyLinkedList.addTail(1);
        singlyLinkedList.addTail(2);
        singlyLinkedList.addTail(3);
        
        singlyLinkedList.insert(3, 11);
        
        System.out.println("singlyLinkedList = " + singlyLinkedList);
        
        singlyLinkedList.remove(1);
        
        System.out.println("singlyLinkedList = " + singlyLinkedList);
    }
    
    @Test
    @DisplayName("SinglyLinkedList Demo")
    public void testSinglyLinkedList() {
        
    }
}
