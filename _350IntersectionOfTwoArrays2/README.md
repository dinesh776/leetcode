# Intersection of Two Arrays II

This program finds the intersection of two arrays, allowing for duplicate elements. It implements a solution to the [LeetCode Problem 350 - Intersection of Two Arrays II](https://leetcode.com/problems/intersection-of-two-arrays-ii/description/).

---

## Problem Description

Given two integer arrays `nums1` and `nums2`, return an array of their intersection. Each element in the result must appear as many times as it shows in both arrays, and you may return the result in any order.

### Example:

#### Input:
```plaintext
nums1 = [1,2,2,1], nums2 = [2,2]
```

#### Output:
```plaintext
[2,2]
```

### Constraints:
- `1 <= nums1.length, nums2.length <= 1000`
- `0 <= nums1[i], nums2[i] <= 1000`

---

## Implementation

### Code:

```java[]
import java.util.Arrays;

public class IntersectionOfTwoArrays2 {
    public static void main(String[] args) {
        int[] nums1 = {1,2,2,1};
        int[] nums2 = {2,2};
        System.out.println(Arrays.toString(intersect(nums1, nums2)));
    }

    static int[] intersect(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int n = nums1.length, m = nums2.length;
        int[] result = new int[n + m];
        int i = 0, j = 0, k = 0;

        while (i < n && j < m) {
            if (nums1[i] == nums2[j]) {
                result[k++] = nums1[i];
                i++;
                j++;
            } else if (nums1[i] < nums2[j]) {
                i++;
            } else {
                j++;
            }
        }

        return Arrays.copyOf(result, k);
    }
}
```

---

## How It Works

1. **Sort Both Arrays**:
    - The input arrays are sorted to enable efficient comparison using two pointers.

2. **Two-Pointer Technique**:
    - Initialize two pointers (`i` for `nums1` and `j` for `nums2`).
    - Compare elements at the current indices of both arrays:
        - If they match, add the element to the result and increment both pointers.
        - If the element in `nums1` is smaller, increment `i`.
        - If the element in `nums2` is smaller, increment `j`.

3. **Result Array**:
    - Use a temporary array `result` to store the intersection elements.
    - Return the compacted array using `Arrays.copyOf`.

---

## Complexity Analysis

### Time Complexity:
- Sorting both arrays: `O(n log n + m log m)`
- Single traversal of both arrays: `O(n + m)`
- Total: `O(n log n + m log m)`

### Space Complexity:
- Result array: `O(min(n, m))`
- Sorting uses in-place memory for most Java sort implementations.

---

## Usage

1. Compile and run the program in a Java environment.
2. Modify the input arrays `nums1` and `nums2` in the `main` method to test with different inputs.

---

This program provides a simple yet efficient solution for finding the intersection of two arrays while considering duplicate elements.
