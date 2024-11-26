
# Single Element in a Sorted Array

## Problem Statement

This program solves the problem [540. Single Element in a Sorted Array](https://leetcode.com/problems/single-element-in-a-sorted-array/description/).  
Given a sorted array consisting of only integers where every element appears exactly twice, except for one element which appears exactly once.  
Find this single element that appears only once.

## Problem Description

- Input: A sorted array of integers.
- Output: The single element that appears only once.

Example:
```java[]
Input: nums = [3,3,7,7,10,11,11]
Output: 10
```

## Solution

This implementation uses binary search to achieve an efficient time complexity of **O(log n)**. The key insight is to leverage the sorted nature of the array and the unique element's position.

## Code

```java[]
public class SingleElementInASortedArray {
    public static void main(String[] args) {
        int[] num={3,3,7,7,10,11,11};
        System.out.println(singleNonDuplicate(num));
    }
    static int singleNonDuplicate(int[] nums) {
        int n=nums.length;
        if(n==1) return nums[0];
        if(nums[0]!=nums[1])return nums[0];
        if(nums[n-1]!=nums[n-2])return nums[n-1];
        int start=1,end=n-2;
        while(start<=end){
            int mid=start+(end-start)/2;
            if((nums[mid]!=nums[mid-1])&&nums[mid]!=nums[mid+1])return nums[mid];
            else if((mid%2==1&&nums[mid]==nums[mid-1])||(mid%2==0&&nums[mid]==nums[mid+1])){
                start=mid+1;
            }
            else {
                end=mid-1;
            }
        }
        return -1;
    }
}
```

## Complexity Analysis

- **Time Complexity**: O(log n), as we are performing a binary search.
- **Space Complexity**: O(1), as no extra space is used.

## Usage

1. Place the code in a `.java` file.
2. Compile and run the file with your preferred Java runtime environment.
3. Input the array and get the single element as output.
