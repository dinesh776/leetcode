# LeetCode Problem 448: Find All Numbers Disappeared in an Array

## Problem Statement
This is a solution to LeetCode's **[Find All Numbers Disappeared in an Array](https://leetcode.com/problems/find-all-numbers-disappeared-in-an-array/)** problem. The task is to find all the numbers that are missing from an array of integers `nums` where 1 ≤ a[i] ≤ n, and `n` is the length of the array.

### Problem Example:
Given the array `nums = [4,3,2,7,8,2,3,1]`, the function returns `[5,6]` because the numbers 5 and 6 are missing from the array.

## Approach

The solution uses **Cycle Sort** to place the numbers in their correct indices. After the array is sorted, we iterate through the array and identify the positions where the index does not match the number, which implies that the number corresponding to that index is missing.

### Algorithm Steps:
1. Use the **Cycle Sort** algorithm to sort the array such that the number `n` is at index `n-1`.
2. After sorting, iterate through the array and add any index + 1 where the number at that index is not equal to `index + 1`.
3. Return the list of missing numbers.

### Time Complexity:
- **Time Complexity**: O(n) because each element is moved to its correct position in the array exactly once.
- **Space Complexity**: O(1) because we only use a constant amount of extra space (excluding the output list).

## Code

```java
import java.util.*;

class FindAllMissingElements {

    public static void main(String[] args) {
        int[] nums = {4,3,2,7,8,2,3,1};
        System.out.println(findDisappearedNumbers(nums));
    }

    static List<Integer> findDisappearedNumbers(int[] nums) {
        cycle_sort(nums);
        List<Integer> list = new ArrayList<Integer>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != (i + 1)) {
                list.add(i + 1);
            }
        }
        return list;
    }
    
    static void cycle_sort(int[] nums) {
        int i = 0;
        while (i < nums.length) {
            int correctIndex = nums[i] - 1;
            if (nums[i] != nums[correctIndex]) {
                swap(nums, i, correctIndex);
            } else {
                i++;
            }
        }
    }

    static void swap(int[] nums, int first, int second) {
        int temp = nums[first];
        nums[first] = nums[second];
        nums[second] = temp;
    }
}