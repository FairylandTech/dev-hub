/*****************************************************
 * @software: IntelliJ IDEA
 * @author: Lionel Johnson
 * @contact: https://fairy.host
 * @organization: https://github.com/FairylandFuture
 * @datetime: 2025-09-04 13:34:45 UTC+08:00
 ****************************************************/
package host.fairy.linkedlist;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * 单链表（带哨兵节点）
 *
 * @author Lionel Johnson
 */
public class SinglyLinkedListSentinel extends SinglyLinkedList {
    private final Node hand = new Node(-1, null);  // 头指针：哨兵节点
    
    /**
     * 获取链表最后一个节点
     *
     * @return 最后一个节点
     */
    public Node findLast() {
        Node currentNode = hand;
        while (currentNode.next != null) {
            currentNode = currentNode.next;
        }
        return currentNode;
    }
    
    /**
     * 添加元素到链表尾部
     *
     * @param value 元素值
     */
    @Override
    public void addTail(Integer value) {
        Node last = findLast();
        last.next = new Node(value, null);
    }
    
    /**
     * 根据索引查找节点
     *
     * @param index 索引
     * @return 节点
     * @throws IndexOutOfBoundsException 索引越界异常
     */
    public Node findNode(Integer index) throws IndexOutOfBoundsException {
        Integer currentIndex = -1;
        for (Node currentNode = hand; currentNode != null; currentNode = currentNode.next, currentIndex++) {
            if (currentIndex.equals(index)) {
                return currentNode;
            }
        }
        throw new IndexOutOfBoundsException();
    }
    
    /**
     * 根据索引获取元素
     *
     * @param index 位置
     * @return 元素
     * @throws IndexOutOfBoundsException 索引越界异常
     */
    public Integer get(Integer index) throws IndexOutOfBoundsException {
        return findNode(index).value;
    }
    
    /**
     * 在指定位置插入元素
     *
     * @param index 位置
     * @param value 元素值
     * @throws IndexOutOfBoundsException 索引越界异常
     */
    public void insert(Integer index, Integer value) throws IndexOutOfBoundsException {
        Node prevNode = findNode(index - 1);
        prevNode.next = new Node(value, prevNode.next);
    }
    
    /**
     * 删除指定位置的元素
     *
     * @param index 位置
     * @return 被删除的元素
     * @throws IndexOutOfBoundsException 索引越界异常
     */
    public Integer remove(Integer index) throws IndexOutOfBoundsException {
        Node currentNode = findNode(index);
        Node prevNode = findNode(index - 1);
        prevNode.next = currentNode.next;
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
            Node currentNode = hand.next;  // 过滤掉哨兵节点
            
            @Override
            public boolean hasNext() {
                return currentNode != null;
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
     * 重写toString方法，返回链表字符串表示
     *
     * @return 链表字符串
     */
    @Override
    public String toString() {
        ArrayList<Integer> list = new ArrayList<>();
        this.forEach(list::add);
        return list.toString();
    }
}
