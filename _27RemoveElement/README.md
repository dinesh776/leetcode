# Remove Element

This repository contains a solution to the LeetCode problem [Remove Element](https://leetcode.com/problems/remove-element/description/), implemented in Java.

## Problem Description

Given an integer array `nums` and an integer `val`, you need to remove all occurrences of `val` in `nums` in place. The order of elements can be changed. It doesn't matter what you leave beyond the new length.

### Example

**Input:**

- ```java
    nums = [0, 1, 2, 2, 3, 0, 4, 2], val = 2
**Output:**
-  ```java
    5

## Explanation

After removing all occurrences of 2, the new length of the array is 5, and the modified array could be [0, 1, 4, 3, 0, _, _, _] (the actual values beyond the new length can be ignored).

## Solution

The solution uses a two-pointer approach to iterate through the array and swap elements to remove the specified value. This is done in the removeElement function.

## Code Example

- ```java
    import java.util.Arrays;
  
    static int removeElement(int[] nums, int val) {
        int r = nums.length - 1, i = 0, c = 0;
        while (i <= r) {
            if (nums[i] == val) {
                c++;
                if (nums[r] == val) {
                    r--;
                } else {
                    int temp = nums[i];
                    nums[i] = nums[r];
                    nums[r] = temp;
                    r--;
                }
            } else {
                i++;
            }
        }
        return nums.length - c;
    }
    }


## How it Works

1. **Initialize Pointers:** Two pointers are set: i at the beginning of the array and r at the end.
2. **Iterate Through the Array:** The algorithm checks each element:
   - If the element is equal to val, increment the counter c and handle the swapping.
   - If it's not equal to val, simply move to the next element.
3. **Return the New Length:** The function returns the length of the array minus the count of removed elements.
## How to Use

To run the solution, simply compile and execute the `RemoveElement` class in your Java environment.
- ```bash
  javac RemoveElement.java
  java RemoveElement

This will output the original array, the new length after removal, and the modified array.
## Complexity Analysis

- **Time Complexity:** - O(n), where n is the length of the array, since each element is processed once.
- **Space Complexity:** - O(1) because the solution modifies the array in place without using extra space.