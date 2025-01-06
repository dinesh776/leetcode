# Minimum Number of Operations to Move All Balls to Each Box

## Problem Description
[Minimum Number of Operations to Move All Balls to Each Box](https://leetcode.com/problems/minimum-number-of-operations-to-move-all-balls-to-each-box/description/?envType=daily-question&envId=2025-01-06)

You are given a binary string `boxes` where each character represents a box. `'1'` means the box contains a ball, and `'0'` means it is empty. The task is to determine the minimum number of operations required to move all the balls to each box.

An operation is defined as moving one ball from one box to an adjacent box.

## Example
### Input
```java[]
String boxes = "001011";
```
### Output
```java[]
[11, 8, 5, 4, 3, 4]
```

## Solution
This problem can be solved efficiently using two passes:
1. A **left-to-right pass** to calculate operations for balls moving from left to right.
2. A **right-to-left pass** to calculate operations for balls moving from right to left.

This avoids the need for a brute-force approach, reducing the time complexity from `O(n^2)` to `O(n)`.

### Code Example
```java[]
import java.util.Arrays;

public class MinimumNumberOfOperationsToMoveAllBallsToEachBox {
    public static void main(String[] args) {
        String boxes = "001011";
        System.out.println(Arrays.toString(minOperations(boxes)));
    }

    static int[] minOperations(String boxes) {
        int n = boxes.length();
        int[] result = new int[n];

        // Left-to-right pass
        int balls = 0; // Count of balls encountered
        int operations = 0; // Cumulative operations
        for (int i = 0; i < n; i++) {
            result[i] = operations;
            balls += boxes.charAt(i) - '0'; // Add the current box's balls
            operations += balls; // Update operations for the next box
        }

        // Right-to-left pass
        balls = 0;
        operations = 0;
        for (int i = n - 1; i >= 0; i--) {
            result[i] += operations;
            balls += boxes.charAt(i) - '0'; // Add the current box's balls
            operations += balls; // Update operations for the previous box
        }

        return result;
    }
}
```

## How It Works
1. **Left-to-Right Pass**:
    - Traverse the string from left to right, keeping track of the cumulative count of balls and their operations.
2. **Right-to-Left Pass**:
    - Traverse the string from right to left, similarly accumulating operations and updating the result array.

### Complexity Analysis
- **Time Complexity**: `O(n)`, where `n` is the length of the input string `boxes`.
- **Space Complexity**: `O(n)` for the result array.

## Usage
The function `minOperations(String boxes)` computes the result array where each element represents the minimum operations required to move all balls to the respective box.


