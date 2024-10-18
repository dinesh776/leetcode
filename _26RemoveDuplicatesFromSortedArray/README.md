# Remove Duplicates from Sorted Array

This repository contains a solution to the LeetCode problem [Remove Duplicates from Sorted Array](https://leetcode.com/problems/remove-duplicates-from-sorted-array/description/), implemented in Java.

## Problem Description

Given a sorted array `nums`, remove the duplicates in-place such that each element appears only once and returns the new length. The order of elements in the modified array should remain sorted, but the values beyond the new length don't matter.

### Example

**Input:**

- ```java
  nums = [0, 0, 1, 1, 1, 2, 2, 3, 3, 4]

**Output:**
-  ```java
    5

## Explanation
The modified array will look like [0, 1, 2, 3, 4, _, _, _, _, _] (values beyond the new length can be ignored).

## Solution
The solution uses a two-pointer approach to iterate through the array and remove duplicates by swapping elements when necessary.

## Code Example

- ```java
    import java.util.Arrays;

    public class RemoveDuplicatesFromSortedArray {
        public static void main(String[] args) {
            int[] arr = new int[]{0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
            System.out.println(Arrays.toString(arr));
            System.out.println(removeDuplicates(arr));
            System.out.println(Arrays.toString(arr));
        }

        static int removeDuplicates(int[] nums) {
            int i = 0, r = 1, n = nums.length;
            while (i < n && r < n) {
                if (nums[i] != nums[r]) {
                    int temp = nums[i + 1];
                    nums[i + 1] = nums[r];
                    nums[r] = temp;
                    i++;
                }
                r++;
            }
            return i + 1;
        }
    }



## How it Works

1. **Initialize Pointers:** Two pointers are used, i points to the current element and r checks for the next unique element.
2. **Iterate Through the Array:** The algorithm checks each element:
    - If the current and next elements differ, the next unique element is placed in its correct position.
    - The process repeats until the entire array is checked.
3. **Return the New Length:** The function returns the new length, which is the count of unique elements.
## How to Use

To run the solution, simply compile and execute the `RemoveDuplicatesFromSortedArray` class in your Java environment.
- ```bash
  javac RemoveDuplicatesFromSortedArray.java
  java RemoveDuplicatesFromSortedArray

This will output the original array, the new length after duplicates are removed, and the modified array.

## Complexity Analysis

- **Time Complexity:** -  O(n), where n is the length of the array. Each element is processed once.
- **Space Complexity:** - O(1), as the solution modifies the array in place without using extra space.