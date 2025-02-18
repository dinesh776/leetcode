# N-Queens Solution

## Problem Description
The **N-Queens** problem is a classic backtracking problem where we need to place `N` queens on an `N x N` chessboard such that no two queens attack each other. This means:
- No two queens should be in the same row.
- No two queens should be in the same column.
- No two queens should be on the same diagonal.

The goal is to return all possible solutions where each solution is a valid placement of `N` queens on the board.

**LeetCode Link:** [N-Queens](https://leetcode.com/problems/n-queens/description/)

---

## Solution Explanation
The solution uses **backtracking** to explore all possible placements of queens while ensuring that constraints are met at each step.

### Approach:
1. **Initialize Board:** Create an `N x N` board filled with `'.'` (empty positions).
2. **Track Constraints Efficiently:**
    - Use an array `left` of size `N` to track occupied rows.
    - Use an array `lowerDiagonal` of size `2N - 1` to track lower diagonals.
    - Use an array `upperDiagonal` of size `2N - 1` to track upper diagonals.
3. **Recursive Backtracking:**
    - Try placing a queen in each row of the current column.
    - If the placement is valid, mark it and proceed to the next column.
    - If a solution is found (all columns are filled), store it.
    - Backtrack by removing the queen and trying the next possibility.

---

## Code Implementation
```java[]
import java.util.*;
import java.util.stream.Collectors;

public class NQueens {
    public static void main(String[] args) {
        int n = 4;
        System.out.println(solveNQueens(n));
    }

    public static List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<>();
        char[][] board = new char[n][n];
        int[] left = new int[n];
        int[] lowerDiagonal = new int[2 * n - 1];
        int[] upperDiagonal = new int[2 * n - 1];

        for (int i = 0; i < n; i++) {
            Arrays.fill(board[i], '.');
        }

        helper(n, 0, board, left, upperDiagonal, lowerDiagonal, res);
        return res;
    }

    public static void helper(int n, int col, char[][] board, int[] left, int[] upperDiagonal, int[] lowerDiagonal, List<List<String>> res) {
        if (col == n) {
            res.add(construct(board));
            return;
        }

        for (int row = 0; row < n; row++) {
            if (left[row] == 0 && lowerDiagonal[row + col] == 0 && upperDiagonal[n - 1 + col - row] == 0) {
                board[row][col] = 'Q';
                left[row] = 1;
                lowerDiagonal[row + col] = 1;
                upperDiagonal[n - 1 + col - row] = 1;
                helper(n, col + 1, board, left, upperDiagonal, lowerDiagonal, res);
                board[row][col] = '.';
                left[row] = 0;
                lowerDiagonal[row + col] = 0;
                upperDiagonal[n - 1 + col - row] = 0;
            }
        }
    }

    public static List<String> construct(char[][] board) {
        List<String> res = new LinkedList<>();
        for (char[] chars : board) {
            res.add(new String(chars));
        }
        return res;
    }
}
```

---

## How It Works
1. **Base Case:** If `col == n`, a valid solution is found and added to the result list.
2. **Iterate Over Rows:** Try placing a queen in every row for the current column.
3. **Check Constraints:** If the position is safe:
    - Mark it.
    - Recur for the next column.
    - Backtrack after recursion.

---

## Complexity Analysis
- **Time Complexity:** `O(N!)` (Exponential) - Each queen placement leads to a smaller subproblem.
- **Space Complexity:** `O(N^2)` (Board Storage) + `O(N)` (Auxiliary Arrays).

---

## Example Usage
```java[]
public class Main {
    public static void main(String[] args) {
        System.out.println(new NQueens().solveNQueens(4));
    }
}
```
**Output:**
```json[]
[
    [".Q..","...Q","Q...","..Q."],
    ["..Q.","Q...","...Q",".Q.."]
]
```
Each nested list represents a valid arrangement of queens where 'Q' represents a queen and '.' represents an empty space.

---

## Usage
This implementation can be used to solve N-Queens problems for different values of `N`. Modify the `n` variable in `main` to get results for different board sizes.

---

## Summary
- Used **backtracking** for efficient exploration of solutions.
- Optimized with **constraint-tracking arrays** to reduce redundant checks.
- Generates all valid **N-Queens arrangements** efficiently.

This implementation provides an optimized and structured approach to solving the N-Queens problem with clarity and efficiency.

