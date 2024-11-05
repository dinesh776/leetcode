package Github._53MaximumSubarray;

//53 Maximum subarray
//https://leetcode.com/problems/maximum-subarray/description/


public class MaximumSubarray {
    public static void main(String[] args) {
        int[] nums={5,4,-1,7,8};
        System.out.println(maxSubArray(nums));
    }
    static int maxSubArray(int[] nums) {
        int sum=0,max_sum=0;
        for(int i=0;i<nums.length;i++){
            sum+=nums[i];
            if(max_sum<sum){
                max_sum=sum;
            }
            if(sum<0){
                sum=0;
            }
        }
        return max_sum;
    }
}
