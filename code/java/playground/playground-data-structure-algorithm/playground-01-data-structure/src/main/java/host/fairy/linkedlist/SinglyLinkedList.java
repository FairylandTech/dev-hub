/*****************************************************
 * @software: IntelliJ IDEA
 * @author: Lionel Johnson
 * @contact: https://fairy.host
 * @organization: https://github.com/FairylandFuture
 * @datetime: 2025-09-01 13:21:38 UTC+08:00
 ****************************************************/
package host.fairy.linkedlist;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.function.Consumer;

/**
 * 单向链表
 *
 * @author Lionel Johnson
 */
public class SinglyLinkedList implements Iterable<Integer> {
    private Node head = null;
    
    /**
     * 添加元素到链表头部
     *
     * @param value 元素值
     */
    public void addHead(Integer value) {
        head = new Node(value, head);
    }
    
    /**
     * 获取链表最后一个节点
     *
     * @return 最后一个节点
     */
    private Node findLast() {
        Node current = head;
        if (current == null) {
            return null;
        }
        while (current.next != null) {
            current = current.next;
        }
        return current;
    }
    
    
    /**
     * 添加元素到链表尾部
     *
     * @param value 元素值
     */
    public void addTail(Integer value) {
        Node last = findLast();
        
        if (last == null) {
            head = new Node(value, null);
            return;
        }
        
        last.next = new Node(value, null);
    }
    
    /**
     * 查找指定位置的节点
     *
     * @param index 位置
     * @return 节点
     * @throws IllegalArgumentException 如果位置不合法，抛出异常
     */
    private Node findNode(Integer index) throws IllegalArgumentException {
        int i = 0;
        for (Node current = head; current != null; current = current.next, i++) {
            if (i == index) {
                return current;
            }
        }
        throw new IllegalArgumentException(String.format("Index: %d 不合法", index));
    }
    
    /**
     * 获取指定位置的元素
     *
     * @param index 位置
     * @return 元素值
     * @throws IllegalArgumentException 如果位置不合法，抛出异常
     */
    public Integer get(Integer index) throws IllegalArgumentException {
        Node node = findNode(index);
        return node.value;
    }
    
    /**
     * 在指定位置插入元素
     *
     * @param index 位置
     * @param value 元素值
     * @throws IllegalArgumentException 如果位置不合法，抛出异常
     */
    public void insert(Integer index, Integer value) throws IllegalArgumentException {
        if (index == 0) {
            addHead(value);
            return;
        }
        
        Node node = findNode(index - 1);
        node.next = new Node(value, node.next);
    }
    
    /**
     * 删除指定位置的元素
     *
     * @param index 位置
     * @return 被删除的元素值
     * @throws IllegalArgumentException 如果位置不合法，抛出异常
     */
    public Integer remove(Integer index) throws IllegalArgumentException {
        Node currentNode = findNode(index);
        if (index == 0) {
            head = currentNode.next;
            return currentNode.value;
        }
        Node beforeNode = findNode(index - 1);
        beforeNode.next = currentNode.next;
        return currentNode.value;
    }
    
    /**
     * while循环遍历
     *
     * @param consumer consumer函数接口
     */
    public void loopWhile(Consumer<Integer> consumer) {
        Node current = head;
        while (current != null) {
            consumer.accept(current.value);
            current = current.next;
        }
    }
    
    /**
     * for循环遍历
     *
     * @param consumer consumer函数接口
     */
    public void loopFor(Consumer<Integer> consumer) {
        for (Node current = head; current != null; current = current.next) {
            consumer.accept(current.value);
        }
    }
    
    /**
     * 实现Iterable接口，支持for-each循环
     *
     * @return 迭代器
     */
    @Override
    public Iterator<Integer> iterator() {
        return new Iterator<Integer>() {
            private Node current = head;
            
            @Override
            public boolean hasNext() {
                return current != null;
            }
            
            @Override
            public Integer next() {
                Integer vaule = current.value;
                current = current.next;
                return vaule;
            }
        };
    }
    
    @Override
    public String toString() {
        ArrayList<Integer> list = new ArrayList<>();
        loopFor(list::add);
        return list.toString();
    }
    
    /**
     * 节点内部类
     */
    protected static class Node {
        Integer value;
        Node next;
        
        public Node(Integer value, Node next) {
            this.value = value;
            this.next = next;
        }
    }
    
}
