/*****************************************************
 * @software: IntelliJ IDEA
 * @author: Lionel Johnson
 * @contact: https://fairy.host
 * @organization: https://github.com/FairylandFuture
 * @datetime: 2025-09-16 17:13:27 UTC+08:00
 ****************************************************/
package host.fairy.leetcode;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * Leetcode 150.
 * <p>给你一个字符串数组{@code tokens}，表示一个根据 逆波兰表示法 表示的算术表达式。</p>
 * <p>请你计算该表达式。返回一个表示表达式值的整数。</p>
 * <p>注意：</p>
 * <p>1. 有效的算符为（{@code "+", "-", "*", "/"}）。</p>
 * <p>2. 每个操作数（运算对象）都可以是一个整数或者另一个表达式。</p>
 * <p>3. 两个整数之间的除法总是{@code 向零截断}。</p>
 * <p>4. 表达式中不含除零运算。</p>
 * <p>5. 输入是一个根据逆波兰表示法表示的算术表达式。</p>
 * <p>6. 答案及所有中间计算结果可以用{@code 32位}整数表示。</p>
 *
 * @author Lionel Johnson
 * @version 1.0
 * @see <a href="https://leetcode.cn/problems/evaluate-reverse-polish-notation/">Leetcode Link</a>
 */
public class LeetCode150 {
    public static int evalRPN(String[] tokens) {
        LinkedList<Integer> stack = new LinkedList<>();
        
        for (String token : tokens) {
            if (token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/")) {
                int b = stack.pop();
                int a = stack.pop();
                switch (token) {
                    case "+":
                        stack.push(a + b);
                        break;
                    case "-":
                        stack.push(a - b);
                        break;
                    case "*":
                        stack.push(a * b);
                        break;
                    case "/":
                        stack.push(a / b);
                        break;
                    default:
                        throw new IllegalStateException("Unexpected value: " + token);
                }
            } else {
                stack.push(Integer.parseInt(token));
            }
        }
        
        if (stack.size() != 1) {
            throw new IllegalArgumentException("Invalid RPN expression");
        }
        return stack.poll();
    }
    
    public static void main(String[] args) {
        String[] tokens = Arrays.asList("10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+").toArray(new String[0]);
        System.out.println(evalRPN(tokens));
    }
}
