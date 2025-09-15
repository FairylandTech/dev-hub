/*****************************************************
 * @software: IntelliJ IDEA
 * @author: Lionel Johnson
 * @contact: https://fairy.host
 * @organization: https://github.com/FairylandFuture
 * @datetime: 2025-09-15 23:04:12 UTC+08:00
 ****************************************************/
package host.fairy.array.host.fairy.stack;

import host.fairy.stack.LinkedListStack;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * @author Lionel Johnson
 * @version 1.0
 * @see LinkedListStack
 */
public class LinkedListStackTest {
    @Test
    @DisplayName(" push ")
    void push() {
        LinkedListStack<Integer> stack = new LinkedListStack<>(3);
        
        stack.push(1);
        stack.push(2);
        stack.push(3);
        
        System.out.println(stack.push(4));
        
        stack.forEach(System.out::println);
    }
}
