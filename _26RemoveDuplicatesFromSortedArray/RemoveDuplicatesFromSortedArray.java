package Github._26RemoveDuplicatesFromSortedArray;

//https://leetcode.com/problems/remove-duplicates-from-sorted-array/description/
//26. Remove Duplicates from Sorted Array


import java.util.Arrays;

public class RemoveDuplicatesFromSortedArray {
    public static void main(String[] args) {
        int[] arr=new int[]{0,0,1,1,1,2,2,3,3,4};
        System.out.println(Arrays.toString(arr));
        System.out.println(removeDuplicates(arr));
        System.out.println(Arrays.toString(arr));
    }
    static int removeDuplicates(int[] nums) {
        int i=0,r=1,n= nums.length;
        while(i<n&&r<n){
            if(nums[i]!=nums[r]){
                int temp=nums[i+1];
                nums[i+1]=nums[r];
                nums[r]=temp;
                i++;
            }
            r++;
        }
        return i+1;
    }
}
