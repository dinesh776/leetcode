
# Median of Two Sorted Arrays

**Problem Name**: Median of Two Sorted Arrays  
**Problem Link**: [Median of Two Sorted Arrays](https://leetcode.com/problems/median-of-two-sorted-arrays/submissions/1468252558/)

## Problem Description

Given two sorted arrays `nums1` and `nums2` of size `m` and `n` respectively, return the median of the two sorted arrays. The overall run time complexity should be `O(log (m+n))`.

### Example

#### Input:
```java[]
nums1 = [1, 2]
nums2 = [3, 4]
```

#### Output:
```java[]
2.5
```

#### Explanation:
The combined sorted array is `[1, 2, 3, 4]`. The median is `(2 + 3)/2 = 2.5`.

## Solution

This solution uses binary search on the smaller array to partition both arrays such that the left half contains the smaller elements and the right half contains the larger elements. By ensuring this partitioning, the median can be computed from the maximum of the left half and the minimum of the right half.

### Code Example

```java[]
public class MedianOfTwoSortedArrays {
    public static void main(String[] args) {
        int[] nums1 = {1, 2}, nums2 = {3, 4};
        System.out.println(findMedianSortedArrays(nums1, nums2));
    }
    static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n1 = nums1.length, n2 = nums2.length;
        if (n1 > n2) {
            return findMedianSortedArrays(nums2, nums1);
        }
        int n = n1 + n2;
        int start = 0, end = n1;
        int left = (n1 + n2 + 1) / 2;
        while (start <= end) {
            int mid1 = (start + end) / 2;
            int mid2 = left - mid1;
            int l1 = Integer.MIN_VALUE, l2 = Integer.MIN_VALUE;
            int r1 = Integer.MAX_VALUE, r2 = Integer.MAX_VALUE;
            if (mid1 < n1) {
                r1 = nums1[mid1];
            }
            if (mid2 < n2) {
                r2 = nums2[mid2];
            }
            if (mid1 - 1 >= 0) {
                l1 = nums1[mid1 - 1];
            }
            if (mid2 - 1 >= 0) {
                l2 = nums2[mid2 - 1];
            }
            if (l1 <= r2 && l2 <= r1) {
                if (n % 2 == 1) {
                    return Math.max(l1, l2);
                }
                return (double)(Math.max(l1, l2) + Math.min(r1, r2)) / 2.0;
            } else if (l1 > r2) {
                end = mid1 - 1;
            } else {
                start = mid1 + 1;
            }
        }
        return 0.0;
    }
}
```

## How It Works

1. Check the smaller array to partition both arrays using binary search.
2. Adjust the partition indices `mid1` and `mid2` such that elements on the left are smaller than elements on the right.
3. Compute the median based on the size (odd or even) of the combined array.

## Complexity Analysis

- **Time Complexity**: `O(log(min(m, n)))`, where `m` and `n` are the sizes of the two arrays.
- **Space Complexity**: `O(1)`.
