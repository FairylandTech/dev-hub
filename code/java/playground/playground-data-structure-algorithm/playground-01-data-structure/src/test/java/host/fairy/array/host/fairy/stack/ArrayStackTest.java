/*****************************************************
 * @software: IntelliJ IDEA
 * @author: Lionel Johnson
 * @contact: https://fairy.host
 * @organization: https://github.com/FairylandFuture
 * @datetime: 2025-09-16 00:33:18 UTC+08:00
 ****************************************************/
package host.fairy.array.host.fairy.stack;

import host.fairy.stack.ArrayStack;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * @author Lionel Johnson
 * @version 1.0
 * @see ArrayStack
 */
public class ArrayStackTest {
    @Test
    @DisplayName(" push ")
    void push() {
        ArrayStack<Integer> stack = new ArrayStack<>(3);
        stack.push(1);
        stack.push(2);
        stack.push(3);
        
        System.out.println("stack.push(4) = " + stack.push(4));
        stack.forEach(System.out::println);
    }
}
