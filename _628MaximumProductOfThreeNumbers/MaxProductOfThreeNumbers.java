package Github._628MaximumProductOfThreeNumbers;

//628. Maximum Product of Three Numbers
//https://leetcode.com/problems/maximum-product-of-three-numbers/description/

import java.util.Arrays;


public class MaxProductOfThreeNumbers {
    public static void main(String[] args) {
        int[] nums={-100,-98,-1,2,3,4};
        System.out.println(maximumProduct(nums));
    }
    static int maximumProduct(int[] nums) {
        // Sort the array
        Arrays.sort(nums);

        // Compute the two potential maximum products
        int n = nums.length;
        int option1 = nums[n - 1] * nums[n - 2] * nums[n - 3];
        int option2 = nums[0] * nums[1] * nums[n - 1];

        // Return the maximum of the two
        return Math.max(option1, option2);
    }
}
