package Github._2149RearrangeArrayElementsBysign;

//2149. Rearrange Array Elements by Sign
//https://leetcode.com/problems/rearrange-array-elements-by-sign/description/


import java.util.Arrays;

public class RearrageArrayElementsBySign {
    public static void main(String[] args) {
        int[] nums = {-1, -2, -3, 4, 5, 6};
        System.out.println(Arrays.toString(rearrangeArray(nums)));
    }

    static int[] rearrangeArray(int[] nums) {
//        Brute force with time complexity=O(n) & extra space complexity=O(n)
        int n = nums.length, p = 0, ne = 1;
        int[] temp = new int[n];
        for (int i = 0; i < n; i = i + 1) {
            if (nums[i] >= 0) {
                temp[p] = nums[i];
                p = p + 2;
            } else {
                temp[ne] = nums[i];
                ne = ne + 2;
            }
        }
        return temp;
    }
}