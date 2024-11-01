
# Rotate Array

This repository contains a solution to the LeetCode problem [Rotate Array](https://leetcode.com/problems/rotate-array/), implemented in Java.

## Problem Description

Given an array, rotate the array to the right by `k` steps, where `k` is non-negative.

- **Example:** For an array `[-1, 2, 3]` and `k = 5`, after rotating 5 times, the output will be `[2, -1, 3]`.

### Example

**Input:**
```java[]
int[] arr = {-1, 2, 3};
int k = 5;
```
**Output:**
```java[]
[2, -1, 3]
```

**Explanation:**

After rotating the array `[ -1, 2, 3 ]` five times, the result is `[ 2, -1, 3 ]`.

## Solution

The solution involves reversing parts of the array to achieve the rotation in an efficient manner. First, the entire array is reversed, then parts of it are reversed based on the rotation index.

## Code Example

```java[]
import java.util.Arrays;

public class RotateArray {
    public static void main(String[] args) {
        int[] arr = {-1, 2, 3};
        int k = 5;

        rotate(arr, k);
        System.out.println(Arrays.toString(arr));
    }

    static void rotate(int[] nums, int k) {
        int index = k % nums.length;
        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, index - 1);
        reverse(nums, index, nums.length - 1);
    }

    static void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }
}
```

## How it Works

1. **Calculate Rotation Index:** `index` is calculated as `k % nums.length` to handle cases where `k` is larger than the array length.
2. **Reverse the Entire Array:** Reverses the entire array to set up for segment rotations.
3. **Reverse Segments:** Reverses the first part (0 to index-1) and then the second part (index to end), resulting in the rotated array.

## How to Use

To run the solution, compile and execute the `RotateArray` class in your Java environment:

```bash[]
javac RotateArray.java
java RotateArray
```
This will output the rotated array as per the specified `k` value.

## Complexity Analysis

- **Time Complexity:** O(n), where `n` is the length of the array, as each element is reversed a constant number of times.
- **Space Complexity:** O(1), since no additional array space is used.
