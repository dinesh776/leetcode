package Github._73SetMatrixZeroes;

//73. Set Matrix Zeroes
//https://leetcode.com/problems/set-matrix-zeroes/description/


import java.util.Arrays;

public class SetMatrixZeroes {
    public static void main(String[] args) {
        int[][] matrix ={{0},{1}};
        setZeroes(matrix);
        System.out.println(Arrays.deepToString(matrix));
    }
    static void setZeroes(int[][] matrix) {
//        optimal solution with time=O(2*(m*n)) and space=O(1)
        int col0=1;
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[i].length;j++){
                if(matrix[i][j]==0){
                    matrix[i][0]=0;
                    if (j!=0){
                        matrix[0][j]=0;
                    }
                    else{
                        col0=0;
                    }
                }
            }
        }
        for(int i=1;i<matrix.length;i++){
            for(int j=1;j<matrix[i].length;j++){
                if(matrix[i][j]!=0){
                    if(matrix[0][j]==0||matrix[i][0]==0){
                        matrix[i][j]=0;
                    }
                }
            }
        }
        if(matrix[0][0]==0){
            for(int j=0;j<matrix[0].length;j++){
                matrix[0][j]=0;
            }
        }
        if(col0==0){
            for(int i=0;i<matrix.length;i++){
                matrix[i][0]=0;
            }
        }

////        better solution with time = O(2*(m*n)) and space=O(m+n)
//        int m=matrix.length,n=matrix[0].length;
//        int[] row=new int[m],col=new int[n];
//
//        for(int i=0;i<m;i++){
//            for(int j=0;j<matrix[i].length;j++){
//                if(matrix[i][j]==0){
//                    row[i]=1;
//                    col[j]=1;
//                }
//            }
//        }
//        for(int i=0;i<m;i++){
//            for(int j=0;j<matrix[i].length;j++){
//                if(row[i]==1||col[j]==1){
//                    matrix[i][j]=0;
//                }
//            }
//        }
    }

}
