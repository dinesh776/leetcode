
# Split Array Largest Sum

## Problem Description

This program solves the problem **Split Array Largest Sum** as described on [LeetCode](https://leetcode.com/problems/split-array-largest-sum/description/).

### Problem Statement

Given an array `nums` and an integer `k`, split the array into `k` subarrays such that the largest sum among the subarrays is minimized. Return the minimized largest sum.

---

## Code Example

```java[]
public class SplitArrayLargeSum {
    public static void main(String[] args) {
        int k=2;
        int[] nums={1,2,3,4,5};
        System.out.println(splitArray(nums,k));
    }
    static int splitArray(int[] nums, int k) {
        int[] temp=findMaxSum(nums);
        int start=temp[0],end=temp[1];
        while(start<=end){
            int mid=(start+end)/2;
            int res=no_of_splits(nums,mid);
            if(res>k){
                start=mid+1;
            }
            else{
                end=mid-1;
            }
        }
        return start;
    }
    static int no_of_splits(int[] nums, int mid) {
        int sum=0,ct=0;
        for(int i=0;i<nums.length;i++){
            sum+=nums[i];
            if(sum>mid){
                ct++;
                sum=nums[i];
            }
        }
        if(sum<=mid){
            ct++;
        }
        return ct;
    }
    static int[] findMaxSum(int[] nums) {
        int sum=0,max=Integer.MIN_VALUE;
        for(int i=0;i<nums.length;i++){
            sum+=nums[i];
            max=Math.max(max,nums[i]);
        }
        return new int[]{max,sum};
    }
}
```

---

## How It Works

1. **Binary Search**:
    - The solution uses binary search to find the minimal largest sum.
    - The range for binary search is determined by the maximum element (`max`) and the sum of the elements (`sum`) in the array.

2. **Splitting the Array**:
    - The `no_of_splits` function determines how many subarrays are required for a given maximum sum.

3. **Minimizing Largest Sum**:
    - By adjusting the binary search range, the program finds the smallest value for which the array can be split into `k` or fewer subarrays.

---

## Example

### Input:
```plaintext[]
nums = [1, 2, 3, 4, 5]
k = 2
```

### Output:
```plaintext[]
9
```

### Explanation:
- The array can be split into `[1, 2, 3]` and `[4, 5]` with the largest sum being 9.

---

## Usage

To use this program, simply execute the `SplitArrayLargeSum` class in a Java IDE or compile and run it using the command line.

---

## Complexity Analysis

- **Time Complexity**: `O(n * log(sum))`
    - `n`: Length of the array.
    - `sum`: Difference between the maximum sum and the minimum sum.
- **Space Complexity**: `O(1)`

