/*****************************************************
 * @software: IntelliJ IDEA
 * @author: Lionel Johnson
 * @contact: https://fairy.host
 * @organization: https://github.com/FairylandFuture
 * @datetime: 2025-09-03 10:49:18 UTC+08:00
 ****************************************************/
package host.fairy.demo;

import host.fairy.datastructure.linkedlist.SinglyLinkedList;

/**
 * @author Lionel Johnson
 */
public class SinglyLinkedListDemo {
    public static void main(String[] args) {
        SinglyLinkedList singlyLinkedList = new SinglyLinkedList();
        singlyLinkedList.addTail(1);
        singlyLinkedList.addTail(2);
        singlyLinkedList.addTail(3);
        
        singlyLinkedList.insert(3, 11);
        
        singlyLinkedList.loopFor(System.out::println);
    }
}
