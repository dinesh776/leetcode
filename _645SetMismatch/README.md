# Set Mismatch

This repository contains a solution to the LeetCode problem [Set Mismatch](https://leetcode.com/problems/set-mismatch/), implemented in Java.

## Problem Description

You are given a set of integers `nums` which contains numbers from `1` to `n`. However, there is exactly one duplicate number and one missing number. Your task is to find the duplicate number and the missing number.

### Example

**Input:**

- ```java
  nums = [1, 2, 2, 4]


**Output:**
-  ```java
    [2, 3]

## Explanation

The solution finds the duplicate and missing numbers by comparing the expected sum and sum of squares of numbers from 1 to n with the actual sum and sum of squares of the elements in nums. The differences between these sums allow us to derive the missing and duplicate numbers.

## Solution

The solution leverages mathematical equations based on the sum and square sum of numbers from 1 to n. We calculate the differences and solve them to isolate the duplicate and missing numbers.

## Code Example

- ```java
  import java.util.Arrays;

    public class SetMismatch {
    public static void main(String[] args) {
    int[] nums={1, 2, 2, 4};
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
    }
}


## How it Works

1. **Calculate Expected Sums:** The expected sum and square sum for numbers from `1` to `n` are computed.
2. **Compute Actual Sums:** The actual sum and square sum from the given array are calculated.
3. **Find Differences:** The differences between the actual and expected sums give relationships involving the duplicate and missing numbers.
4. **Solve Equations:** Using the differences, we solve for the duplicate and missing numbers.

## How to Use

To run the solution, compile and execute the `SetMismatch` class in your Java environment:

- ```bash
  javac SetMismatch.java
  java SetMismatch

This will output the array containing the duplicate and missing numbers.

## Complexity Analysis

- **Time Complexity:** - O(n), where n is the length of the array. We only need to traverse the array once.
- **Space Complexity:** - O(1), as we only use a few extra variables for calculations without additional data structures.