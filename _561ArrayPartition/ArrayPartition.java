package Github._561ArrayPartition;
//561. Array Partition
//https://leetcode.com/problems/array-partition/description/

import java.util.Arrays;

public class ArrayPartition {
    public static void main(String[] args) {
        int[] nums={6,2,6,5,1,2};
        System.out.println(arrayPairSum(nums));
    }
//    12ms
    static int arrayPairSum(int[] nums) {
        int res=0;
        Arrays.sort(nums);
        int n=nums.length;
       for(int i=0;i<n;i+=2){
           res=res+nums[i];
       }
        return res;
    }

//    14ms
//    static int arrayPairSum(int[] nums) {
//        int res=0;
//        Arrays.sort(nums);
//        for(int i=0;i<nums.length-1;i+=2){
//            res+=Math.min(nums[i],nums[i+1]);
//        }
//        return res;
//    }
}
