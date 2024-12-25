# Binary Subarrays With Sum

## Problem Description

**LeetCode Problem:** [930. Binary Subarrays With Sum](https://leetcode.com/problems/binary-subarrays-with-sum/description/)

Given a binary array `nums` and an integer `goal`, return the number of non-empty subarrays with a sum equal to `goal`.

---

## Example

### Input:
```java[]
nums = [1, 0, 1, 0, 1]
goal = 2
```

### Output:
```
4
```

### Explanation:
The subarrays are:
- [1, 0, 1]
- [0, 1, 0, 1]
- [1, 0, 1, 0]
- [1, 0, 1]

---

## Solution

### Approach
The problem is solved using a two-pointer sliding window approach.

### Key Insights
- Calculate the number of subarrays with sum equal to `goal` by calculating the difference between subarrays with sum equal to `goal` and subarrays with sum equal to `goal - 1`.
- This is implemented through a helper function that computes subarrays with a sum less than or equal to the given `goal`.

### Complexity
- **Time Complexity:** `O(n)`
- **Space Complexity:** `O(1)`

---

## Code

```java[]
public class BinarySubArrayWithSum {
    public static void main(String[] args) {
        int[] nums = {1, 0, 1, 0, 1};
        int goal = 2;
        System.out.println(numSubarraysWithSum(nums, goal));
    }

    static int numSubarraysWithSum(int[] nums, int goal) {
        return helper(nums, goal) - helper(nums, goal - 1);
    }

    private static int helper(int[] nums, int goal) {
        if (goal < 0) {
            return 0;
        }
        int i = 0, j = 0;
        int sum = 0, maxCount = 0;
        while (j < nums.length) {
            sum += nums[j];
            while (sum > goal) {
                sum -= nums[i];
                i++;
            }
            maxCount += (j - i + 1);
            j++;
        }
        return maxCount;
    }
}
```

---

## How It Works
1. **Helper Function:**
    - Calculates the number of subarrays with sum less than or equal to `goal`.
    - Uses two pointers `i` and `j` to define the sliding window.
    - Adjusts the window size by increasing `i` when the sum exceeds `goal`.

2. **Main Function:**
    - Computes the desired result by finding the difference between subarrays with sum equal to `goal` and those with sum less than `goal`.

---

## Usage
To use this code, run the `main` function with a binary array `nums` and an integer `goal` as input. The output will be the count of subarrays with a sum equal to `goal`.

---

## Complexity Analysis
- **Time Complexity:**
  The sliding window ensures each element is processed once, resulting in `O(n)` time.

- **Space Complexity:**
  The code uses a constant amount of extra space, making it `O(1)`.

---

## Edge Cases
- `nums` is empty: Returns `0`.
- `goal` is `0`: Handles cases where the sum of subarrays must be `0`.

---

## Example Execution
For `nums = [1, 0, 1, 0, 1]` and `goal = 2`:

1. `helper(nums, 2)` calculates subarrays with sum ≤ 2.
2. `helper(nums, 1)` calculates subarrays with sum ≤ 1.
3. Subtracting these values gives the count of subarrays with sum exactly equal to `2`.
