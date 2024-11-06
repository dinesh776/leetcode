
# Rearrange Array Elements by Sign

This repository contains a solution to the LeetCode problem [Rearrange Array Elements by Sign](https://leetcode.com/problems/rearrange-array-elements-by-sign/), implemented in Java.

## Problem Description

Given an integer array `nums` of even length where half of the elements are positive, and the other half are negative, rearrange the elements of `nums` so that the positive and negative numbers alternate, starting with a positive number. Each positive and negative number should retain their relative order in the rearranged array.

- **Example:** For an array `[-1, -2, -3, 4, 5, 6]`, the output will be `[4, -1, 5, -2, 6, -3]`.

### Example

**Input:**
```java[]
int[] nums = {-1, -2, -3, 4, 5, 6};
```
**Output:**
```java[]
[4, -1, 5, -2, 6, -3]
```

**Explanation:**

The positive numbers `[4, 5, 6]` and negative numbers `[-1, -2, -3]` are alternated starting with a positive number.

## Solution

The solution iterates through the array and rearranges the elements based on their sign. Using a temporary array, it places positive numbers at even indices and negative numbers at odd indices, ensuring the required alternation.

## Code Example

```java[]
import java.util.Arrays;

public class RearrageArrayElementsBySign {
    public static void main(String[] args) {
        int[] nums = {-1, -2, -3, 4, 5, 6};
        System.out.println(Arrays.toString(rearrangeArray(nums)));
    }

    static int[] rearrangeArray(int[] nums) {
        int n = nums.length, p = 0, ne = 1;
        int[] temp = new int[n];
        for (int i = 0; i < n; i++) {
            if (nums[i] >= 0) {
                temp[p] = nums[i];
                p += 2;
            } else {
                temp[ne] = nums[i];
                ne += 2;
            }
        }
        return temp;
    }
}
```

## How it Works

1. **Initialize Positions:** `p` is the index for positive elements (starting at 0), and `ne` is the index for negative elements (starting at 1).
2. **Iterate through Array:** For each element, place positive numbers at even indices and negative numbers at odd indices in the temporary array `temp`.
3. **Return the Result:** After filling the temporary array, return it as the rearranged array.

## How to Use

To run the solution, compile and execute the `RearrageArrayElementsBySign` class in your Java environment:

```bash[]
javac RearrageArrayElementsBySign.java
java RearrageArrayElementsBySign
```
This will output the rearranged array with alternating positive and negative elements.

## Complexity Analysis

- **Time Complexity:** O(n), where `n` is the length of the array, as it iterates through the array once.
- **Space Complexity:** O(n), as an additional array of the same size is used to store the rearranged elements.
