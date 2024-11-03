package Github._485MaxConsecutiveOnes;

//485. Max Consecutive Ones
//https://leetcode.com/problems/max-consecutive-ones/description/


public class MaxConsecutiveOnes {
    public static void main(String[] args) {
        int[] nums={1,0,1,1,0,1};
        System.out.println(findMaxConsecutiveOnes(nums));
    }
    static int findMaxConsecutiveOnes(int[] nums) {
        int max_count=0,count=0;
        for(int i=0;i< nums.length;i++){
            if(nums[i]==1){
                count++;
                max_count=Math.max(count,max_count);
            }else {
                count=0;
            }
        }
        return max_count;
    }
}
