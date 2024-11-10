package Github._54SprialMatrix;

//54. Spiral Matrix
//https://leetcode.com/problems/spiral-matrix/description/


import java.util.*;

public class SpiralMatrix {
    public static void main(String[] args) {
        int[][] matrix={{1,2,3,4},{5,6,7,8},{9,10,11,12}};
        System.out.println(spiralOrder(matrix));
    }
    static List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> list=new ArrayList<>();
        int n=matrix.length,m=matrix[0].length;
        int left=0,right=m-1;
        int top=0,bottom=n-1;
        while(top<=bottom&&left<=right){
//            left -> right
            for(int i=left;i<=right;i++){
                list.add(matrix[top][i]);
            }
            top=top+1;
//            right top -> bottom
            for(int i=top;i<=bottom;i++){
                list.add(matrix[i][right]);
            }
            right=right-1;
//            bottom right -> left
            if(top<=bottom){

                for(int i=right;i>=left;i--){
                    list.add(matrix[bottom][i]);
                }
                bottom=bottom-1;
            }
//            bottom -> top
            if(left<=right){
                for(int i=bottom;i>=top;i--){
                    list.add(matrix[i][left]);
                }
                left=left+1;
            }
        }
        return list;
    }
}
