package Github._1901FindAPeakElement2;

//1901. Find a Peak Element II
//https://leetcode.com/problems/find-a-peak-element-ii/description/

import java.util.Arrays;

public class FindAPeakElement2 {
    public static void main(String[] args) {
        int[][] matrix = {{25,37,23,37,19},{45,19,2,43,26},{18,1,37,44,50}};
        System.out.println(Arrays.toString(findPeakGrid(matrix)));
    }
    static int[] findPeakGrid(int[][] mat) {
        int n=mat.length,start=0,m=mat[0].length,end=m-1;
        while(start<=end){
            int mid=(start+end)/2;
            int row=findMax(mat,mid,n);
            int left=(mid-1>=0)?(mat[row][mid-1]):-1;
            int right=(mid+1)<m?(mat[row][mid+1]):-1;
            if(mat[row][mid]>left&&mat[row][mid]>right){
                return new int[]{row,mid};
            }
            else if(mat[row][mid]<left){
                end=mid-1;
            }
            else{
                start=mid+1;
            }
        }
        return new int[]{-1,-1};
    }
    static int findMax(int[][] mat,int mid,int n) {
        int max=Integer.MIN_VALUE,row=-1;
        for(int i=0;i<n;i++){
            if(max<mat[i][mid]){
                max=mat[i][mid];
                row=i;
            }
        }
        return row;
    }
}
