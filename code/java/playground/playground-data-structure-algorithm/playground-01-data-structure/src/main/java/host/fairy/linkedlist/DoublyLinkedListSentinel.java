/*****************************************************
 * @software: IntelliJ IDEA
 * @author: Lionel Johnson
 * @contact: https://fairy.host
 * @organization: https://github.com/FairylandFuture
 * @datetime: 2025-09-05 17:20:19 UTC+08:00
 ****************************************************/
package host.fairy.linkedlist;

import java.util.Iterator;

/**
 * 双向链表（哨兵节点）
 *
 * @author Lionel Johnson
 */
public class DoublyLinkedListSentinel implements Iterable<Integer> {
    // 头哨兵节点
    private final Node head;
    // 尾哨兵节点
    private final Node tail;
    
    public DoublyLinkedListSentinel() {
        this.head = new Node(-1, null, null);
        this.tail = new Node(-1, null, null);
        
        head.next = tail;
        tail.prev = head;
    }
    
    /**
     * 根据索引查找节点
     *
     * @param index 索引
     * @return 节点
     * @throws IndexOutOfBoundsException 索引越界异常
     */
    private Node findNode(Integer index) throws IndexOutOfBoundsException {
        Integer i = -1;  // 哨兵节点占位
        for (Node currentNode = head; currentNode != this.tail; currentNode = currentNode.next, i++) {
            if (index.equals(i)) {
                return currentNode;
            }
        }
        throw new IndexOutOfBoundsException("Index异常");
    }
    
    /**
     * 获取链表长度
     *
     * @return 长度
     */
    public Integer size() {
        Integer size = 0;
        for (Node currentNode = head.next; currentNode != this.tail; currentNode = currentNode.next) {
            size++;
        }
        return size;
    }
    
    /**
     * 添加元素到链表尾部
     *
     * @param value 值
     */
    public void add(Integer value) {
        Node pervNode = tail.prev;
        Node currentNode = new Node(value, tail, pervNode);
        pervNode.next = currentNode;
        tail.prev = currentNode;
    }
    
    /**
     * 在指定索引处插入元素
     *
     * @param index 索引
     * @param value 值
     * @throws IndexOutOfBoundsException 索引越界异常
     */
    public void insert(Integer index, Integer value) throws IndexOutOfBoundsException {
        Node pervNode = findNode(index - 1);
        Node nextNode = pervNode.next;
        Node currentNode = new Node(value, nextNode, pervNode);
        pervNode.next = currentNode;
        nextNode.prev = currentNode;
    }
    
    /**
     * 根据索引获取元素
     *
     * @param index 索引
     * @return 值
     * @throws IndexOutOfBoundsException 索引越界异常
     * @throws IllegalArgumentException  索引异常
     */
    public Integer get(Integer index) throws IndexOutOfBoundsException, IllegalArgumentException {
        Node currentNode = findNode(index);
        if (currentNode == head || currentNode == tail) {
            throw new IllegalArgumentException("Index异常");
        }
        return currentNode.value;
    }
    
    /**
     * 根据索引删除元素
     *
     * @param index 索引
     * @return 值
     * @throws IndexOutOfBoundsException 索引越界异常
     * @throws IllegalArgumentException  索引异常
     */
    public Integer remove(Integer index) throws IndexOutOfBoundsException, IllegalArgumentException {
        Node currentNode = findNode(index);
        Node pervNode = currentNode.prev;
        Node nextNode = currentNode.next;
        
        if (currentNode == head || currentNode == tail) {
            throw new IllegalArgumentException("Index异常");
        }
        
        pervNode.next = nextNode;
        nextNode.prev = pervNode;
        
        return currentNode.value;
    }
    
    /**
     * 迭代器
     *
     * @return 迭代器
     */
    @Override
    public Iterator<Integer> iterator() {
        return new Iterator<Integer>() {
            Node current = head.next;
            
            @Override
            public boolean hasNext() {
                return current != tail;
            }
            
            @Override
            public Integer next() {
                Integer value = current.value;
                current = current.next;
                return value;
            }
        };
    }
    
    /**
     * 节点
     */
    private static class Node {
        Integer value;
        Node next;
        Node prev;
        
        public Node(Integer value, Node next, Node prev) {
            this.value = value;
            this.next = next;
            this.prev = prev;
        }
    }
}
