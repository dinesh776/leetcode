package Github._20ValidParentheses;
//20. Valid Parentheses
//https://leetcode.com/problems/valid-parentheses/description/
import java.util.Stack;

public class ValidParentheses {
    public static void main(String[] args) {
        String s="(]";
        System.out.println(isValid(s));
    }
    static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c == '(') {
                stack.push(')');
            } else if (c == '[') {
                stack.push(']');
            } else if (c == '{') {
                stack.push('}');
            } else {
                // If the stack is empty or the top of the stack doesn't match
                if (stack.isEmpty() || stack.pop() != c) {
                    return false;
                }
            }
        }
        // Ensure no unmatched open parentheses remain
        return stack.isEmpty();
    }
}
