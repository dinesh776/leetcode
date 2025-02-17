package Github._79WordSearch;

//79. Word Search
//https://leetcode.com/problems/word-search/description/

public class WordSearch {
    public static void main(String[] args) {
        char[][] board={{'a','a'}};
        String word="aaa";
        System.out.println(exist(board,word));
    }
    public static boolean exist(char[][] board, String word) {
        int rows=board.length;
        int cols=board[0].length;
        boolean[][] visited= new boolean[rows][cols];
        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                if(helper(board,word,0,i,j,visited)){
                    return true;
                }
            }
        }
        return false;
    }
    public static boolean helper(char[][] board,String word,int index,int i,int j,boolean[][] visited){
        if(index==word.length()){
            return true;
        }
        if(i<0||i>=board.length||j<0||j>=board[0].length||visited[i][j]||word.charAt(index)!=board[i][j]){
            return false;
        }
        visited[i][j]=true;
        boolean f=helper(board,word,index+1,i+1,j,visited)||
                helper(board,word,index+1,i,j+1,visited)||
                helper(board, word, index+1, i-1, j, visited)||
                helper(board,word,index+1,i,j-1,visited);
        visited[i][j]=false;
        return f;
    }
}
