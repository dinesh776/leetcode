package Github._136SingleNumber;

//136. Single Number
//https://leetcode.com/problems/single-number/description/


public class SingleNumber {
    public static void main(String[] args) {
        int[] nums={2,2,1};
        System.out.println(singleNumber(nums));
    }
    static int singleNumber(int[] nums) {
        int xor=0;
        for(int i=0;i<nums.length;i++){
            xor=xor^nums[i];
        }
        return xor;
    }
}
