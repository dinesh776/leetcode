
# Find Minimum in Rotated Sorted Array

## Problem Description
Given a rotated sorted array, find the minimum element.  
The array is initially sorted in ascending order, and then some unknown number of elements from the start are moved to the end, forming a rotated array.  
You must find the minimum element without restoring the array to its original order.

**Problem Link:** [153. Find Minimum in Rotated Sorted Array](https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/description/)

---

## Example
### Input:
`nums = [5, 1, 2, 3, 4]`

### Output:
`1`

---

## Solution

### Approach
- Use a binary search method to find the minimum element efficiently.
- The approach involves:
    1. Checking if the current segment of the array is sorted.
    2. If sorted, the minimum element is at the start.
    3. Otherwise, use binary search logic to narrow down to the unsorted segment where the minimum lies.

### Complexity
- **Time Complexity:** O(log n), as we use binary search.
- **Space Complexity:** O(1), as the solution is in-place and does not use additional space.

---

## Code Example
```java[]
public class FindMinimumInRotatedSortedArray {
    public static void main(String[] args) {
        int[] nums = {5, 1, 2, 3, 4};
        System.out.println(findMin(nums));
    }
    static int findMin(int[] nums) {
        int min = Integer.MAX_VALUE;
        int start = 0, end = nums.length - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (nums[start] <= nums[end]) {
                min = Math.min(min, nums[start]);
                break;
            }
            if (nums[start] <= nums[mid]) {
                min = Math.min(min, nums[start]);
                start = mid + 1;
            } else {
                min = Math.min(min, nums[mid]);
                end = mid - 1;
            }
        }
        return min;
    }
}
```

---

## How It Works
1. Start with the entire array range.
2. Check if the array section is sorted:
    - If yes, the start of this section contains the minimum.
3. Else, adjust the `start` and `end` pointers based on the middle element to continue searching in the unsorted section.

---

## Usage
- This approach is used in scenarios where arrays are rotated or shifted, and we need to find the minimum value efficiently.
- Common in searching problems in rotated datasets.

---

## Complexity Analysis
| Complexity | Value |
|------------|-------|
| Time       | O(log n) |
| Space      | O(1) |
