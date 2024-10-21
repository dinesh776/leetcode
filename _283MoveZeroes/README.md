# Move Zeroes

This repository contains a solution to the LeetCode problem [Move Zeroes](https://leetcode.com/problems/move-zeroes/), implemented in Java.

## Problem Description

Given an integer array `nums`, move all the zeroes to the end of the array while maintaining the relative order of the non-zero elements. The operation must be performed in place without making a copy of the array.

### Example

**Input:**

- ```java
  nums = [0, 1, 0, 3, 12]

**Output:**
-  ```java
    [1, 3, 12, 0, 0]

## Explanation

The solution moves all the zeroes to the end of the array while keeping the non-zero elements in their original order. The function performs the operation in place, meaning that the input array is modified directly without using extra memory.

## Solution

The solution uses a two-pointer approach where one pointer (i) tracks the position of the last non-zero element, and the other pointer (j) iterates through the array.

## Code Example

- ```java
  import java.util.Arrays;

   public class MoveZeroes {
      public static void main(String[] args) {
            int[] nums={0,1,0,3,12};
            moveZeroes(nums);
            System.out.println(Arrays.toString(nums));
         }
      static void moveZeroes(int[] nums) {
         int i=0,j=1,n=nums.length;
         while(i<n-1&&j<n){
            if(nums[i]==0){
               if(nums[j]!=0){
                  int temp=nums[j];
                  nums[j]=nums[i];
                  nums[i]=temp;
                  i++;
                  j++;
               }
               else{
                  j++;
               }
            }
            else{
               i++;
               j++;
            }
         }
      }
   }

## How it Works

1. **Initialize Two Pointers:** `i` starts at the beginning, and `j` starts one step ahead of `i`.
2. **Iterate Through the Array:** The algorithm moves non-zero elements towards the front while pushing zeroes towards the back by swapping elements.
3. **In-place Modification:** No additional arrays are used, and the input array is modified directly.

## How to Use

To run the solution, compile and execute the `MoveZeroes` class in your Java environment:

- ```bash
  javac MoveZeroes.java
  java MoveZeroes

This will output the modified array with zeroes moved to the end.

## Complexity Analysis

- **Time Complexity:** - O(n), where n is the length of the array. Each element is processed once.
- **Space Complexity:** - O(1), as the solution modifies the array in place without using extra space.