
# Search a 2D Matrix

This repository contains a solution to the LeetCode problem [Search a 2D Matrix](https://leetcode.com/problems/search-a-2d-matrix/description/), implemented in Java.

## Problem Description

The **Search a 2D Matrix** problem requires determining whether a given target value exists in a 2D matrix. Each row of the matrix is sorted in ascending order, and the first integer of each row is greater than the last integer of the previous row.

### Example

**Input:**
```java[]
int[][] matrix = {{1}};
int target = 2;
```

**Output:**
```java[]
false
```

**Explanation:**  
The target value `2` does not exist in the given matrix.

## Solution

This solution employs a binary search algorithm to search for the target in the matrix efficiently. By treating the matrix as a flattened sorted array, the algorithm achieves logarithmic time complexity.

### Optimal Approach

- **Time Complexity:** O(log(m * n)), where `m` is the number of rows and `n` is the number of columns.
- **Space Complexity:** O(1), as the solution does not use additional space.

## Code Example

```java[]
public class SearchA2dMatrix {
    public static void main(String[] args) {
        int[][] matrix = {{1}};
        int target = 2;
        System.out.println(searchMatrix(matrix,target));
    }
    static boolean searchMatrix(int[][] matrix, int target) {
        int n = matrix.length, m = matrix[0].length;
        int start = 0, end = (m * n) - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            int row = mid / m, col = mid % m;
            if (matrix[row][col] == target) {
                return true;
            } else if (target < matrix[row][col]) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return false;
    }
}
```

## How it Works

1. **Flattening the Matrix:** Treat the 2D matrix as a 1D array for the purpose of binary search.
2. **Binary Search:** Calculate the mid-point, convert it back to 2D indices, and compare the value with the target.
3. **Update Pointers:** Adjust the `start` and `end` pointers based on the comparison.

## How to Use

To execute the solution, compile and run the `SearchA2dMatrix` class in your Java environment:

```bash[]
javac SearchA2dMatrix.java
java SearchA2dMatrix
```

This will output `true` or `false` depending on whether the target exists in the matrix.

## Complexity Analysis

- **Time Complexity:** O(log(m * n)), as the binary search divides the search space in half at each step.
- **Space Complexity:** O(1), since no extra data structures are used.
