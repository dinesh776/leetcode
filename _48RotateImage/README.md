
# Rotate Image

This repository contains a solution to the LeetCode problem [Rotate Image](https://leetcode.com/problems/rotate-image/), implemented in Java.

## Problem Description

Given an `n x n` 2D matrix representing an image, rotate the image by 90 degrees (clockwise) in-place.

### Example

**Input:**
```java[]
matrix = [
  [5,1,9,11],
  [2,4,8,10],
  [13,3,6,7],
  [15,14,12,16]
]
```

**Output:**
```java[]
[
  [15,13,2,5],
  [14,3,4,1],
  [12,6,8,9],
  [16,7,10,11]
]
```

## Solution

The solution rotates the matrix by first transposing it (swapping rows and columns) and then reversing each row. This approach ensures an in-place rotation with an efficient time complexity of `O(n^2)` and `O(1)` space complexity.

## Code Example

```java[]
import java.util.Arrays;

public class RotateImage {
    public static void main(String[] args) {
        int[][] matrix = {{5,1,9,11},{2,4,8,10},{13,3,6,7},{15,14,12,16}};
        rotate(matrix);
        System.out.println(Arrays.deepToString(matrix));
    }

    static void rotate(int[][] matrix) {
        int n = matrix.length;
        // Transpose the matrix
        for(int i = 0; i < n - 1; i++) {
            for(int j = i + 1; j < n; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
        // Reverse each row
        for(int i = 0; i < n; i++) {
            int start = 0, end = n - 1;
            while(start < end) {
                int temp = matrix[i][start];
                matrix[i][start] = matrix[i][end];
                matrix[i][end] = temp;
                start++;
                end--;
            }
        }
    }
}
```

## How it Works

1. **Transpose the Matrix**: The matrix is transposed by swapping elements `matrix[i][j]` with `matrix[j][i]` for `i < j`, transforming rows into columns.
2. **Reverse Each Row**: Each row is reversed to achieve a 90-degree clockwise rotation.

## How to Use

To run the solution, compile and execute the `RotateImage` class in your Java environment:

```bash[]
javac RotateImage.java
java RotateImage
```

This will output the rotated matrix.

## Complexity Analysis

- **Time Complexity:** `O(n^2)`, where `n` is the number of rows (or columns) in the matrix.
- **Space Complexity:** `O(1)`, as the rotation is done in-place.
