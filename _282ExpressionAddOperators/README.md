# Expression Add Operators

## Problem Description
LeetCode Problem 282: [Expression Add Operators](https://leetcode.com/problems/expression-add-operators/description/)

Given a string `num` that contains only digits and an integer `target`, return all possible expressions that can be built by inserting the operators `+`, `-`, and `*` between the digits such that the result evaluates to `target`.

## Example
```java[]
Input: num = "123", target = 6
Output: ["1+2+3", "1*2*3"]

Input: num = "232", target = 8
Output: ["2*3+2", "2+3*2"]
```

## Solution Approach
The solution uses **Backtracking** to explore all possible expressions:
1. **Base Case:** When we reach the end of the string, check if the expression evaluates to `target`.
2. **Recursive Exploration:** Try adding `+`, `-`, and `*` between digits while keeping track of the evaluated value and the last operand for correct multiplication calculations.
3. **Pruning:** Skip numbers with leading zeros.

## Implementation
```java[]
import java.util.ArrayList;
import java.util.List;

public class ExpressionAddOperators {
    public static void main(String[] args) {
        String num = "123";
        int target = 6;
        System.out.println(addOperators(num, target));
    }

    public static List<String> addOperators(String num, int target) {
        List<String> result = new ArrayList<>();
        if (num == null || num.isEmpty()) {
            return result;
        }
        backtrack(result, num, target, 0, 0, 0, new StringBuilder());
        return result;
    }

    private static void backtrack(List<String> result, String num, int target, int index, long eval, long prev, StringBuilder path) {
        if (index == num.length()) {
            if (eval == target) {
                result.add(path.toString());
            }
            return;
        }

        for (int i = index; i < num.length(); i++) {
            if (i != index && num.charAt(index) == '0') {
                break; // Avoid leading zeros
            }
            long curr = Long.parseLong(num.substring(index, i + 1));
            int length = path.length();

            if (index == 0) {
                path.append(curr);
                backtrack(result, num, target, i + 1, curr, curr, path);
                path.setLength(length);
            } else {
                path.append('+').append(curr);
                backtrack(result, num, target, i + 1, eval + curr, curr, path);
                path.setLength(length);

                path.append('-').append(curr);
                backtrack(result, num, target, i + 1, eval - curr, -curr, path);
                path.setLength(length);

                path.append('*').append(curr);
                backtrack(result, num, target, i + 1, eval - prev + prev * curr, prev * curr, path);
                path.setLength(length);
            }
        }
    }
}
```

## Complexity Analysis
- **Time Complexity:** `O(4^N)`, where `N` is the length of `num`, as each digit can be assigned an operator.
- **Space Complexity:** `O(N)`, due to recursion depth.

## Usage
Run the program in a Java environment to get all possible expressions that evaluate to the target.
