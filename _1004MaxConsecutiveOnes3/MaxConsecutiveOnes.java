package Github._1004MaxConsecutiveOnes3;

//1004. Max Consecutive Ones III
//https://leetcode.com/problems/max-consecutive-ones-iii/description/

public class MaxConsecutiveOnes {
    public static void main(String[] args) {
        int[] nums={1,1,1,0,0,0,1,1,1,1,0};
        int k=2;
        System.out.println(longestOnes(nums,k));
    }
    static int longestOnes(int[] nums, int k) {
        int max_count = 0;
        int count=0,kCount=0;
        int l=0,r=0;
        while(r<nums.length){
            if(nums[r]==0){
                kCount++;
            }
            while(kCount>k){
                if(nums[l]==0&&kCount>0){
                    kCount--;
                }
                l++;
                count--;
            }
            count++;
            max_count=Math.max(max_count,count);
            r++;
        }
        return max_count;
    }
}
