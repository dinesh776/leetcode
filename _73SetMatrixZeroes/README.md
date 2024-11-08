
# Set Matrix Zeroes

This repository contains a solution to the LeetCode problem [Set Matrix Zeroes](https://leetcode.com/problems/set-matrix-zeroes/), implemented in Java.

## Problem Description

The **Set Matrix Zeroes** problem requires modifying an `m x n` matrix such that any row or column containing a `0` is filled entirely with `0`s. This modification should be done **in-place**, without using additional space.

- **Example:** Given a matrix `[[0], [1]]`, the output would be `[[0], [0]]`.

### Example

**Input:**
```java[]
int[][] matrix = {{0}, {1}};
```
**Output:**
```java[]
[[0], [0]]
```

**Explanation:**

In the input matrix, the first row contains a `0`, so the entire column and row are set to zeroes.

## Solution

This solution utilizes an **optimal approach** with a time complexity of `O(2*(m * n))` and a space complexity of `O(1)`. The algorithm uses the first row and column as markers, avoiding the need for extra space.

## Code Example

```java[]
import java.util.Arrays;

public class SetMatrixZeroes {
    public static void main(String[] args) {
        int[][] matrix = {{0}, {1}};
        setZeroes(matrix);
        System.out.println(Arrays.deepToString(matrix));
    }

    static void setZeroes(int[][] matrix) {
        int col0 = 1;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    if (j != 0) {
                        matrix[0][j] = 0;
                    } else {
                        col0 = 0;
                    }
                }
            }
        }
        for (int i = 1; i < matrix.length; i++) {
            for (int j = 1; j < matrix[i].length; j++) {
                if (matrix[i][j] != 0) {
                    if (matrix[0][j] == 0 || matrix[i][0] == 0) {
                        matrix[i][j] = 0;
                    }
                }
            }
        }
        if (matrix[0][0] == 0) {
            for (int j = 0; j < matrix[0].length; j++) {
                matrix[0][j] = 0;
            }
        }
        if (col0 == 0) {
            for (int i = 0; i < matrix.length; i++) {
                matrix[i][0] = 0;
            }
        }
    }
}
```

## How it Works

1. **Marking Rows and Columns:** For each zero found in the matrix, the first element of its row and column is set to zero as a marker.
2. **Zeroing Cells:** Using the markers, the algorithm sets all cells in affected rows and columns to zero.
3. **Final Adjustment:** The first row and column are zeroed based on initial flags to ensure all necessary cells are updated.

## How to Use

To run the solution, compile and execute the `SetMatrixZeroes` class in your Java environment:

```bash[]
javac SetMatrixZeroes.java
java SetMatrixZeroes
```
This will output the modified matrix with zeroed rows and columns where necessary.

## Complexity Analysis

- **Time Complexity:** O(m * n), where `m` is the number of rows and `n` is the number of columns, as the matrix is iterated twice.
- **Space Complexity:** O(1), as the algorithm modifies the matrix in place without additional data structures.
