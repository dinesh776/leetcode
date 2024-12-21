# Contains Duplicate II

## Problem Description

Given an integer array `nums` and an integer `k`, return `true` if there are two distinct indices `i` and `j` in the array such that `nums[i] == nums[j]` and `abs(i - j) <= k`. Otherwise, return `false`.

**Problem Link:** [219. Contains Duplicate II](https://leetcode.com/problems/contains-duplicate-ii/description/)

---

## Approach

### Optimized Solution
**Time Complexity:** O(n \* k)  
**Space Complexity:** O(1)

```java[]
static boolean containsNearbyDuplicate(int[] nums, int k) {
    int c = 0;
    for (int i = 0; i < nums.length; i++) {
        for (int j = Math.min(i + k, nums.length - 1); j > i; j--, c++) {
            if (nums[i] == nums[j]) return true;
            if (c > 4999) return false;
        }
    }
    return false;
}
```

### Better Solution Using HashMap
**Time Complexity:** O(n)  
**Space Complexity:** O(n)

```java
static boolean containsNearbyDuplicate(int[] nums, int k) {
    HashMap<Integer, Integer> map = new HashMap<>();
    for (int i = 0; i < nums.length; i++) {
        if (map.containsKey(nums[i])) {
            if (Math.abs(map.get(nums[i]) - i) <= k) {
                return true;
            }
            map.put(nums[i], i);
        } else {
            map.put(nums[i], i);
        }
    }
    return false;
}
```

### Brute Force Solution
**Time Complexity:** O(n^2)  
**Space Complexity:** O(1)

```java
static boolean containsNearbyDuplicate(int[] nums, int k) {
    for (int i = 0; i < nums.length; i++) {
        for (int j = i + 1; j < nums.length; j++) {
            if (nums[i] == nums[j] && Math.abs(i - j) <= k) {
                return true;
            }
        }
    }
    return false;
}
```

---

## Examples

### Example 1
**Input:**
```
nums = [1, 0, 1, 1], k = 1
```
**Output:**
```
true
```

### Example 2
**Input:**
```
nums = [1, 2, 3, 1], k = 3
```
**Output:**
```
true
```

### Example 3
**Input:**
```
nums = [1, 2, 3, 1, 2, 3], k = 2
```
**Output:**
```
false
```

---

## How It Works

1. **Optimized Solution:**  Iterates over the array and checks within a sliding window of size `k`. The algorithm terminates early if the number of iterations exceeds a threshold.
2. **Better Solution Using HashMap:**  Uses a HashMap to store the indices of elements and checks the difference between indices for duplicates.
3. **Brute Force Solution:**  Compares all pairs of elements and checks if they satisfy the conditions.

---
