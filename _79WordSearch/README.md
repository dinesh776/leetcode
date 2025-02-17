# Word Search

## Problem Description
The Word Search problem is a classic backtracking problem where we need to find if a given word exists in a 2D board of characters. The word must be formed by sequentially adjacent cells, where adjacent cells are horizontally or vertically neighboring. The same letter cell cannot be used more than once.

**LeetCode Problem:** [79. Word Search](https://leetcode.com/problems/word-search/description/)

## Example
### Input:
```java[]
char[][] board = {
  {'A', 'B', 'C', 'E'},
  {'S', 'F', 'C', 'S'},
  {'A', 'D', 'E', 'E'}
};
String word = "ABCCED";
```
### Output:
```java[]
true
```

## Solution Approach
This problem is solved using **backtracking**. The main idea is:
- Iterate over each cell in the board.
- If the character matches the first letter of the word, initiate a depth-first search (DFS).
- Recursively check the next character in all four possible directions (up, down, left, right).
- Use a `visited` matrix to avoid revisiting the same cell in the current search path.
- If the entire word is found, return `true`; otherwise, backtrack and try another path.

## Code Implementation
```java[]
public class WordSearch {
    public static void main(String[] args) {
        char[][] board = {{'a', 'a'}};
        String word = "aaa";
        System.out.println(exist(board, word));
    }
    
    public static boolean exist(char[][] board, String word) {
        int rows = board.length;
        int cols = board[0].length;
        boolean[][] visited = new boolean[rows][cols];
        
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (helper(board, word, 0, i, j, visited)) {
                    return true;
                }
            }
        }
        return false;
    }
    
    public static boolean helper(char[][] board, String word, int index, int i, int j, boolean[][] visited) {
        if (index == word.length()) {
            return true;
        }
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || visited[i][j] || word.charAt(index) != board[i][j]) {
            return false;
        }
        
        visited[i][j] = true;
        boolean found = helper(board, word, index + 1, i + 1, j, visited) ||
                        helper(board, word, index + 1, i, j + 1, visited) ||
                        helper(board, word, index + 1, i - 1, j, visited) ||
                        helper(board, word, index + 1, i, j - 1, visited);
        visited[i][j] = false;
        return found;
    }
}
```

## How It Works
1. Start iterating over the board.
2. If the first character of the word is found, call the `helper` function.
3. Recursively search in all four directions.
4. If the word is found, return `true`.
5. If all possibilities are exhausted, return `false`.

## Complexity Analysis
- **Time Complexity:** O(N * M * 4^L), where N and M are the dimensions of the board, and L is the length of the word.
- **Space Complexity:** O(L) due to recursion depth and the `visited` matrix.



