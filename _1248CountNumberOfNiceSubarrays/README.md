# Count Number of Nice Subarrays

This repository contains the solution for the LeetCode problem [1248. Count Number of Nice Subarrays](https://leetcode.com/problems/count-number-of-nice-subarrays/description/).

## Problem Description
Given an array of integers `nums` and an integer `k`, return the number of "nice subarrays."

A "nice subarray" is a contiguous subarray that contains exactly `k` odd numbers.

### Example:

#### Input:
```java[]
nums = [1, 1, 2, 1, 1], k = 3
```

#### Output:
```java[]
2
```

#### Explanation:
The nice subarrays are `[1,1,2,1]` and `[1,2,1,1]`.

## Solution
The solution uses a sliding window approach to efficiently count the number of subarrays with exactly `k` odd numbers.

### Code Example:
```java[]
public class NiceSubarrays {
    public static void main(String[] args) {
        int[] nums = {1, 1, 2, 1, 1};
        int k = 3;
        System.out.println(numberOfSubarrays(nums, k));
    }

    static int numberOfSubarrays(int[] nums, int k) {
        return helper(nums, k) - helper(nums, k - 1);
    }

    private static int helper(int[] nums, int goal) {
        if (goal < 0) {
            return 0;
        }
        int i = 0, j = 0;
        int sum = 0, maxCount = 0;
        while (j < nums.length) {
            sum += (nums[j] % 2);
            while (sum > goal) {
                sum -= (nums[i] % 2);
                i++;
            }
            maxCount += (j - i + 1);
            j++;
        }
        return maxCount;
    }
}
```

## How It Works
1. The `helper` function calculates the number of subarrays with at most `goal` odd numbers.
2. The `numberOfSubarrays` function computes the difference between the number of subarrays with at most `k` and at most `k-1` odd numbers to get the count of subarrays with exactly `k` odd numbers.

### Key Points:
- **Sliding Window:** Keeps track of the current window containing odd numbers.
- **Efficiency:** Operates in O(n) time complexity with O(1) space complexity.

## Usage
Compile and run the program using any Java compiler or IDE.

### Example:
```bash
javac NiceSubarrays.java
java NiceSubarrays
```

### Output:
The program will output the number of nice subarrays based on the given input.

## Complexity Analysis
- **Time Complexity:** O(n), where `n` is the length of the array `nums`.
- **Space Complexity:** O(1), as no extra space is used other than variables.

## References
- [LeetCode Problem 1248](https://leetcode.com/problems/count-number-of-nice-subarrays/description/)
