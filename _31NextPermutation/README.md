
# Next Permutation

This repository contains a solution to the LeetCode problem [Next Permutation](https://leetcode.com/problems/next-permutation/), implemented in Java.

## Problem Description

The **Next Permutation** problem requires rearranging an integer array into its next lexicographically greater permutation. If the array is sorted in descending order (i.e., no greater permutation exists), it is rearranged into the lowest possible order (ascending). The algorithm modifies the array in place.

- **Example:** For an array `[1, 3, 2]`, the output will be `[2, 1, 3]`.

### Example

**Input:**
```java[]
int[] nums = {1, 3, 2};
```
**Output:**
```java[]
[2, 1, 3]
```

**Explanation:**

The next permutation of `[1, 3, 2]` in lexicographical order is `[2, 1, 3]`.

## Solution

The solution involves identifying the rightmost increasing pair in the array, swapping elements, and reversing a portion of the array to form the next permutation.

## Code Example

```java[]
import java.util.Arrays;

public class NextPermutation {
    public static void main(String[] args) {
        int[] arr = {1, 3, 2};
        nextPermutation(arr);
        System.out.println(Arrays.toString(arr));
    }

    static void nextPermutation(int[] nums) {
        int ind = -1, n = nums.length;
        for (int i = n - 2; i >= 0; i--) {
            if (nums[i] < nums[i + 1]) {
                ind = i;
                break;
            }
        }
        if (ind == -1) {
            reverse(nums, 0, n);
            return;
        }
        for (int i = n - 1; i > ind; i--) {
            if (nums[i] > nums[ind]) {
                swap(nums, i, ind);
                break;
            }
        }
        reverse(nums, ind + 1, n);
    }

    static void swap(int[] nums, int f, int s) {
        int temp = nums[f];
        nums[f] = nums[s];
        nums[s] = temp;
    }

    static void reverse(int[] nums, int s, int n) {
        int i = s, j = n - 1;
        while (i < j) {
            swap(nums, i, j);
            i++;
            j--;
        }
    }
}
```

## How it Works

1. **Find the Rightmost Ascending Pair:** Start from the end of the array, finding the first element that is smaller than the element to its right (i.e., the largest increasing sequence from the end).
2. **Swap Elements:** Find the smallest number larger than `nums[ind]` on the right and swap them.
3. **Reverse the Subarray:** Reverse the subarray to the right of the index to get the smallest lexicographic order after the swap.

## How to Use

To run the solution, compile and execute the `NextPermutation` class in your Java environment:

```bash[]
javac NextPermutation.java
java NextPermutation
```
This will output the array transformed into its next permutation.

## Complexity Analysis

- **Time Complexity:** O(n), where `n` is the length of the array. Each operation (finding indices, swapping, and reversing) is linear.
- **Space Complexity:** O(1), as it modifies the array in place.
