/*****************************************************
 * @software: IntelliJ IDEA
 * @author: Lionel Johnson
 * @contact: https://fairy.host
 * @organization: https://github.com/FairylandFuture
 * @datetime: 2025-09-16 18:30:39 UTC+08:00
 ****************************************************/
package host.fairy.leetcode;

import java.util.Stack;

/**
 * LeetCode 232.
 * <p>请你仅使用两个栈实现先入先出队列。队列应当支持一般队列支持的所有操作（{@code push}、{@code pop}、{@code peek}、{@code empty}）：</p>
 * <p>实现 {@code MyQueue} 类：</p>
 * <p>1. {@code void push(int x)} 将元素 {@code x} 推到队列的末尾</p>
 * <p>2. {@code int pop()} 从队列的开头移除并返回元素</p>
 * <p>3. {@code int peek()} 返回队列开头的元素</p>
 * <p>4. {@code boolean empty()} 如果队列为空，返回 {@code true} ；否则，返回 {@code false}</p>
 *
 * @author Lionel Johnson
 * @version 1.0
 * @see <a href="https://leetcode.cn/problems/implement-queue-using-stacks/description/">Leetcode link</a>
 */
public class LeetCode232 {
    static class MyQueue {
        private final Stack<Integer> stackIn;
        private final Stack<Integer> stackOut;
        
        {
            stackIn = new Stack<>();
            stackOut = new Stack<>();
        }
        
        public MyQueue() {
        }
        
        public void push(int x) {
            this.stackIn.push(x);
        }
        
        public int pop() {
            if (this.stackOut.isEmpty()) {
                while (!this.stackIn.isEmpty()) {
                    this.stackOut.push(this.stackIn.pop());
                }
            }
            return this.stackOut.pop();
        }
        
        public int peek() {
            if (this.stackOut.isEmpty()) {
                while (!this.stackIn.isEmpty()) {
                    this.stackOut.push(this.stackIn.pop());
                }
            }
            return this.stackOut.peek();
        }
        
        public boolean empty() {
            return stackIn.isEmpty() && stackOut.isEmpty();
        }
    }
}

