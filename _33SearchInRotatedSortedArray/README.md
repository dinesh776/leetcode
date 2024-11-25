
# Search in Rotated Sorted Array 1

This program solves the problem of searching for a target element in a rotated sorted array. The implementation uses binary search to achieve an efficient O(log n) time complexity.

## Problem Description

You are given an integer array `nums` sorted in ascending order (with distinct values), which is rotated at an unknown pivot index. Given the array and an integer `target`, return the index of the target if it is in `nums`, or `-1` if it is not in `nums`.

**Link to the problem:** [Search in Rotated Sorted Array 1](https://leetcode.com/problems/search-in-rotated-sorted-array/description/)

## Example

Input:
```java[]
int[] nums = {5, 1, 3};
int target = 5;
```

Output:
```java[]
0
```

## Code

```java[]


public class SearchInRotatedSortedArray1 {
    public static void main(String[] args) {
        int[] nums = {5, 1, 3};
        int target = 5;
        System.out.println(search(nums, target));
    }

    static int search(int[] nums, int target) {
        int start = 0, end = nums.length - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[start] <= nums[mid]) {
                if (target >= nums[start] && target <= nums[mid]) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            } else {
                if (target >= nums[mid] && target <= nums[end]) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            }
        }
        return -1;
    }
}
```

## How It Works

1. The algorithm uses binary search to locate the target element.
2. At each step, it determines whether the target lies in the sorted portion of the array or the rotated portion.
3. Based on this, it adjusts the search range (start and end indices).

## Complexity Analysis

- **Time Complexity:** O(log n) - Binary search is used.
- **Space Complexity:** O(1) - No additional space is used.

