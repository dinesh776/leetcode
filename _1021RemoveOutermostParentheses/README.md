# Remove Outermost Parentheses

## Problem Description
Given a valid parentheses string `s`, remove the outermost parentheses of every primitive string in the primitive decomposition of `s` and return the resulting string.

A **primitive** string is a nonempty valid parentheses string that cannot be decomposed further.

### Example
#### Input:
```java[]
String s = "(()())(())";
```
#### Output:
```java[]
"()()()"
```

## Solution Approach
The solution iterates through the string while maintaining counts of open and close parentheses. The outermost parentheses are tracked and removed while keeping the inner structure intact.

### Steps:
1. Initialize counters `opens` and `closes` to keep track of the parentheses count.
2. Iterate through the string using a `StringBuilder`.
3. When encountering an opening parenthesis:
    - If it's the first in a primitive sequence, note the starting index.
    - Increment the open counter.
4. When encountering a closing parenthesis:
    - Increment the close counter.
    - If open and close counters match, remove the outermost parentheses.
5. Return the modified string.

## Code Implementation
```java[]
public class RemoveOutermostParentheses {
    public static void main(String[] args) {
        String s = "(()())(())";
        System.out.println(removeOuterParentheses(s));
    }
    static String removeOuterParentheses(String s) {
        int n = s.length(), opens = 0, closes = 0, start = 0;
        StringBuilder sb = new StringBuilder(s);
        if (n == 0) {
            return s;
        }
        for (int i = 0; i < sb.length(); i++) {
            if (sb.charAt(i) == '(') {
                if (opens == 0) {
                    start = i;
                }
                opens++;
            } else {
                closes++;
            }
            if (opens == closes) {
                sb.deleteCharAt(i);
                sb.deleteCharAt(start);
                i = i - 2;
                opens = 0;
                closes = 0;
            }
        }
        return sb.toString();
    }
}
```

## Complexity Analysis
- **Time Complexity:** `O(N)`, where `N` is the length of the string, as we traverse the string once.
- **Space Complexity:** `O(N)`, since we use a `StringBuilder` to modify the input string.

