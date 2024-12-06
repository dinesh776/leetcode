
# Smallest Divisor Finder

This project provides a solution to the LeetCode problem **1283. Find the Smallest Divisor Given a Threshold**.

## Problem Description

Given an array of integers `nums` and an integer `threshold`, find the smallest divisor such that the sum of the division results does not exceed the threshold. The division result of `nums[i] / divisor` is rounded up to the nearest integer.

### Example

Input:
```
nums = [44, 22, 33, 11, 1]
threshold = 5
```

Output:
```
44
```

## Solution

The solution uses a binary search algorithm to efficiently find the smallest divisor. The process involves:
1. Defining a search range between `1` and the maximum number in the array.
2. Iteratively calculating the sum of the division results for the middle value of the range.
3. Adjusting the search range based on the calculated sum compared to the threshold.

## Code Example

```java[]
public class _1283 {
    public static void main(String[] args) {
        int[] nums = {44, 22, 33, 11, 1};
        int threshold = 5;
        System.out.println(smallestDivisor(nums, threshold));
    }

    static int smallestDivisor(int[] nums, int threshold) {
        int ans = 0, n = nums.length;
        int start = 1, end = findMax(nums, n);
        while (start <= end) {
            int mid = start + (end - start) / 2;
            long div_sum = findDivSum(nums, mid, n);
            if (div_sum <= threshold) {
                ans = mid;
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return ans;
    }

    static long findDivSum(int[] arr, int mid, int n) {
        long sum = 0;
        for (int i = 0; i < n; i++) {
            sum = sum + (long)Math.ceil((double) arr[i] / (double) mid);
        }
        return sum;
    }

    static int findMax(int[] arr, int n) {
        int max = arr[0];
        for (int i = 1; i < n; i++) {
            max = Math.max(arr[i], max);
        }
        return max;
    }
}
```

## How It Works

1. **Finding the Maximum Element**: The maximum number in the array is the upper limit of our search range.
2. **Binary Search**: Iteratively check potential divisors, narrowing the range based on the sum of division results.
3. **Division Sum Calculation**: For a given divisor, compute the sum of the division results, rounding up each division.

## Usage

1. Clone or download the repository.
2. Compile and run the Java file using your preferred IDE or command line.

## Complexity Analysis

- **Time Complexity**: `O(n * log(max(nums)))`, where `n` is the size of the array and `max(nums)` is the largest number in the array.
- **Space Complexity**: `O(1)` (in-place computations).

## LeetCode Problem Link

[1283. Find the Smallest Divisor Given a Threshold](https://leetcode.com/problems/find-the-smallest-divisor-given-a-threshold/description/)
