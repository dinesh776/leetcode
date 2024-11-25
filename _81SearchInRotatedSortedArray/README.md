
# Search in Rotated Sorted Array II

## Problem Description

You are given an integer array `nums` sorted in ascending order (with duplicates) and an integer `target`. Suppose `nums` is rotated at some pivot unknown to you beforehand (i.e., `[0,1,2,4,5,6,7]` might become `[4,5,6,7,0,1,2]`).

This problem requires you to determine if the target exists in the array. If it exists, return `true`. Otherwise, return `false`.

### LeetCode Link
[Search in Rotated Sorted Array II](https://leetcode.com/problems/search-in-rotated-sorted-array-ii/description/)

---

## Implementation

```java[]
public class SearchInRotatedSortedArray2 {
    public static void main(String[] args) {
        int[] nums = {2, 5, 6, 0, 0, 1, 2};
        int target = 0;
        System.out.println(search(nums, target));
    }
    static boolean search(int[] nums, int target) {
        int start = 0, end = nums.length - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] == target) {
                return true;
            } else if (nums[start] == nums[mid] && nums[mid] == nums[end]) {
                start = start + 1;
                end = end - 1;
            } else if (nums[start] <= nums[mid]) {
                if (target >= nums[start] && target <= nums[mid]) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            } else {
                if (target >= nums[mid] && target <= nums[end]) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            }
        }
        return false;
    }
}
```

---

## How It Works

1. **Binary Search with Pivot Consideration**:
    - The algorithm uses a modified binary search approach, taking into account the rotation in the sorted array.
2. **Handling Duplicates**:
    - When duplicates are encountered (`nums[start] == nums[mid] == nums[end]`), the search bounds are adjusted slightly by incrementing the `start` and decrementing the `end`.
3. **Search Condition**:
    - The target is checked against the current mid-point, and depending on whether the left or right segment is sorted, the search space is adjusted.

---

## Complexity Analysis

- **Time Complexity**: O(n) in the worst case due to duplicates; O(log n) in the average case.
- **Space Complexity**: O(1) as no additional space is used.

---

## Example

**Input**:
```text[]
nums = [2, 5, 6, 0, 0, 1, 2], target = 0
```

**Output**:
```text[]
true
```

**Input**:
```text[]
nums = [2, 5, 6, 0, 0, 1, 2], target = 3
```

**Output**:
```text[]
false
```
