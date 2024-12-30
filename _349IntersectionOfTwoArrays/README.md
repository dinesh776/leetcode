# Intersection of Two Arrays

## Problem Description
Given two integer arrays `nums1` and `nums2`, return an array of their intersection. Each element in the result must be unique, and you may return the result in any order.

- **Link to the problem:** [349. Intersection of Two Arrays](https://leetcode.com/problems/intersection-of-two-arrays/description/)

## Example

### Input
```java
nums1 = [4,9,5]
nums2 = [9,4,9,8,4]
```

### Output
```java
[4,9]
```

### Explanation
- The intersection of the two arrays is `[4,9]`. The order of the output can vary.

## Solution
The approach involves sorting both arrays and using two pointers to find their intersection efficiently.

### Code Implementation
```java[]
import java.util.Arrays;

public class IntersectionOfTwoArrays {
    public static void main(String[] args) {
        int[] arr1 = {4,9,5};
        int[] arr2 = {9,4,9,8,4};

        int[] result = intersection(arr1, arr2);
        System.out.println(Arrays.toString(result));
    }

    static int[] intersection(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);

        int i = 0, j = 0, k = 0;
        int[] result = new int[nums1.length];

        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] == nums2[j]) {
                if (k == 0 || result[k - 1] != nums1[i]) {
                    result[k++] = nums1[i];
                }
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

## How it Works
1. **Sorting**: Both input arrays are sorted to enable comparison.
2. **Two Pointers**: Pointers `i` and `j` traverse through `nums1` and `nums2`, respectively.
    - If `nums1[i] == nums2[j]`, the number is added to the result if it's not already present.
    - If `nums1[i] < nums2[j]`, increment `i` to move to the next element in `nums1`.
    - If `nums1[i] > nums2[j]`, increment `j` to move to the next element in `nums2`.
3. **Deduplication**: A check ensures that duplicates are not added to the result.

## Usage
To use the `intersection` method:
- Pass two integer arrays as input.
- The output will be an integer array containing the unique intersection elements.

## Edge Cases
- Both arrays are empty.
- One of the arrays is empty.
- Arrays have no intersection.
- Arrays are identical.

### Execution
1. Sort both arrays:
    - `nums1` becomes `[4,5,9]`
    - `nums2` becomes `[4,4,8,9,9]`
2. Use two pointers to find the intersection:
    - Compare `nums1[i]` and `nums2[j]`.
    - Add unique matches to the result.
3. Result: `[4,9]`.



## Complexity Analysis
- **Time Complexity**: O(n log n + m log m), where `n` and `m` are the lengths of `nums1` and `nums2`, respectively (due to sorting).
- **Space Complexity**: O(n), where `n` is the size of the smaller input array (for storing the result).
