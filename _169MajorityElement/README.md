# Majority Element

This repository contains a solution to the LeetCode problem [Majority Element](https://leetcode.com/problems/majority-element/description/), implemented in Java.

## Problem Description

Given an array `nums` of size `n`, find the majority element. The majority element is the element that appears more than `n / 2` times. You may assume that the majority element always exists in the array.

### Example

**Input:**

- ```java
  nums = [1, 1, 2, 2, 3, 2]

**Output:**
- ```java
  2

## Explanation

The number `2` is the majority element as it appears 3 times, which is more than half the size of the array (`n / 2 = 3`).


## Solution

The solution uses the **Boyer-Moore Voting Algorithm** to find the majority element in linear time and constant space.
## Code Example

- ```java
    public class MajorityElement {
        public static void main(String[] args) {
            int[] nums = new int[]{1 , 1 , 2 , 2 , 3 , 2};
            System.out.println(majorityElement(nums));
        }
        static int majorityElement(int[] nums) {
            int e=nums[0],c=0;
            for(int i=0;i<nums.length;i++){
                if(c==0){
                    e=nums[i];
                }
                if(e==nums[i]){
                    c++;
                }
                else{
                    c--;
                }
            }
            int k=0;
            for(int i=0;i< nums.length;i++){
                if(nums[i]==e)
                    k++;
            }
            if(k>(nums.length/2)){
                return e;
            }
            return -1;
        }
    }


## How it Works

1. **Boyer-Moore Voting Algorithm:** 
    - The algorithm keeps track of a candidate element e and its count c. As we traverse the array:
      - If c is 0, we pick the current element as the new candidate e.
      - If the current element is the same as e, we increment c. Otherwise, we decrement c.
2. **Verification:** Once we have a candidate, we verify if it appears more than n / 2 times in the array.

## How to Use

To run the solution, simply compile and execute the `MajorityElement` class in your Java environment.
- ```bash
  javac MajorityElement.java
  java MajorityElement


This will output the majority element from the input array.

## Complexity Analysis

- **Time Complexity:** O(n), where n is the length of the input array. We only traverse the array twice.
- **Space Complexity:** O(1), as we use a few variables regardless of the input size.
