package Github._240SearchA2DMatrix2;

//https://leetcode.com/problems/search-a-2d-matrix-ii/description/
//240. Search a 2D Matrix II

public class SearchA2DMatrix2 {
    public static void main(String[] args) {
        int target=-10;
        int[][]  matrix = {{-5}};
        System.out.println(searchMatrix(matrix,target));
    }
    static boolean searchMatrix(int[][] matrix, int target) {
        int row=0,col=matrix[0].length-1;
        while(row<matrix.length && col>=0){
            if(matrix[row][col]==target){
                return true;
            }
            else if(matrix[row][col]<target){
                row++;
            }
            else{
                col--;
            }
        }
        return false;
    }
}
