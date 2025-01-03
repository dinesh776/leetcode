[# Number of Ways to Split Array

## Problem Description
[Number of Ways to Split Array](https://leetcode.com/problems/number-of-ways-to-split-array/description/?envType=daily-question&envId=2025-01-03)

You are given an integer array `nums`. Determine the number of ways to split the array into two non-empty parts such that the sum of the left part is greater than or equal to the sum of the right part.

## Example
### Input
```java[]
int[] nums = {10, 4, -8, 7};
```
### Output
```java[]
2
```

## Solution
The solution involves calculating the total sum of the array and iterating through the array to maintain a running prefix sum. For each split point, compare the prefix sum with the remaining sum to determine if the split satisfies the condition.

### Code Example
```java[]
public class NumberOfWaysToSplitArray {
    public static void main(String[] args) {
        int[] nums = {10, 4, -8, 7};
        System.out.println(waysToSplitArray(nums));
    }

    static int waysToSplitArray(int[] nums) {
        int n = nums.length, c = 0;
        long totalSum = 0, preSum = 0;
        for (int x : nums) {
            totalSum = totalSum + x;
        }
        for (int i = 0; i < n - 1; i++) {
            preSum += nums[i];
            long k = totalSum - preSum;
            if (preSum >= k) {
                c++;
            }
        }
        return c;
    }
}
```

## How It Works
1. **Total Sum Calculation**: Compute the total sum of all elements in the array.
2. **Prefix Sum**: Iterate through the array while maintaining the cumulative sum of elements (prefix sum).
3. **Condition Check**: For each split point, check if the prefix sum is greater than or equal to the remaining sum of the array.
4. **Count Splits**: Increment the count for each valid split point.

### Complexity Analysis
- **Time Complexity**: `O(n)`, where `n` is the number of elements in the array.
- **Space Complexity**: `O(1)`, as only a few variables are used for computation.

## Usage
The function `waysToSplitArray(int[] nums)` takes an integer array as input and returns the number of valid split points.


