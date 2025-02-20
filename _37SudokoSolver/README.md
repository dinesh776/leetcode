# Sudoku Solver

## Problem Description
The **Sudoku Solver** problem requires writing a program to solve a given Sudoku puzzle by filling empty cells ('.') with digits from '1' to '9' while ensuring that:
- Each row contains digits 1-9 without repetition.
- Each column contains digits 1-9 without repetition.
- Each of the nine 3x3 sub-grids contains digits 1-9 without repetition.

**LeetCode Link:** [Sudoku Solver](https://leetcode.com/problems/sudoku-solver/description/)

## Solution Approach
This solution employs **Backtracking** to recursively attempt filling in digits and backtrack if a conflict arises.

### Steps:
1. **Find Empty Cells:** Traverse the board to locate empty positions.
2. **Try Digits 1-9:** For each empty cell, attempt placing digits from '1' to '9'.
3. **Check Validity:** Ensure the digit satisfies Sudoku rules.
4. **Recursively Solve:** If the digit placement leads to a valid solution, continue; otherwise, backtrack.
5. **Base Case:** If the board is fully filled, return `true`.

## Code Example
```java[]
import java.util.Arrays;

public class Sudoko {
    public static void main(String[] args) {
        char[][] board={{'5','3','.','.','7','.','.','.','.'},
                        {'6','.','.','1','9','5','.','.','.'},
                        {'.','9','8','.','.','.','.','6','.'},
                        {'8','.','.','.','6','.','.','.','3'},
                        {'4','.','.','8','.','3','.','.','1'},
                        {'7','.','.','.','2','.','.','.','6'},
                        {'.','6','.','.','.','.','2','8','.'},
                        {'.','.','.','4','1','9','.','.','5'},
                        {'.','.','.','.','8','.','.','7','9'}};
        
        for(char[] arr:board){
            System.out.println(Arrays.toString(arr));
        }
        System.out.println();
        System.out.println("-----------------------------------------");
        System.out.println();
        solveSudoku(board);
        for(char[] arr:board){
            System.out.println(Arrays.toString(arr));
        }
    }
    
    public static void solveSudoku(char[][] board) {
        solve(board);
    }
    
    private static boolean solve(char[][] board){
        for(int i=0;i< board.length;i++){
            for(int j=0;j<board[0].length;j++){
                if(board[i][j]=='.'){
                    for(char k='1';k<='9';k++){
                        if(isvalid(board,i,j,k)){
                            board[i][j]=k;
                            if(solve(board)){
                                return true;
                            }else{
                                board[i][j]='.';
                            }
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }
    
    private static boolean isvalid(char[][] board,int row,int col,char c){
        for(int i=0;i<9;i++){
            if(board[i][col]==c)
                return false;
            if(board[row][i]==c)
                return false;
            if(board[3*(row/3)+i/3][3*(col/3)+i%3]==c)
                return false;
        }
        return true;
    }
}
```

## How It Works
- **solveSudoku:** Initiates solving the Sudoku board.
- **solve:** Uses backtracking to recursively attempt filling empty cells.
- **isvalid:** Checks if a number can be placed at a given position without violating Sudoku rules.

## Complexity Analysis
- **Time Complexity:** O(9^(n*n)), where `n` is the number of empty cells.
- **Space Complexity:** O(1) (modifies the board in place).

## Usage
1. Compile and run the program.
2. Input a Sudoku board with empty cells represented by '.'.
3. The program outputs the solved board.

## Tags
- Backtracking
- Recursion
- Sudoku Solver
- Java

---
