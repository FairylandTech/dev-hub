/*****************************************************
 * @software: IntelliJ IDEA
 * @author: Lionel Johnson
 * @contact: https://fairy.host
 * @organization: https://github.com/FairylandFuture
 * @datetime: 2025-09-05 19:26:25 UTC+08:00
 ****************************************************/
package host.fairy.linkedlist;

import java.util.Iterator;

/**
 * @author Lionel Johnson
 */
public class CircularLinkedListSentinel implements Iterable<Integer> {
    // 哨兵节点
    private final Node sentinel;
    
    public CircularLinkedListSentinel() {
        this.sentinel = new Node(-1, null, null);
        this.sentinel.next = this.sentinel;
        this.sentinel.prev = this.sentinel;
    }
    
    /**
     * 根据索引查找节点
     *
     * @param index 索引
     * @return 节点
     * @throws IndexOutOfBoundsException 索引越界异常
     */
    private Node findNode(Integer index) throws IndexOutOfBoundsException {
        if (index < 0) throw new IndexOutOfBoundsException("Index: " + index);
        Integer currentIndex = 0;
        for (Node currentNode = this.sentinel.next; currentNode != this.sentinel; currentNode = currentNode.next, currentIndex++) {
            if (index.equals(currentIndex)) {
                return currentNode;
            }
        }
        throw new IndexOutOfBoundsException("Index: " + index);
    }
    
    /**
     * 添加节点
     *
     * @param value 值
     */
    public void add(Integer value) {
        Node currentNode = new Node(value, this.sentinel, this.sentinel.prev);
        this.sentinel.prev.next = currentNode;
        this.sentinel.prev = currentNode;
    }
    
    /**
     * 在指定索引处添加节点
     *
     * @param index 索引
     * @param value 值
     * @throws IndexOutOfBoundsException 索引越界异常
     */
    public void add(Integer index, Integer value) throws IndexOutOfBoundsException {
        Node currentNode = findNode(index);
        Node node = new Node(value, currentNode, currentNode.prev);
        currentNode.prev.next = node;
        currentNode.prev = node;
    }
    
    /**
     * 获取值
     *
     * @param index 索引
     * @return 值
     * @throws IndexOutOfBoundsException 索引越界异常
     */
    public Integer get(Integer index) throws IndexOutOfBoundsException {
        return findNode(index).value;
    }
    
    /**
     * 删除节点
     *
     * @param index 索引
     * @return 值
     * @throws IndexOutOfBoundsException 索引越界异常
     */
    public Integer remove(Integer index) throws IndexOutOfBoundsException {
        Node currentNode = findNode(index);
        currentNode.prev.next = currentNode.next;
        currentNode.next.prev = currentNode.prev;
        return currentNode.value;
    }
    
    @Override
    public Iterator<Integer> iterator() {
        return new Iterator<Integer>() {
            Node currentNode = sentinel.next;
            
            @Override
            public boolean hasNext() {
                return currentNode != sentinel;
            }
            
            @Override
            public Integer next() {
                Integer value = currentNode.value;
                currentNode = currentNode.next;
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
