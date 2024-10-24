# Contains Duplicate

This repository contains a solution to the LeetCode problem [Contains Duplicate](https://leetcode.com/problems/contains-duplicate/), implemented in Java.

## Problem Description

Given an integer array `nums`, your task is to determine if any value appears at least twice in the array. The function should return `true` if any value appears twice, and `false` if every element is distinct.

### Example

**Input:**

- ```java
  nums = [1,1,1,3,3,4,3,2,4,2]

**Output:**
-  ```java
    true
## Explanation

In this example, the array contains multiple duplicate values such as `1`, `3`, and `4`. Since there are repeated elements, the function returns `true`.

## Solution

There are multiple ways to solve this problem:

1. **Iterative Comparison:** Compare adjacent and non-adjacent elements and check for duplicates.
2. **Hashing Approach:** Use a hash table to count occurrences of each element.

### Solution 1: Iterative Comparison

The solution compares each element with its neighbors and previous elements to detect duplicates.

### Solution 2: Using Hashing

A hash table is used to store the frequency of elements. If an element appears more than once, we return `true`.

## Code Example

- ```java
  import java.util.*;

    public class ContainsDuplicate {
        public static void main(String[] args) {
            int[] nums = {1,1,1,3,3,4,3,2,4,2};
            System.out.println(containsDuplicate(nums));
        }

    static boolean containsDuplicate(int[] nums) {
        // Iterative approach with element comparison
        for(int i = 1; i < nums.length; i++){
            if(nums[i - 1] == nums[i])
                return true;
            else if (nums[i] < nums[i - 1]){
                int temp = nums[i - 1];
                for(int j = i - 2; j >= 0; j--){
                    if(nums[i] == nums[j])
                        return true;
                }
                nums[i - 1] = nums[i];
                nums[i] = temp;
            }
        }
        return false;

        // Hashing approach (alternative)
        // Hashtable<Integer, Integer> hashtable = new Hashtable<>();
        // for(int x : nums) {
        //     hashtable.put(x, hashtable.containsKey(x) ? hashtable.get(x) + 1 : 1);
        // }
        // for(int x : nums) {
        //     if(hashtable.get(x) > 1) {
        //         return true;
        //     }
        // }
        // return false;
    }
    }


## How it Works

- **Iterative Comparison:** The solution iterates through the array, comparing each element with its neighbors and adjusting positions when needed to check for duplicates.
- **Hashing Approach:** An alternative solution uses a hash table to store frequencies. If any value appears more than once, the function returns `true`.

## How to Use

To run the solution, compile and execute the `ContainsDuplicate` class in your Java environment:

- ```bash
  javac ContainsDuplicate.java
  java ContainsDuplicate
This will output whether the array contains duplicates or not.

## Complexity Analysis

- **Time Complexity:**
    - Iterative approach: O(n²) in the worst case, where `n` is the length of the array.
    - Hashing approach: O(n), as we only traverse the array once and store elements in a hash table.

- **Space Complexity:**
    - Iterative approach: O(1), since no extra space is used.
    - Hashing approach: O(n), due to the hash table storing the elements.
