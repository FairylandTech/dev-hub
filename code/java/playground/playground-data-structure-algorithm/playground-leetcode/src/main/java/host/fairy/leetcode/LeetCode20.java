/*****************************************************
 * @software: IntelliJ IDEA
 * @author: Lionel Johnson
 * @contact: https://fairy.host
 * @organization: https://github.com/FairylandFuture
 * @datetime: 2025-09-16 15:42:34 UTC+08:00
 ****************************************************/
package host.fairy.leetcode;

import java.util.HashMap;
import java.util.LinkedList;

/**
 * Leetcode 20.
 * <p>给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。</p>
 * <p>有效字符串需满足：</p>
 * <p>1. 左括号必须用相同类型的右括号闭合。</p>
 * <p>2. 左括号必须以正确的顺序闭合。</p>
 * <p>3. 每个右括号都有一个对应的相同类型的左括号。</p>
 *
 * @author Lionel Johnson
 * @version 1.0
 * @see <a href="https://leetcode.cn/problems/valid-parentheses/">Leetcode link</a>
 */
public class LeetCode20 {
    public static boolean isValid(String s) {
        HashMap<String, String> parenthesHashMap = new HashMap<String, String>() {{
            put(")", "(");
            put("]", "[");
            put("}", "{");
        }};
        LinkedList<Character> stack = new LinkedList<>();
        
        for (char c : s.toCharArray()) {
            if (parenthesHashMap.containsValue(String.valueOf(c))) {
                stack.push(c);
            } else if (parenthesHashMap.containsKey(String.valueOf(c))) {
                if (stack.isEmpty() || !parenthesHashMap.get(String.valueOf(c)).equals(String.valueOf(stack.poll()))) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
    
    public static void main(String[] args) {
        String s = "[";
        System.out.println(isValid(s));
    }
}
