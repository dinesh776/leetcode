package Github._2270NumberOfWaysToSplitArray;
//2270. Number of Ways to Split Array
//https://leetcode.com/problems/number-of-ways-to-split-array/description/?envType=daily-question&envId=2025-01-03
public class NumberOfWaysToSplitArray {
    public static void main(String[] args) {
        int[] nums={10,4,-8,7};
        System.out.println(waysToSplitArray(nums));
    }
    static int waysToSplitArray(int[] nums) {
        int n= nums.length, c=0;
        long totalSum=0,preSum=0;
        for (int x:nums){
            totalSum=totalSum+x;
        }
        for (int i=0;i<n-1;i++) {
            preSum += nums[i];
            long k = totalSum - preSum;
            if (preSum >= k) {
                c++;
            }
        }
        return c;
    }
}
