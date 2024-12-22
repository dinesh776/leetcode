# Range Sum Query - Immutable

This repository contains the implementation of the `Range Sum Query` problem, which calculates the sum of elements in a specified range of an integer array.

## Problem Description

**LeetCode Problem 303: Range Sum Query - Immutable**

Given an integer array `nums`, implement the class `NumArray` that supports:

1. `NumArray(int[] nums)` Initializes the object with the integer array `nums`.
2. `int sumRange(int left, int right)` Returns the sum of the elements of `nums` between indices `left` and `right` inclusive (i.e., `nums[left] + nums[left + 1] + ... + nums[right]`).

### Example

Input:
```java[]
nums = {-2, 0, 3, -5, 2, -1}
queries = {{0,2},{2,5},{0,5}}
```

Output:
```
[1, -1, -3]
```

## Implementation

### Class Implementation

```java[]
class NumArray {
    private int[] nums;

    public NumArray(int[] nums) {
        this.nums = nums;
    }

    public int sumRange(int left, int right) {
        int sum = 0;
        for (int i = left; i <= right; i++) {
            sum = sum + nums[i];
        }
        return sum;
    }
}
```

### Driver Code

```java[]
import java.util.Arrays;

public class RangeSumQuery {
    public static void main(String[] args) {
        int[] nums = {-2, 0, 3, -5, 2, -1};
        int[][] queries = {{0, 2}, {2, 5}, {0, 5}};

        NumArray rangeSumQuery = new NumArray(nums);
        int[] ans = new int[queries.length];

        for (int i = 0; i < queries.length; i++) {
            ans[i] = rangeSumQuery.sumRange(queries[i][0], queries[i][1]);
        }

        System.out.println(Arrays.toString(ans));
    }
}
```

## Usage

1. Instantiate the `NumArray` object with an integer array.
2. Call the `sumRange` method with two integers `left` and `right` to get the sum of elements between these indices.

### Input Format
- `nums`: An integer array (e.g., `{-2, 0, 3, -5, 2, -1}`).
- `queries`: A 2D array where each subarray contains two integers representing `left` and `right` indices.

### Output Format
An array of integers where each element represents the sum for the respective query.

## Complexity Analysis

- **Time Complexity:**
    - Initialization: `O(1)`
    - Querying: `O(n)` per query (linear traversal for the range).

- **Space Complexity:**
    - `O(1)` extra space (excluding the input array).

## How It Works

1. The `NumArray` constructor initializes the object with the array `nums`.
2. The `sumRange` method iterates through the range `[left, right]` and computes the sum of elements within the range.
3. The driver code uses this method to compute sums for multiple queries and prints the result as an array.

## Example Execution

For the input `nums = {-2, 0, 3, -5, 2, -1}` and `queries = {{0,2},{2,5},{0,5}}`:
- Query 1: Sum of `nums[0]` to `nums[2]` = `-2 + 0 + 3 = 1`
- Query 2: Sum of `nums[2]` to `nums[5]` = `3 + (-5) + 2 + (-1) = -1`
- Query 3: Sum of `nums[0]` to `nums[5]` = `-2 + 0 + 3 + (-5) + 2 + (-1) = -3`

Output:
```
[1, -1, -3]
```

## Notes
- This solution uses a simple iterative approach for range summation. To optimize for multiple queries, consider implementing a prefix sum array or segment tree.

## References
- LeetCode Problem: [Range Sum Query - Immutable](https://leetcode.com/problems/range-sum-query-immutable/description/)
