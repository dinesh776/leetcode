
# Kth Missing Positive Number

## Problem Description

**Leetcode Problem:** [1539. Kth Missing Positive Number](https://leetcode.com/problems/kth-missing-positive-number/description/)

Given an array `arr` of positive integers sorted in a strictly increasing order, and an integer `k`, return the `k`th positive integer that is missing from this sequence.

---

## Example

### Input:
```java[]
arr = {1, 3};
k = 1;
```

### Output:
```java[]
2
```

---

## Solution

The solution uses a binary search approach to efficiently find the `k`th missing positive number. The algorithm calculates how many numbers are missing at a given index and adjusts the search range accordingly.

### Code:
```java[]
public class KthMissingElement {
    public static void main(String[] args) {
        int[] arr = {1, 3};
        int k = 1;
        System.out.println(findKthPositive(arr, k));
    }

    static int findKthPositive(int[] arr, int k) {
        int n = arr.length;
        int start = 0, end = n - 1;
        if (k < arr[0]) {
            return k;
        }
        while (start <= end) {
            int mid = start + (end - start) / 2;
            int temp = arr[mid] - (mid + 1);
            if (temp < k) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return arr[end] + (k - (arr[end] - (end + 1)));
    }
}
```

---

## Complexity Analysis

- **Time Complexity:** `O(log n)`  
  The binary search reduces the search space by half in each iteration.

- **Space Complexity:** `O(1)`  
  The algorithm uses a constant amount of extra space.

---

## How It Works

1. **Initialization:** Set `start` and `end` pointers to the bounds of the array.
2. **Binary Search:** At each step:
    - Calculate the number of missing numbers up to the current middle index (`temp`).
    - Adjust the search bounds based on the comparison of `temp` with `k`.
3. **Result Calculation:** After exiting the loop, compute the `k`th missing number using the value at `arr[end]`.

---

## Usage

Compile and run the program to test with different inputs:
```bash[]
javac KthMissingElement.java
java KthMissingElement
```

---

