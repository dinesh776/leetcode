package Github._930BinarySubarraysWithSum;

//930. Binary Subarrays With Sum
//https://leetcode.com/problems/binary-subarrays-with-sum/description/

public class BinarySubArrayWithSum {
    public static void main(String[] args) {
        int[] nums={1,0,1,0,1};
        int goal=2;
        System.out.println(numSubarraysWithSum(nums,goal));
    }
    static int numSubarraysWithSum(int[] nums, int goal) {
        return helper(nums,goal)-helper(nums,goal-1);
    }

    private static int helper(int[] nums,int goal){
        if(goal<0){
            return 0;
        }
        int i=0,j=0;
        int sum=0,maxCount=0;
        while(j<nums.length){
            sum+=nums[j];
            while(sum>goal){
                sum-=nums[i];
                i++;
            }
            maxCount=maxCount+(j-i+1);
            j++;
        }
        return maxCount;
    }
}
