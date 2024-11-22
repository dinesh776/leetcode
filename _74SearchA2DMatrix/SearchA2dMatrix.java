package Github._74SearchA2DMatrix;

//74. Search a 2D Matrix
//https://leetcode.com/problems/search-a-2d-matrix/description/

public class SearchA2dMatrix {
    public static void main(String[] args) {
        int[][] matrix = {{1}};
        int target = 2;
        System.out.println(searchMatrix(matrix,target));
    }
    static boolean searchMatrix(int[][] matrix, int target) {
        int n=matrix.length,m=matrix[0].length;
        int start=0,end=(m*n)-1;
        while(start<=end){
            int mid=start+(end-start)/2;
            int row=mid/m,col=mid%m;
            if(matrix[row][col]==target){
                return true;
            }
            else if(target<matrix[row][col]){
                end=mid-1;
            }
            else {
                start=mid+1;
            }
        }

        return false;
    }
}
