/*****************************************************
 * @software: IntelliJ IDEA
 * @author: Lionel Johnson
 * @contact: https://fairy.host
 * @organization: https://github.com/FairylandFuture
 * @datetime: 2025-09-14 14:26:34 UTC+08:00
 ****************************************************/
package host.fairy.queue;

import java.util.Iterator;

/**
 * Queue using lined list.
 *
 * @param <E> Queue elemant type.
 * @author Lionel Johnson
 * @version 1.0
 * @see Queue
 * @see Iterable
 */
public class LinkedListQueue<E> implements Queue<E>, Iterable<E> {
    /**
     * Queue head node (sentinel)
     */
    private final Node<E> head;
    
    /**
     * Queue tail node
     */
    private Node<E> tail;
    
    /**
     * Current quque size.
     */
    private Integer index = 0;
    
    /**
     * Max queue size.
     */
    private Integer size = 20;
    
    {
        Node<E> sentinel = new Node<>(null, null); // sentinel node
        sentinel.next = sentinel;
        this.head = sentinel;
        this.tail = sentinel;
    }
    
    public LinkedListQueue() {
    }
    
    public LinkedListQueue(Integer size) {
        this.size = size;
    }
    
    /**
     * Insert into end of queue.
     *
     * @param value vaule.
     * @return success or not.
     * @throws RuntimeException if the queue is full.
     */
    @Override
    public Boolean offer(E value) throws RuntimeException {
        if (this.isFull()) {
            throw new RuntimeException("Queue is full.");
        }
        Node<E> currentNode = new Node<>(value, this.head);
        this.tail.next = currentNode;
        this.tail = currentNode;
        this.index++;
        return true;
    }
    
    /**
     * Get value from queue head, but not remove.
     *
     * @return value or null if the queue is empty.
     */
    @Override
    public E peek() {
        if (this.isEmpty()) {
            return null;
        }
        return this.head.next.value;
    }
    
    /**
     * Get value from queue head and remove node.
     *
     * @return value or null if the queue is empty.
     */
    @Override
    public E pool() {
        if (this.isEmpty()) {
            return null;
        }
        
        Node<E> currentNode = this.head.next;
        
        if (currentNode.next == this.head) {
            this.tail = this.head; // The queue if full, reset tail node point to head node.
        } else {
            this.head.next = currentNode.next;  // Move head next node point to first next node. head node -> Second node, remove first node.
        }
        
        this.index--;
        
        return currentNode.value;
    }
    
    /**
     * Check the queue is empty.
     *
     * @return empty or not.
     */
    @Override
    public Boolean isEmpty() {
        return this.head == this.tail;
    }
    
    /**
     * Check the queue is full.
     *
     * @return full or not.
     */
    public Boolean isFull() {
        return this.size.equals(this.index);
    }
    
    /**
     * An iterator, used to for-each loop.
     *
     * @return iterator.
     */
    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            Node<E> current = head.next;
            
            @Override
            public boolean hasNext() {
                return current != head;
            }
            
            @Override
            public E next() {
                E value = current.value;
                current = current.next;
                return value;
            }
        };
    }
    
    /**
     * Linked list node.
     *
     * @param <E> value type.
     */
    private static class Node<E> {
        E value;
        Node<E> next;
        
        public Node(E value, Node<E> next) {
            this.value = value;
            this.next = next;
        }
    }
}
