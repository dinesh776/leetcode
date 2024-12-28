# Subarrays with K Different Integers

## Problem Description
Given an integer array `nums` and an integer `k`, return the number of good subarrays with exactly `k` different integers.

A good subarray is a contiguous subarray that contains exactly `k` different integers.

**Problem Link:** [LeetCode #992 - Subarrays with K Different Integers](https://leetcode.com/problems/subarrays-with-k-different-integers/description/)

---

## Code Implementation

```java[]
import java.util.HashMap;

public class SubarraysWithKDistinctIntegers {
    public static void main(String[] args) {
        int[] nums = {1, 2, 1, 3, 4};
        int k = 3;
        System.out.println(subarraysWithKDistinct(nums, k));
    }

    static int subarraysWithKDistinct(int[] nums, int k) {
        return helper(nums, k) - helper(nums, k - 1);
    }

    private static int helper(int[] nums, int goal) {
        if (goal < 0) {
            return 0;
        }
        int i = 0, j = 0;
        int count = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        while (j < nums.length) {
            map.put(nums[j], map.getOrDefault(nums[j], 0) + 1);
            while (map.size() > goal) {
                map.put(nums[i], map.get(nums[i]) - 1);
                if (map.get(nums[i]) == 0) {
                    map.remove(nums[i]);
                }
                i++;
            }
            count = count + (j - i + 1);
            j++;
        }
        return count;
    }
}
```

---

## How It Works

1. **Main Functionality**:
    - The `subarraysWithKDistinct` function calculates the number of subarrays with exactly `k` different integers by leveraging the helper function twice:
        - Once with `goal = k`.
        - Once with `goal = k - 1`.
    - The difference between these two results gives the exact number of subarrays with `k` different integers.

2. **Helper Function**:
    - The `helper` function calculates the number of subarrays with **at most** `goal` different integers.
    - Uses a sliding window approach with two pointers (`i` and `j`) to traverse the array.
    - Maintains a `HashMap` to keep track of the frequency of integers within the current window.
    - Adjusts the left pointer `i` to ensure the window contains at most `goal` different integers.
    - Adds the number of valid subarrays ending at `j` to the total count.

---

## Example Execution

### Input
```plaintext
nums = [1, 2, 1, 3, 4]
k = 3
```

### Output
```plaintext
3
```

### Explanation
- Subarrays with exactly 3 different integers are:
    - `[1, 2, 1, 3]`
    - `[2, 1, 3]`
    - `[1, 3, 4]`

---

## Complexity Analysis

1. **Time Complexity**:
    - **Helper Function**: Each element is processed at most twice (once when added to the window and once when removed).
    - Overall: **O(n)** per call to `helper`.
    - Since `helper` is called twice: **O(n)**.

2. **Space Complexity**:
    - Uses a `HashMap` to store up to `k` unique elements.
    - **O(k)**.

---

## Usage
- Suitable for problems involving sliding windows and constraints on distinct elements within subarrays.
- Can be modified for similar problems by adjusting the condition on the number of distinct elements.

---

## Notes
- This approach efficiently handles the constraint of exactly `k` different integers by breaking it into two simpler subproblems.
- The sliding window technique ensures optimal performance.
