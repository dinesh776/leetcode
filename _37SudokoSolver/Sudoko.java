package Github._37SudokoSolver;
//37. Sudoku Solver
//https://leetcode.com/problems/sudoku-solver/description/
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
