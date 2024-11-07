package Github._31NextPermutation;

//31. Next Permutation
//https://leetcode.com/problems/next-permutation/description/

import java.util.Arrays;

public class NextPermutation {
    public static void main(String[] args) {
        int[] arr={1,3,2};
        nextPermutation(arr);
        System.out.println(Arrays.toString(arr));
    }
    static void nextPermutation(int[] nums) {
        int ind=-1,n=nums.length;
        for(int i=n-2;i>=0;i--){
            if(nums[i]<nums[i+1]){
                ind=i;
                break;
            }
        }
        if(ind==-1){
            reverse(nums,0,n);
            return ;
        }
        for(int i=n-1;i>ind;i--){
            if(nums[i]>nums[ind]){
                swap(nums,i,ind);
                break;
            }
        }
        reverse(nums,ind+1,n);
    }
   static void swap(int[] nums,int f,int s){
       int temp=nums[f];
       nums[f]=nums[s];
       nums[s]=temp;
   }
    static void reverse(int[] nums,int s,int n){
        int i=s,j=n-1;
        while(i<j){
            swap(nums,i,j);
            i=i+1;
            j=j-1;
        }
    }
}
