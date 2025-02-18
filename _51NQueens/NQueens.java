package Github._51NQueens;

//51 N-Queens
//https://leetcode.com/problems/n-queens/description/

import java.util.*;

public class NQueens {
    public static void main(String[] args) {
        int n=4;
        System.out.println(solveNQueens(n));
    }
    public static List<List<String>> solveNQueens(int n) {
        List<List<String>> res=new ArrayList<>();
        char[][] board= new char[n][n];
        int[] left=new int[n];
        int[] lowerDiagonal=new int[2*n-1];
        int[] upperDiagonal=new int[2*n-1];

        for(int i=0;i<n;i++){
            Arrays.fill(board[i],'.');
        }
        helper(n,0,board,left,upperDiagonal,lowerDiagonal,res);
        return res;
    }
    public static void helper(int n,int col,char[][] board,int[] left,int[] upperDiagonal,int[] lowerDiagonal,List<List<String>> res){
        if(col==n){
//            1ms
            res.add(construct(board));

//            3ms
//            res.add(Arrays.stream(board).map(String::new).collect(Collectors.toList()));
            return;
        }

        for(int row=0;row<n;row++){
            if(left[row]==0&&lowerDiagonal[row+col]==0&&upperDiagonal[n-1+col-row]==0){
                board[row][col]='Q';
                left[row]=1;
                lowerDiagonal[row+col]=1;
                upperDiagonal[n-1+col-row]=1;
                helper(n,col+1,board,left,upperDiagonal,lowerDiagonal,res);
                board[row][col]='.';
                left[row]=0;
                lowerDiagonal[row+col]=0;
                upperDiagonal[n-1+col-row]=0;
            }
        }
    }
    public static List < String > construct(char[][] board) {
        List <String> res = new LinkedList <> ();
        for (int i = 0; i < board.length; i++) {
            String s = new String(board[i]);
            res.add(s);
        }
        return res;
    }
}
