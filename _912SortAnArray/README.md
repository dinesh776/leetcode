# Sort an Array

## Problem Description
**LeetCode Problem 912:** [Sort an Array](https://leetcode.com/problems/sort-an-array/description/)

Given an array of integers, sort the array in ascending order.

### Example
```[]
Input: [6,7,8,9,1,2,3,4,5]
Output: [1,2,3,4,5,6,7,8,9]
```

## Solution
This solution implements an **in-place merge sort** algorithm in Java to sort the given array.

### Code Example
```java[]
import java.util.Arrays;

public class SortAnArray {
    public static void main(String[] args) {
        int[] arr = {6,7,8,9,1,2,3,4,5};
        System.out.println(Arrays.toString(sortArray(arr)));
    }

    public static int[] sortArray(int[] nums) {
        mergeSortInPlace(nums, 0, nums.length - 1);
        return nums;
    }

    public static void mergeSortInPlace(int[] arr, int start, int end) {
        if (end - start == 0) {
            return;
        }
        int mid = start + (end - start) / 2;
        mergeSortInPlace(arr, start, mid);
        mergeSortInPlace(arr, mid + 1, end);
        mergeInPlace(arr, start, end, mid);
    }

    public static void mergeInPlace(int[] arr, int start, int end, int mid) {
        int[] temp = new int[end - start + 1];
        int i = start, j = mid + 1, k = 0;
        
        while (i <= mid && j <= end) {
            if (arr[i] < arr[j]) {
                temp[k++] = arr[i++];
            } else {
                temp[k++] = arr[j++];
            }
        }
        while (i <= mid) {
            temp[k++] = arr[i++];
        }
        while (j <= end) {
            temp[k++] = arr[j++];
        }
        for (int l = 0; l < temp.length; l++) {
            arr[start + l] = temp[l];
        }
    }
}
```

## How It Works
1. **Main Function:** Initializes an array and prints the sorted result.
2. **`sortArray` Method:** Calls the in-place merge sort function.
3. **`mergeSortInPlace` Method:** Recursively splits the array into halves.
4. **`mergeInPlace` Method:** Merges the sorted halves back into the original array using a temporary array.

## Complexity Analysis
- **Time Complexity:** O(n log n) — Recursive division and merging of elements.
- **Space Complexity:** O(n) — Temporary array for merging.

## Usage
Compile and run the program:
```bash[]
javac SortAnArray.java
java SortAnArray
```

This will output the sorted array in ascending order.

---
