# Valid Parentheses

## Problem Description
[Valid Parentheses](https://leetcode.com/problems/valid-parentheses/description/)

Given a string `s` containing just the characters `'('`, `')'`, `'{'`, `'}'`, `'['`, and `']'`, determine if the input string is valid.

An input string is valid if:
1. Open brackets must be closed by the same type of brackets.
2. Open brackets must be closed in the correct order.

## Example
ß
### Input:
```plaintext[]
s = "(]"
```

### Output:
```plaintext[]
false
```

### Explanation:
- The string "(]" is invalid because the opening parenthesis `'('` is not closed by a matching closing parenthesis `')'`.

## Solution
The solution uses a stack to keep track of the expected closing parentheses. The algorithm processes the string character by character:
1. Push the corresponding closing parenthesis onto the stack whenever an opening parenthesis is encountered.
2. If a closing parenthesis is encountered:
    - Check if it matches the top element of the stack.
    - If it doesn't match or the stack is empty, return `false`.
3. At the end, ensure that the stack is empty (i.e., all parentheses have been matched).

## Code Example
```java[]
import java.util.Stack;

public class ValidParentheses {
    public static void main(String[] args) {
        String s = "(]";
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
```

## How It Works
1. Traverse each character in the input string `s`.
2. For every opening parenthesis (`'('`, `'{'`, `'['`), push the expected closing parenthesis (`')'`, `'}'`, `']'`) onto the stack.
3. For every closing parenthesis (`')'`, `'}'`, `']'`):
    - Check if the stack is not empty and the top of the stack matches the closing parenthesis.
    - If not, return `false` immediately.
4. After processing all characters, ensure the stack is empty. If it's not empty, return `false`.

## Complexity Analysis
- **Time Complexity**: `O(n)` where `n` is the length of the input string. Each character is pushed and popped from the stack at most once.
- **Space Complexity**: `O(n)` in the worst case, where all characters are opening parentheses.

## Usage
This function is useful for validating parentheses in mathematical expressions, programming languages, and other contexts where matching delimiters are required.

## Edge Cases
- An empty string should return `true`.
- Strings with unmatched or improperly nested parentheses should return `false`. Examples include:
    - `"("`
    - `"[{]"`
    - `"(())[]{}"` (valid)
