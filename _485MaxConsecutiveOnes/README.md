
# Max Consecutive Ones

This repository contains a solution to the LeetCode problem [Max Consecutive Ones](https://leetcode.com/problems/max-consecutive-ones/), implemented in Java.

## Problem Description

Given a binary array `nums`, return the maximum number of consecutive `1`s in the array.

- **Example:** For an array `[1, 0, 1, 1, 0, 1]`, the output will be `2`.

### Example

**Input:**
```java[]
int[] nums = {1, 0, 1, 1, 0, 1};
```
**Output:**
```java[]
2
```

**Explanation:**

The maximum number of consecutive `1`s in the array `[1, 0, 1, 1, 0, 1]` is `2`.

## Solution

The solution iterates through the array, keeping track of the current count of consecutive `1`s and updating the maximum count whenever a `0` is encountered. If `1` is encountered, the count is incremented; otherwise, it resets to zero.

## Code Example

```java[]
public class MaxConsecutiveOnes {
    public static void main(String[] args) {
        int[] nums = {1, 0, 1, 1, 0, 1};
        System.out.println(findMaxConsecutiveOnes(nums));
    }

    static int findMaxConsecutiveOnes(int[] nums) {
        int max_count = 0, count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                count++;
                max_count = Math.max(count, max_count);
            } else {
                count = 0;
            }
        }
        return max_count;
    }
}
```

## How it Works

1. **Initialize Counters:** `max_count` keeps track of the maximum consecutive `1`s found, and `count` tracks the current streak.
2. **Iterate through Array:** For each element in `nums`, if it's `1`, increment `count` and update `max_count` if `count` exceeds it. If it's `0`, reset `count`.
3. **Return Maximum:** After the loop, `max_count` holds the maximum consecutive `1`s.

## How to Use

To run the solution, compile and execute the `MaxConsecutiveOnes` class in your Java environment:

```bash[]
javac MaxConsecutiveOnes.java
java MaxConsecutiveOnes
```
This will output the maximum number of consecutive `1`s in the provided array.

## Complexity Analysis

- **Time Complexity:** O(n), where `n` is the length of the array, since it iterates through the array once.
- **Space Complexity:** O(1), as only a fixed amount of space is used.
