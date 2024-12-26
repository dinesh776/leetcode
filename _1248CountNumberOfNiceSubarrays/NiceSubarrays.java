package Github._1248CountNumberOfNiceSubarrays;

//1248. Count Number of Nice Subarrays
//https://leetcode.com/problems/count-number-of-nice-subarrays/description/

public class NiceSubarrays {
    public static void main(String[] args) {
        int[] nums={1,1,2,1,1};
        int k=3;
        System.out.println(numberOfSubarrays(nums,k));
    }
    static int numberOfSubarrays(int[] nums, int k) {
        return helper(nums,k)-helper(nums,k-1);
    }
    private static int helper(int[] nums,int goal){
        if(goal<0){
            return 0;
        }
        int i=0,j=0;
        int sum=0,maxCount=0;
        while(j<nums.length){
            sum+=(nums[j]%2);
            while(sum>goal){
                sum-=(nums[i]%2);
                i++;
            }
            maxCount=maxCount+(j-i+1);
            j++;
        }
        return maxCount;
    }
}
