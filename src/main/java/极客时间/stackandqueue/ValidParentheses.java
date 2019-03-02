package 极客时间.stackandqueue;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * leetcode-20
 * 有效的括号
 */
public class ValidParentheses {

    private static final Map<Character, Character> dict = new HashMap<>();

    static {
        dict.put(')', '(');
        dict.put(']', '[');
        dict.put('}', '{');
    }

    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {

            if (dict.containsKey(c)) {
                if (stack.isEmpty() || stack.pop() != dict.get(c)) {
                    return false;
                }
            } else {
                stack.push(c);
            }


        }
        return stack.isEmpty();

    }


    public boolean isValid1(String s) {
        Stack<Character> stack = new Stack<>();

        for (char c : s.toCharArray()) {
            if (c == '(' || c == '[' || c == '{') {
                stack.push(c);
            } else {
                if (stack.isEmpty()) {
                    return false;
                }
                if (c == ')' && stack.pop() != '(') {
                    return false;
                }
                if (c == ']' && stack.pop() != '[') {
                    return false;
                }
                if (c == '}' && stack.pop() != '{') {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}
