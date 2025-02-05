# Generate Parentheses

## Problem Description
Given `n` pairs of parentheses, write a function to generate all combinations of well-formed parentheses.

**LeetCode Link:** [Generate Parentheses](https://leetcode.com/problems/generate-parentheses/description/)

## Example

### Input
```java[]
n = 3;
```
### Output
```java[]
["((()))", "(()())", "(())()", "()(())", "()()()"]
```

## Solution
The approach uses **backtracking** to generate all valid combinations of parentheses. We maintain two counters:
- `l` (left parentheses remaining to be placed)
- `r` (right parentheses remaining to be placed)

A valid combination should always have `l <= r` to ensure proper closing of parentheses.

## Code Example
```java[]
import java.util.ArrayList;
import java.util.List;

public class GenerateParenthesis {
    public static void main(String[] args) {
        int n=3;
        System.out.println(generateParenthesis(n));
    }

    public static List<String> generateParenthesis(int n) {
        ArrayList<String> list = new ArrayList<>();
        helper(n, n, list, new StringBuilder());
        return list;
    }

    public static void helper(int l, int r, List<String> list, StringBuilder s) {
        if (l == 0 && r == 0) {
            list.add(s.toString());
            return;
        }
        if (l > 0) {
            helper(l - 1, r, list, new StringBuilder(s).append("("));
        }
        if (r > l) {
            helper(l, r - 1, list, new StringBuilder(s).append(")"));
        }
    }
}
```

## How It Works
1. Start with `n` left and `n` right parentheses available.
2. Recursively add `(` if `l > 0`.
3. Recursively add `)` if `r > l` (ensuring valid sequence).
4. Stop when `l == 0` and `r == 0`, adding the generated string to the list.

## Complexity Analysis
- **Time Complexity:** `O(4^n / sqrt(n))` (Catalan Number Complexity)
- **Space Complexity:** `O(n)`, considering recursive stack space.
