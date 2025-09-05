/*****************************************************
 * @software: IntelliJ IDEA
 * @author: Lionel Johnson
 * @contact: https://fairy.host
 * @organization: https://github.com/FairylandFuture
 * @datetime: 2025-09-05 17:49:20 UTC+08:00
 ****************************************************/
package host.fairy.linkedlist;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * @author Lionel Johnson
 */
public class DoublyLinkedListSentinelTest {
    
    @Test
    @DisplayName("插入")
    void test1() {
        DoublyLinkedListSentinel list = new DoublyLinkedListSentinel();
        list.insert(0, 0);
        list.insert(1, 1);
        
        list.forEach(System.out::println);
    }
    
    @Test
    @DisplayName("删除")
    void test2() {
        DoublyLinkedListSentinel list = new DoublyLinkedListSentinel();
        
        list.insert(0, 0);
        list.insert(1, 1);
        list.insert(2, 2);
        list.insert(3, 3);
        list.insert(4, 4);
        
        list.remove(2);
        
        list.forEach(System.out::println);
    }
    
    @Test
    @DisplayName("添加")
    void test3() {
        DoublyLinkedListSentinel list = new DoublyLinkedListSentinel();
        System.out.println("list.size() = " + list.size());
        
        list.add(0);
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        
        System.out.println("list.size() = " + list.size());
        list.forEach(System.out::println);
    }
    
    @Test
    @DisplayName("查找")
    void test4() {
        DoublyLinkedListSentinel list = new DoublyLinkedListSentinel();
        list.add(0);
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        
        System.out.println("list.get(0) = " + list.get(0));
        System.out.println("list.get(1) = " + list.get(1));
        System.out.println("list.get(2) = " + list.get(2));
        System.out.println("list.get(3) = " + list.get(3));
        System.out.println("list.get(4) = " + list.get(4));
    }
}
