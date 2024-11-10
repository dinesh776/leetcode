
# Spiral Matrix

This repository contains a solution to the LeetCode problem [Spiral Matrix](https://leetcode.com/problems/spiral-matrix/), implemented in Java.

## Problem Description

Given an `m x n` matrix, return all elements of the matrix in spiral order.

### Example

**Input:**
```java[]
int[][] matrix = {{1,2,3,4}, {5,6,7,8}, {9,10,11,12}};
```

**Output:**
```java[]
[1, 2, 3, 4, 8, 12, 11, 10, 9, 5, 6, 7]
```

## Solution

The solution iterates over the matrix in a spiral pattern, progressively narrowing the traversal boundaries (top, bottom, left, and right) as it collects elements in sequence.

## Code Example

```java[]
import java.util.*;

public class SpiralMatrix {
    public static void main(String[] args) {
        int[][] matrix = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}};
        System.out.println(spiralOrder(matrix));
    }

    static List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> list = new ArrayList<>();
        int n = matrix.length, m = matrix[0].length;
        int left = 0, right = m - 1;
        int top = 0, bottom = n - 1;
        
        while (top <= bottom && left <= right) {
            for (int i = left; i <= right; i++) list.add(matrix[top][i]);
            top++;
            
            for (int i = top; i <= bottom; i++) list.add(matrix[i][right]);
            right--;
            
            if (top <= bottom) {
                for (int i = right; i >= left; i--) list.add(matrix[bottom][i]);
                bottom--;
            }
            
            if (left <= right) {
                for (int i = bottom; i >= top; i--) list.add(matrix[i][left]);
                left++;
            }
        }
        return list;
    }
}
```

## How it Works

1. **Traverse Left to Right**: Adds elements from the left to the right boundary at the `top` row, then moves `top` down.
2. **Traverse Top to Bottom**: Adds elements from the top to the bottom boundary at the `right` column, then moves `right` left.
3. **Traverse Right to Left**: If `top` is still above `bottom`, it adds elements from the right to the left boundary at the `bottom` row, then moves `bottom` up.
4. **Traverse Bottom to Top**: If `left` is still before `right`, it adds elements from the bottom to the top boundary at the `left` column, then moves `left` right.

## How to Use

To run the solution, compile and execute the `SpiralMatrix` class in your Java environment:

```bash[]
javac SpiralMatrix.java
java SpiralMatrix
```

This will output the matrix elements in a spiral order.

## Complexity Analysis

- **Time Complexity:** O(m * n), where `m` is the number of rows and `n` is the number of columns. Every element is processed once.
- **Space Complexity:** O(1) for the in-place approach with additional storage only for the result list.
