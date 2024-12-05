
# U_Github - Search a 2D Matrix II

This package provides an efficient solution to the [LeetCode problem 240: Search a 2D Matrix II](https://leetcode.com/problems/search-a-2d-matrix-ii/description/). The problem involves searching for a target value in a 2D matrix following specific rules. The solution implements a binary search-like algorithm to achieve optimal performance.

## Problem Description

Write an efficient algorithm that searches for a target value in an `m x n` integer matrix. The matrix has the following properties:

- Integers in each row are sorted in ascending order from left to right.
- Integers in each column are sorted in ascending order from top to bottom.

### Example:

Input:
```
matrix = [
  [1,   4,  7, 11, 15],
  [2,   5,  8, 12, 19],
  [3,   6,  9, 16, 22],
  [10, 13, 14, 17, 24],
  [18, 21, 23, 26, 30]
]
target = 5
```

Output: `true`

Input:
```
matrix = [
  [1,   4,  7, 11, 15],
  [2,   5,  8, 12, 19],
  [3,   6,  9, 16, 22],
  [10, 13, 14, 17, 24],
  [18, 21, 23, 26, 30]
]
target = 20
```

Output: `false`

## Solution

The algorithm starts searching from the top-right corner of the matrix. Based on comparisons with the target:

1. If the current value equals the target, return `true`.
2. If the current value is less than the target, move down to the next row.
3. If the current value is greater than the target, move left to the previous column.

This process continues until the matrix bounds are exceeded.

### Code Example

```java[]
public class SearchA2DMatrix2 {
    public static void main(String[] args) {
        int target = -10;
        int[][]  matrix = {{-5}};
        System.out.println(searchMatrix(matrix, target));
    }

    static boolean searchMatrix(int[][] matrix, int target) {
        int row = 0, col = matrix[0].length - 1;
        while (row < matrix.length && col >= 0) {
            if (matrix[row][col] == target) {
                return true;
            } else if (matrix[row][col] < target) {
                row++;
            } else {
                col--;
            }
        }
        return false;
    }
}
```

## How It Works

- Initialize `row` to 0 and `col` to the last column index.
- Use a while loop to traverse the matrix within its bounds.
- Adjust `row` or `col` based on comparisons to the target.
- Return `true` if the target is found; otherwise, return `false`.

## Usage

1. Copy the code into a Java IDE or text editor.
2. Compile and run the program.
3. Modify the `matrix` and `target` inputs as needed to test different cases.

## Complexity Analysis

- **Time Complexity**: O(m + n), where `m` is the number of rows and `n` is the number of columns.
- **Space Complexity**: O(1), as the algorithm uses constant extra space.

---

**Happy Coding!**
