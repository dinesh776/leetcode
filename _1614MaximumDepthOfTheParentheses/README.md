
# Maximum Nesting Depth of the Parentheses

This project provides a solution to the LeetCode problem **1614. Maximum Nesting Depth of the Parentheses**.

## Problem Description

A string is a valid parentheses string (denoted VPS) if it meets one of the following:
- It is an empty string `""`, or a single character not equal to `"("` or `")"`.
- It can be written as `AB` (A concatenated with B), where A and B are VPS.
- It can be written as `(A)`, where A is a VPS.

You are given a VPS represented as a string `s`, return the nesting depth of `s`.

The nesting depth of `s` is the maximum depth of well-formed parentheses in `s`.

### Example

Input:
```
s = "()"
```

Output:
```
1
```

## Solution

### Approach: Iterative Depth Calculation

This approach uses a counter to keep track of the current depth and updates the maximum depth whenever an opening parenthesis is encountered.

### Code:
```java[]
public class MaxNestedDepthOfTheParentheses {
    public static void main(String[] args) {
        String s = "()";
        System.out.println(maxDepth(s));
    }

    static int maxDepth(String s) {
        int ct = 0, max = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                ct++;
                max = Math.max(max, ct);
            } else if (c == ')') {
                ct--;
            }
        }
        return max;
    }
}
```

## How It Works

1. **Initialization**: Set counters `ct` for current depth and `max` for maximum depth to 0.
2. **Iterate through String**:
    - Increment `ct` when encountering `'('` and update `max` if `ct` exceeds the previous maximum.
    - Decrement `ct` when encountering `')'`.
3. **Return Maximum Depth**: After traversing the string, return the `max` value.

## Complexity Analysis

- **Time Complexity**: `O(n)`
    - Iterates through the string once.
- **Space Complexity**: `O(1)`
    - Uses constant extra space for counters.

## Usage

1. Clone or download the repository.
2. Compile and run the Java file using your preferred IDE or command line.

## LeetCode Problem Link

[1614. Maximum Nesting Depth of the Parentheses](https://leetcode.com/problems/maximum-nesting-depth-of-the-parentheses/description/)
