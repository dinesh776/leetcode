# Sqrt(x)

This repository contains a solution to the LeetCode problem "Sqrt(x)".

## Problem Description

**Problem Statement:**
Given a non-negative integer `x`, compute and return the square root of `x`. Since the return type is an integer, the decimal digits are truncated, and only the integer part of the result is returned.

**Link to the Problem:** [Sqrt(x) - LeetCode](https://leetcode.com/problems/sqrtx/description/)

## Solution
The solution involves using binary search to efficiently calculate the square root of `x`.

### Code Implementation
```java[]
public class sqrtOfX {
    public static void main(String[] args) {
        int x = 8;
        System.out.println(mySqrt(x));
    }

    public static int mySqrt(int x) {
        if (x == 0 || x == 1) {
            return x;
        }
        int s = 1, e = x, r = 0;
        while (s <= e) {
            int mid = s + (e - s) / 2;
            long m = (long) mid * mid;
            if (m == x) {
                return mid;
            } else if (m < x) {
                r = mid;
                s = mid + 1;
            } else {
                e = mid - 1;
            }
        }
        return r;
    }
}
```

### Algorithm Explanation
1. **Base Cases:**
    - If `x` is 0 or 1, return `x` directly as its square root is the number itself.

2. **Binary Search:**
    - Initialize `s` (start) to 1 and `e` (end) to `x`.
    - Perform binary search within this range to find the integer square root.

3. **Comparison:**
    - Calculate the square of the midpoint (`mid`).
    - If `mid * mid == x`, return `mid`.
    - If `mid * mid < x`, store `mid` as a potential answer and move to the right half.
    - Otherwise, move to the left half.

4. **Return the Result:**
    - After the loop, return the stored value `r` which holds the integer square root of `x`.

## Complexity Analysis

- **Time Complexity:**
    - `O(log x)` - Binary search reduces the search space by half in each iteration.

- **Space Complexity:**
    - `O(1)` - The solution uses constant space.

## Example

### Input
```java[]
int x = 8;
```

### Output
```java[]
2
```

### Explanation
The square root of 8 is approximately 2.828, and truncating the decimal part gives `2`.

## How It Works
1. Start with the range `[1, x]`.
2. Calculate the midpoint and check if its square equals `x`.
3. Narrow down the range based on whether the square of the midpoint is less than or greater than `x`.
4. Return the largest integer whose square is less than or equal to `x`.

---

Feel free to clone the repository and test with different inputs!
