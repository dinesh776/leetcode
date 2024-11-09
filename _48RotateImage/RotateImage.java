package Github._48RotateImage;

//48. Rotate Image
//https://leetcode.com/problems/rotate-image/description/


import java.util.Arrays;

public class RotateImage {
    public static void main(String[] args) {
        int[][] matrix = {{5,1,9,11},{2,4,8,10},{13,3,6,7},{15,14,12,16}};
//        int[][] matrix={{1,2,3},{4,5,6},{7,8,9}};
        rotate(matrix);
        System.out.println(Arrays.deepToString(matrix));
    }
    static void rotate(int[][] matrix) {
//        better solution with time=O(n^2) and space = O(1)
        int n=matrix.length;
//        transpose
        for(int i=0;i<n-1;i=i+1){
            for(int j=i+1;j<n;j=j+1){
                int temp=matrix[i][j];
                matrix[i][j]=matrix[j][i];
                matrix[j][i]=temp;
            }
        }
//        reverse
        for(int i=0;i<n;i=i+1){
            int s=0,e=n-1;
            while(s<e){
                int temp=matrix[i][s];
                matrix[i][s]=matrix[i][e];
                matrix[i][e]=temp;
                e=e-1;
                s=s+1;
            }
        }
    }

////        Brute force solution with extra space=O(2*n^2) and time = O(2*n^2)
//        int n=matrix.length;
//        int[][] temp=new int[n][n];
//       for (int i=0;i<n;i++){
//           for (int j=0;j<n;j++){
//               temp[i][j]=matrix[i][j];
//           }
//       }
//        System.out.println("temp="+Arrays.deepToString(temp));
//        for(int i=0;i<n;i++){
//            for(int j=n-1,k=0;j>=0&&k<n;j--,k++){
//                matrix[i][k]=temp[j][i];
//            }

}
