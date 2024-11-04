
# Single Number

This repository contains a solution to the LeetCode problem [Single Number](https://leetcode.com/problems/single-number/), implemented in Java.

## Problem Description

Given a non-empty array of integers `nums`, every element appears twice except for one. Find that single one.

- **Example:** For an array `[2, 2, 1]`, the output will be `1`.

### Example

**Input:**
```java[]
int[] nums = {2, 2, 1};
```
**Output:**
```java[]
1
```

**Explanation:**

In the array `[2, 2, 1]`, every element appears twice except for `1`, which appears only once.

## Solution

The solution utilizes the XOR operator to find the unique number. XOR-ing a number with itself results in `0`, and XOR-ing any number with `0` results in the number itself. Thus, XOR-ing all numbers together leaves only the unique number.

## Code Example

```java[]
public class SingleNumber {
    public static void main(String[] args) {
        int[] nums = {2, 2, 1};
        System.out.println(singleNumber(nums));
    }

    static int singleNumber(int[] nums) {
        int xor = 0;
        for (int i = 0; i < nums.length; i++) {
            xor = xor ^ nums[i];
        }
        return xor;
    }
}
```

## How it Works

1. **Initialize XOR Variable:** Start with `xor = 0`.
2. **Iterate through Array:** XOR each element in the array with `xor`. Since pairs will cancel each other out, only the unique element remains in `xor`.
3. **Return the Unique Number:** At the end of the loop, `xor` holds the value of the unique number.

## How to Use

To run the solution, compile and execute the `SingleNumber` class in your Java environment:

```bash[]
javac SingleNumber.java
java SingleNumber
```
This will output the unique number in the provided array.

## Complexity Analysis

- **Time Complexity:** O(n), where `n` is the length of the array, since it iterates through the array once.
- **Space Complexity:** O(1), as only a fixed amount of space is used.
