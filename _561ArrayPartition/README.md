# Array Partition

This project provides a solution to the LeetCode problem [561. Array Partition](https://leetcode.com/problems/array-partition/description/).

## Problem Description
Given an integer array `nums` of `2n` integers, your task is to group these integers into `n` pairs (a<sub>1</sub>, b<sub>1</sub>), (a<sub>2</sub>, b<sub>2</sub>), ..., (a<sub>n</sub>, b<sub>n</sub>) such that the sum of min(a<sub>i</sub>, b<sub>i</sub>) for all `i` is maximized. Return the maximized sum.

### Example:
#### Input:
```java[]
nums = [6,2,6,5,1,2]
```
#### Output:
```java[]
9
```
#### Explanation:
The optimal grouping is (1, 2), (2, 5), (6, 6). The sum of min values is 1 + 2 + 6 = 9.

## Solution Approach
### Approach 1: Sorting (Optimized)
1. Sort the array in ascending order.
2. Iterate through the array, summing every alternate element (starting from index 0).

#### Code:
```java[]
static int arrayPairSum(int[] nums) {
    int res = 0;
    Arrays.sort(nums);
    int n = nums.length;
    for (int i = 0; i < n; i += 2) {
        res = res + nums[i];
    }
    return res;
}
```
#### Complexity Analysis:
- **Time Complexity:** O(n log n), due to sorting.
- **Space Complexity:** O(1), no additional space used.

### Approach 2: Sorting with Explicit Min Function
1. Sort the array in ascending order.
2. Iterate through the array in pairs, explicitly taking the minimum of each pair and adding it to the result.

#### Code:
```java[]
static int arrayPairSum(int[] nums) {
    int res = 0;
    Arrays.sort(nums);
    for (int i = 0; i < nums.length - 1; i += 2) {
        res += Math.min(nums[i], nums[i + 1]);
    }
    return res;
}
```
#### Complexity Analysis:
- **Time Complexity:** O(n log n), due to sorting.
- **Space Complexity:** O(1), no additional space used.

## How It Works
The solution relies on sorting the array to ensure that elements are paired optimally. By grouping consecutive numbers (after sorting), we minimize the loss in the sum of minimum values and maximize the overall sum.

### Example Walkthrough:
#### Input:
```java[]
nums = [6,2,6,5,1,2]
```
#### Steps:
1. Sort `nums`: [1, 2, 2, 5, 6, 6]
2. Pair elements: (1, 2), (2, 5), (6, 6)
3. Sum of minimums: 1 + 2 + 6 = 9

## Usage
1. Compile and run the `ArrayPartition` class.
2. Pass the input array as shown in the example.
3. Observe the output in the console.

## References
- [LeetCode Problem Link](https://leetcode.com/problems/array-partition/description/)
