
# Merge Sorted Array

This repository contains a Java solution to the LeetCode problem [Merge Sorted Array](https://leetcode.com/problems/merge-sorted-array/description/).

## Problem Description

You are given two integer arrays `nums1` and `nums2`, sorted in **non-decreasing order**, and two integers `m` and `n`, representing the number of elements in `nums1` and `nums2`, respectively.

The task is to merge `nums2` into `nums1` as one sorted array. The merged array should also be sorted in **non-decreasing order**.

- Modify `nums1` in-place to contain the merged array.

### Example

**Input:**
```java[]
int[] nums1 = {1,2,3,0,0,0}, nums2 = {2,5,6};
int m = 3, n = 3;
```

**Output:**
```java[]
[1,2,2,3,5,6]
```

**Explanation:**
The first three elements of `nums1` represent the initial elements, and the rest are zeroes to accommodate elements of `nums2`. The merged result is `[1,2,2,3,5,6]`.

## Solution

### Optimal Solution

The optimal solution uses two pointers and merges the arrays starting from the end to avoid overwriting elements. This approach runs in **O(m + n)** time complexity and uses **O(1)** space.

```java[]
static void merge(int[] nums1, int m, int[] nums2, int n) {
    int i = m - 1, j = n - 1, k = m + n - 1;
    while (i >= 0 && j >= 0) {
        if (nums1[i] > nums2[j]) {
            nums1[k] = nums1[i];
            i--;
        } else {
            nums1[k] = nums2[j];
            j--;
        }
        k--;
    }
    while (j >= 0) {
        nums1[k] = nums2[j];
        k--;
        j--;
    }
}
```

### Better Solution

This approach uses an auxiliary array to store the result temporarily. The time complexity is **O(m + n)**, but it requires additional space of **O(m + n)**.

```java[]
static void mergeBetter(int[] nums1, int m, int[] nums2, int n) {
    int[] res = new int[m + n];
    int i = 0, j = 0, ind = 0;
    while (i < m && j < n) {
        if (nums1[i] <= nums2[j]) {
            res[ind] = nums1[i];
            i++;
        } else {
            res[ind] = nums2[j];
            j++;
        }
        ind++;
    }
    while (i < m) {
        res[ind++] = nums1[i++];
    }
    while (j < n) {
        res[ind++] = nums2[j++];
    }
    for (i = 0; i < (m + n); i++) {
        nums1[i] = res[i];
    }
}
```

### Brute Force Solution

The brute force approach concatenates both arrays and sorts the result. It runs in **O((m + n) * log(m + n))** time but uses constant space.

```java[]
static void mergeBruteForce(int[] nums1, int m, int[] nums2, int n) {
    for (int i = 0; i < n; i++) {
        nums1[m + i] = nums2[i];
    }
    Arrays.sort(nums1);
}
```

## How It Works

1. **Optimal Solution:**
    - Starts merging from the end of both arrays to avoid overwriting elements in `nums1`.
    - Handles remaining elements from `nums2` if any.

2. **Better Solution:**
    - Merges into a new array and then copies the result back to `nums1`.

3. **Brute Force:**
    - Appends elements of `nums2` to `nums1` and sorts the result.

## Complexity Analysis

- **Optimal Solution:**
    - Time Complexity: O(m + n)
    - Space Complexity: O(1)

- **Better Solution:**
    - Time Complexity: O(m + n)
    - Space Complexity: O(m + n)

- **Brute Force Solution:**
    - Time Complexity: O((m + n) * log(m + n))
    - Space Complexity: O(1)

## How to Use

To run the solution, compile and execute the `MergeSortedArrays` class in your Java environment:

```bash[]
javac MergeSortedArrays.java
java MergeSortedArrays
```
This will print the merged and sorted array.

## Example Usage

**Input:**
```java[]
int[] nums1 = {0}, nums2 = {1};
int m = 0, n = 1;
```

**Output:**
```java[]
[1]
```
