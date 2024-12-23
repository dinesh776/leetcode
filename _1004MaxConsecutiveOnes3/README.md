# Max Consecutive Ones III

## Problem Description

- **Problem Name**: Max Consecutive Ones III
- **Problem Link**: [Max Consecutive Ones III](https://leetcode.com/problems/max-consecutive-ones-iii/description/)

You are given a binary array `nums` and an integer `k`. You can flip at most `k` 0's to 1's. Return the length of the longest (contiguous) subarray that contains only 1's after flipping at most `k` 0's.

---

## Code Implementation

```java[]
public class MaxConsecutiveOnes {
    public static void main(String[] args) {
        int[] nums={1,1,1,0,0,0,1,1,1,1,0};
        int k=2;
        System.out.println(longestOnes(nums,k));
    }
    static int longestOnes(int[] nums, int k) {
        int max_count = 0;
        int count=0,kCount=0;
        int l=0,r=0;
        while(r<nums.length){
            if(nums[r]==0){
                kCount++;
            }
            while(kCount>k){
                if(nums[l]==0&&kCount>0){
                    kCount--;
                }
                l++;
                count--;
            }
            count++;
            max_count=Math.max(max_count,count);
            r++;
        }
        return max_count;
    }
}
```

---

## How It Works

This implementation uses a sliding window technique to find the maximum length of contiguous 1's after flipping at most `k` 0's:

1. **Initialization**:
    - `l` (left pointer) and `r` (right pointer) both start at 0.
    - `kCount` keeps track of the number of 0's in the current window.
    - `count` measures the size of the current window.
    - `max_count` records the maximum length encountered so far.

2. **Expand the Right Pointer**:
    - Traverse the array with the `r` pointer.
    - If `nums[r] == 0`, increment `kCount`.

3. **Shrink the Left Pointer**:
    - If `kCount > k`, increment the `l` pointer until `kCount <= k`.
    - Adjust `count` accordingly.

4. **Update Maximum Length**:
    - After expanding and shrinking, update `max_count` to the maximum of its current value and `count`.

5. **Return Result**:
    - At the end, return `max_count` as the longest subarray of 1's possible after flipping at most `k` 0's.

---

## Example

### Input
```text
nums = [1,1,1,0,0,0,1,1,1,1,0]
k = 2
```

### Output
```text
6
```

### Explanation
By flipping the 0's at indices `3` and `4`, we get the subarray `[1,1,1,1,1,1]` of length 6.

---

## Complexity Analysis

- **Time Complexity**: `O(n)`
    - Each element is visited at most twice (once by `r` and once by `l`).

- **Space Complexity**: `O(1)`
    - Uses constant extra space.

---

## Edge Cases

1. **All 1's**:
    - Input: `nums = [1,1,1,1], k = 2`
    - Output: `4`

2. **All 0's**:
    - Input: `nums = [0,0,0,0], k = 1`
    - Output: `1`

3. **Empty Array**:
    - Input: `nums = [], k = 2`
    - Output: `0`

---

## Summary
This solution efficiently calculates the maximum length of contiguous 1's after flipping at most `k` 0's using the sliding window approach, ensuring optimal performance with minimal space usage.
