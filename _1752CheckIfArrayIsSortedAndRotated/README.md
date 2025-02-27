# Check if Array Is Sorted and Rotated

## Problem Statement

**LeetCode 1752** - [Check if Array Is Sorted and Rotated](https://leetcode.com/problems/check-if-array-is-sorted-and-rotated/description/)

Given an array `nums`, check if the array was originally sorted in non-decreasing order, then rotated some number of positions (including zero). Return `true` if the array meets this condition, otherwise return `false`.

## Example

```java[]
int[] nums = {1, 2, 3};
System.out.println(check(nums)); // Output: true
```

## Solution

The solution involves finding the first instance where an element is smaller than the previous element. If found, the array is virtually rotated, and the rotated version is checked for sorted order.

## Code

```java[]
package Practice;

public class ArrayIsSortedAndRotated {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        System.out.println(check(nums));
    }

    public static boolean check(int[] nums) {
        int x = -1, n = nums.length;
        for (int i = 1; i < n; i++) {
            if (nums[i] < nums[i - 1]) {
                x = i;
                break;
            }
        }
        if (x == -1) {
            return true;
        }
        int[] b = new int[n];
        for (int i = 0; i < n; i++) {
            b[i] = nums[(i + x) % n];
        }
        for (int i = 1; i < n; i++) {
            if (b[i] < b[i - 1]) {
                return false;
            }
        }
        return true;
    }
}
```

## How It Works

1. **Identify the rotation point:** Find the first index `x` where `nums[i] < nums[i - 1]`.
2. **Handle already sorted arrays:** If no such point is found, the array is already sorted, so return `true`.
3. **Simulate rotation:** Construct a new array `b` by rotating `nums` from index `x`.
4. **Check sorted order:** Verify if the rotated array `b` is sorted in non-decreasing order.

## Complexity Analysis

- **Time Complexity:** `O(n)` — Linear scan for identifying the rotation point and checking the sorted order.
- **Space Complexity:** `O(n)` — Additional array for simulating the rotation.

## Usage

Compile and run the code:

```sh[]
javac ArrayIsSortedAndRotated.java
java Practice.ArrayIsSortedAndRotated
```

## Conclusion

This implementation checks if an array is sorted and rotated in linear time. It’s an efficient approach suitable for competitive programming and technical interviews!

---
