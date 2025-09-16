/*****************************************************
 * @software: IntelliJ IDEA
 * @author: Lionel Johnson
 * @contact: https://fairy.host
 * @organization: https://github.com/FairylandFuture
 * @datetime: 2025-09-16 19:15:46 UTC+08:00
 ****************************************************/
package host.fairy.leetcode;

import java.util.concurrent.LinkedTransferQueue;

/**
 * LeetCode 225.
 * <p>请你仅使用两个队列实现一个后入先出（LIFO）的栈，并支持普通栈的全部四种操作（{@code push}、{@code top}、{@code pop} 和 {@code empty}）。</p>
 * <p>实现 {@code MyStack} 类：</p>
 * <p>1. {@code void push(int x)} 将元素 x 压入栈顶。</p>
 * <p>2. {@code int pop()} 移除并返回栈顶元素。</p>
 * <p>3. {@code int top()} 返回栈顶元素。</p>
 * <p>4. {@code boolean empty()} 如果栈是空的，返回 {@code true} ；否则，返回 {@code false} 。</p>
 *
 * @author Lionel Johnson
 * @version 1.0
 * @see <a href="https://leetcode.cn/problems/implement-stack-using-queues/">Leetcode link</a>
 */
public class LeetCode225 {
    static class MyStack {
        private final LinkedTransferQueue<Integer> queue;
        
        public MyStack() {
            this.queue = new LinkedTransferQueue<>();
        }
        
        public void push(int x) {
            this.queue.offer(x);
            int size = this.queue.size();
            while (size-- > 1) {
                this.queue.offer(this.queue.poll());
            }
        }
        
        public int pop() {
            if (!this.queue.isEmpty()) {
                return this.queue.poll();
            }
            throw new IllegalStateException("Stack is empty");
        }
        
        public int top() {
            if (!this.queue.isEmpty()) {
                return this.queue.peek();
            }
            throw new IllegalStateException("Stack is empty");
        }
        
        public boolean empty() {
            return this.queue.isEmpty();
        }
    }
}
