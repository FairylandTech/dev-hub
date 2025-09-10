/*****************************************************
 * @software: IntelliJ IDEA
 * @author: Lionel Johnson
 * @contact: https://fairy.host
 * @organization: https://github.com/FairylandFuture
 * @datetime: 2025-09-05 22:16:14 UTC+08:00
 ****************************************************/
package host.fairy.recursion;

import host.fairy.linkedlist.SinglyLinkedList;

import java.util.List;

/**
 * @author Lionel Johnson
 */
public class RecursionLoop {
    public static void getElement(SinglyLinkedList.Node node, List<Integer> result) {
        if (node == null) {
            return;
        }
        result.add(node.value);
        getElement(node.next, result);
    }
}
