package Github._189RotateArray;

//189. Rotate Array
//https://leetcode.com/problems/rotate-array/description/

import java.util.Arrays;

public class RotateArray {
    public static void main(String[] args) {
        int[] arr={-1,2,3};
        int k=5;
        rotate(arr,k);
        System.out.println(Arrays.toString(arr));
    }
    static void rotate(int[] nums, int k) {
        int index = k % nums.length;
        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, index - 1);
        reverse(nums, index, nums.length - 1);
    }
    static void reverse(int[] nums,int start,int end){
        while(start<end){
            int temp=nums[start];
            nums[start]=nums[end];
            nums[end]=temp;
            start++;
            end--;
        }
    }
}
