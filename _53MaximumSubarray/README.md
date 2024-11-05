
# Maximum Subarray

This repository contains a solution to the LeetCode problem [Maximum Subarray](https://leetcode.com/problems/maximum-subarray/), implemented in Java, using **Kadane's Algorithm**.

## Problem Description

Given an integer array `nums`, find the contiguous subarray (containing at least one number) which has the largest sum and return its sum.

- **Example:** For an array `[5, 4, -1, 7, 8]`, the output will be `23`.

### Example

**Input:**
```java[]
int[] nums = {5, 4, -1, 7, 8};
```
**Output:**
```java[]
23
```

**Explanation:**

The contiguous subarray `[5, 4, -1, 7, 8]` has the largest sum, which is `23`.

## Solution

The solution employs Kadane's Algorithm to find the maximum subarray sum in an efficient manner. It iterates through the array, maintaining a running subarray sum (`sum`). If `sum` becomes negative, it resets to zero to avoid reducing the maximum sum. The algorithm updates `max_sum` whenever a new maximum is found.

## Code Example

```java[]
public class MaximumSubarray {
    public static void main(String[] args) {
        int[] nums = {5, 4, -1, 7, 8};
        System.out.println(maxSubArray(nums));
    }

    static int maxSubArray(int[] nums) {
        int sum = 0, max_sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (max_sum < sum) {
                max_sum = sum;
            }
            if (sum < 0) {
                sum = 0;
            }
        }
        return max_sum;
    }
}
```

## How it Works

1. **Initialize Variables:** `sum` tracks the current subarray sum, and `max_sum` keeps the maximum sum encountered.
2. **Iterate through Array:** For each element, add it to `sum`. Update `max_sum` if `sum` exceeds it. Reset `sum` to zero if it becomes negative.
3. **Return the Maximum Sum:** After the loop, `max_sum` holds the largest subarray sum.

## How to Use

To run the solution, compile and execute the `MaximumSubarray` class in your Java environment:

```bash[]
javac MaximumSubarray.java
java MaximumSubarray
```
This will output the maximum sum of a contiguous subarray in the provided array.

## Complexity Analysis

- **Time Complexity:** O(n), where `n` is the length of the array, since it iterates through the array once.
- **Space Complexity:** O(1), as only a fixed amount of space is used.
