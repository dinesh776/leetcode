package Github._645SetMismatch;

//https://leetcode.com/problems/set-mismatch/
//Set Mismatch


import java.util.Arrays;

public class SetMismatch {
    public static void main(String[] args) {
        int[] nums={3};
        System.out.println(Arrays.toString(findErrorNums(nums)));
    }
    static int[] findErrorNums(int[] nums) {
        int n = nums.length;

        // To store sum and sum of squares for 1 to n
        long expectedSum = (long) n * (n + 1) / 2;
        long expectedSquareSum = (long) n * (n + 1) * (2 * n + 1) / 6;

        // To store sum and sum of squares of elements in nums
        long actualSum = 0, actualSquareSum = 0;

        for (int num : nums) {
            actualSum += num;
            actualSquareSum += (long) num * num;
        }

        // Calculating the differences
        long diffSum = actualSum - expectedSum;  // diffSum = duplicate - missing
        long diffSquareSum = actualSquareSum - expectedSquareSum;  // diffSquareSum = duplicate^2 - missing^2

        // Solving for the duplicate and missing numbers
        long sumOfNums = diffSquareSum / diffSum;  // duplicate + missing

        int duplicate = (int) (sumOfNums + diffSum) / 2;
        int missing = (int) (sumOfNums - duplicate);

        return new int[] { duplicate, missing };
    }}
