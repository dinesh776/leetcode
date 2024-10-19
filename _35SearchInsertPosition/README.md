# Search Insert Position

This repository contains a solution to the LeetCode problem [Search Insert Position](https://leetcode.com/problems/search-insert-position/description/), implemented in Java.

## Problem Description

Given a sorted array of distinct integers and a target value, return the index if the target is found. If not, return the index where it would be if it were inserted in order.

You must write an algorithm with O(log n) runtime complexity.

### Example

**Input:**

- ```java
  nums = [1,3,5,6], target = 0

**Output:**
- ```java
  0

## Explanation

The target value 0 is not found in the array. It would be inserted at the 0th index.

## Solution

The solution uses a binary search approach to find the correct insertion point for the target value in a sorted array.

## Code Example

- ```java
    public class SearchInsertPosition {
        public static void main(String[] args) {
            int[] nums = {1,3,5,6};
            int target = 0;
            System.out.println(searchInsert(nums, target)); // Output: 0
        }

        static int searchInsert(int[] nums, int target) {
            int start = 0, end = nums.length - 1, mid = start + (end - start) / 2;
            while (start <= end) {
                mid = start + (end - start) / 2;
                if (nums[mid] == target) {
                    return mid;
                }
                if (target > nums[mid]) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            }
            return start;
        }
    }


## How it Works

1. **Binary Search:** The algorithm performs binary search by calculating the middle index of the current range of elements in the array.
2. **Check Target:** If the target value is equal to the middle element, return the index. If the target is greater than the middle element, search the right half of the array. Otherwise, search the left half.
3. **Insert Position:** If the target is not found, the method returns the index where the target would be inserted.

## How to Use

To run the solution, simply compile and execute the `SearchInsertPosition` class in your Java environment.
- ```bash
  javac SearchInsertPosition.java
  java SearchInsertPosition

This will output the correct index where the target should be inserted in the array.

## Complexity Analysis

- **Time Complexity:** O(log n), where n is the length of the input array, due to binary search.
- **Space Complexity:** O(1), as no additional space is used except for a few variables.
