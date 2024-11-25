
# Find First and Last Position of Element in Sorted Array

## Problem Description

Given an array of integers `nums` sorted in non-decreasing order, find the starting and ending position of a given target value.

If the target is not found in the array, return `[-1, -1]`.

You must write an algorithm with `O(log n)` runtime complexity.

- **LeetCode Problem**: [Find First and Last Position of Element in Sorted Array](https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/description/)

## Example

### Input
```java[]
nums = [5,7,7,8,8,10]
target = 8
```

### Output
```java[]
[3, 4]
```

### Explanation
The target value `8` appears at indices `3` and `4` in the array.

## Solution

This problem can be solved using a binary search approach to determine the first and last positions of the target value.

### Optimal Approach
- **Time Complexity**: O(log n)
- **Space Complexity**: O(1)

### Implementation
```java[]
import java.util.Arrays;

public class FirstAndLastPositionElement {
    public static void main(String[] args) {
        int[] nums = {};
        int target = 0;
        System.out.println(Arrays.toString(searchRange(nums, target)));
    }

    static int[] searchRange(int[] arr, int k) {
        int n = arr.length;
        int first = first(arr, k, n);
        int last = last(arr, k, n);
        return new int[]{first, last};
    }

    static int last(int[] arr, int k, int n) {
        int last = -1;
        int start = 0, end = n - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (arr[mid] == k) {
                last = mid;
                start = mid + 1;
            } else if (k < arr[mid]) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return last;
    }

    static int first(int[] arr, int k, int n) {
        int first = -1;
        int start = 0, end = n - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (arr[mid] == k) {
                first = mid;
                end = mid - 1;
            } else if (k < arr[mid]) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return first;
    }
}
```

## How it Works

1. **Binary Search for First Position**:
    - Perform binary search to locate the first occurrence of the target.
    - Adjust the `end` pointer when the target is found to continue searching in the left part of the array.

2. **Binary Search for Last Position**:
    - Perform binary search to locate the last occurrence of the target.
    - Adjust the `start` pointer when the target is found to continue searching in the right part of the array.

## Usage

1. Initialize the array `nums` and the target value.
2. Call the `searchRange` function to get the result.

## Complexity Analysis

- **Time Complexity**: `O(log n)` for binary search operations.
- **Space Complexity**: `O(1)` as no additional space is used.

