# Duplicate Zeros

This repository contains a solution to the LeetCode problem [1089. Duplicate Zeros](https://leetcode.com/problems/duplicate-zeros/), implemented in Java.

## Problem Description

You are given an integer array `arr`, and your task is to duplicate each occurrence of zero, shifting the remaining elements to the right. The modification is performed in-place, and elements beyond the array length are not written.

### Example

**Input:**
- ```java
  arr = [1, 0, 2, 3, 0, 4, 5, 0]

# Set Mismatch

This repository contains a solution to the LeetCode problem [Set Mismatch](https://leetcode.com/problems/set-mismatch/), implemented in Java.

## Problem Description

You are given a set of integers `nums` which contains numbers from `1` to `n`. However, there is exactly one duplicate number and one missing number. Your task is to find the duplicate number and the missing number.

### Example

**Input:**

- ```java
  nums = [1, 2, 2, 4]


**Output:**
-  ```java
    [1, 0, 0, 2, 3, 0, 0, 4]

## Explanation

The solution duplicates each zero in the array and shifts the elements accordingly. If a zero is duplicated, the next element gets overwritten. The array is modified in-place without using additional memory for large arrays.

## Solution

The solution first clones the original array into a temporary array, then iterates through the temporary array and modifies the original array. Each zero encountered in the array is duplicated (by shifting elements), ensuring in-place modification.

## Code Example

- ```java
    import java.util.Arrays;

    public class DuplicateZeros {
    public static void main(String[] args) {
    int[] arr = {1, 0, 2, 3, 0, 4, 5, 0};
    duplicateZeros(arr);
    System.out.println(Arrays.toString(arr));
    }

    static void duplicateZeros(int[] arr) {
        int n = arr.length, j = 0;
        if (n == 1) return;
        
        int[] temp = arr.clone();
        for (int i = 0; i < n; i++) {
            arr[i] = temp[j];
            if (arr[i] == 0 && i < n - 1) {
                arr[i + 1] = 0;
                i++;
            }
            j++;
        }
    }
    }


## How it Works

1. **Clone the Array:** First, we clone the original array into a temporary array to avoid affecting the original values during the iteration.
2. **Iterate Through the Array:** We loop through the temporary array and copy the elements to the original array.
3. **Duplicate Zeros:** When we encounter a zero, we place an additional zero in the next position (if it's within bounds), effectively duplicating it.

## How to Use

To run the solution, compile and execute the `DuplicateZeros` class in your Java environment:

- ```bash
  javac DuplicateZeros.java
  java DuplicateZeros

This will output the modified array after duplicating zeros.

## Complexity Analysis

- **Time Complexity:** - O(n), where n is the length of the array. We need to iterate through the array once.
- **Space Complexity:** - O(n), due to the cloned temporary array that holds a copy of the input.