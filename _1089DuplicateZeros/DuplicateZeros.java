package Github._1089DuplicateZeros;

//1089. Duplicate Zeros
//https://leetcode.com/problems/duplicate-zeros/description/


import java.util.Arrays;

public class DuplicateZeros {
    public static void main(String[] args) {
        int[] arr = {1,0,2,3,0,4,5,0};
        duplicateZeros(arr);
        System.out.println(Arrays.toString(arr));
    }
    static void duplicateZeros(int[] arr) {
        int n=arr.length,j=0;
        if(n==1)
            return;
        int[] temp=arr.clone();
        for(int i=0;i<n;i++){
            arr[i]=temp[j];
            if(arr[i]==0 && i<n-1){
                arr[i+1]=0;
                i++;
            }
            j++;
        }
    }
}
