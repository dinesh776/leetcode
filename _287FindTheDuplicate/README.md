
# Find the Duplicate Number

This repository contains a solution to the LeetCode problem [Find the Duplicate Number](https://leetcode.com/problems/find-the-duplicate-number/description/), implemented in Java.

## Problem Description

The **Find the Duplicate Number** problem requires finding the duplicate number in an array `nums` of size `n + 1` where the numbers are in the range `[1, n]`. There is only one duplicate number, but it can appear more than once.

### Example

**Input:**
```java[]
int[] nums = {1,3,4,2,2};
```

**Output:**
```java[]
2
```

**Explanation:**  
The number `2` is the duplicate in the array.

## Solution

This solution uses Floyd's Tortoise and Hare (Cycle Detection) algorithm to find the duplicate number. The algorithm has a **time complexity of O(n)** and **space complexity of O(1)**.

## Code Example

```java[]
package Github._287FindTheDuplicate;


public class FindTheDuplicate {
    public static void main(String[] args) {
        int[] nums = {1,3,4,2,2};
        System.out.println(findDuplicate(nums));
    }
    static int findDuplicate(int[] nums) {
        int slow = nums[0];
        int fast = nums[0];
        do {
            slow = nums[slow];
            fast = nums[nums[fast]];
        } while (slow != fast);
        fast = nums[0];
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[fast];
        }
        return slow;
    }
}
```

## How it Works

1. **Cycle Detection:**  
   The algorithm treats the array as a linked list where each value points to the index it represents. Using Floyd's Tortoise and Hare algorithm, it detects the cycle in this virtual linked list.

2. **Finding the Duplicate:**  
   After finding the meeting point of slow and fast pointers, the algorithm resets one pointer to the start and increments both until they meet. The meeting point is the duplicate number.

## How to Use

To run the solution, compile and execute the `FindTheDuplicate` class in your Java environment:

```bash[]
javac FindTheDuplicate.java
java FindTheDuplicate
```

This will output the duplicate number in the array.

## Complexity Analysis

- **Time Complexity:** O(n), as each pointer traverses the array once.
- **Space Complexity:** O(1), since no additional space is used.
