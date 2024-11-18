
# 3 Sum

This repository contains a solution to the LeetCode problem [3 Sum](https://leetcode.com/problems/3sum/), implemented in Java.

## Problem Description

The **3 Sum** problem involves finding all unique triplets in an array that add up to zero. The solution must not contain duplicate triplets.

### Example

**Input:**
```java[]
int[] nums = {0, 0, 0};
```

**Output:**
```java[]
[[0, 0, 0]]
```

**Explanation:**

The only triplet that adds up to zero in the input array is `[0, 0, 0]`.

## Solution

This solution uses an **optimal two-pointer approach** with a time complexity of `O(n^2)` and a space complexity of `O(1)` (excluding the space for the output list).

## Code Example

```java[]
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _3Sum {
    public static void main(String[] args) {
        int[] nums = {0, 0, 0};
        System.out.println(threeSum(nums));
    }
    static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> finaList = new ArrayList<>();
        Arrays.sort(nums);
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int j = i + 1, k = n - 1;
            while (j < k) {
                int sum = nums[i] + nums[j] + nums[k];
                if (sum < 0) {
                    j++;
                } else if (sum > 0) {
                    k--;
                } else {
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[i]);
                    list.add(nums[j]);
                    list.add(nums[k]);
                    finaList.add(list);
                    j++;
                    k--;
                    while (j < k && nums[j] == nums[j - 1]) {
                        j++;
                    }
                    while (j < k && nums[k] == nums[k + 1]) {
                        k--;
                    }
                }
            }
        }
        return finaList;
    }
}
```

## How it Works

1. **Sorting the Array:** The array is first sorted to facilitate the two-pointer technique.
2. **Iterating Through the Array:** For each element, use two pointers to find pairs that add up to the negative of the current element.
3. **Avoiding Duplicates:** Skips duplicate elements to ensure all triplets in the result are unique.

## How to Use

To run the solution, compile and execute the `_3Sum` class in your Java environment:

```bash[]
javac _3Sum.java
java _3Sum
```

This will output all unique triplets that sum to zero for the given input array.

## Complexity Analysis

- **Time Complexity:** O(n^2), where `n` is the number of elements in the array, due to the nested iteration with two pointers.
- **Space Complexity:** O(1) (excluding output), as no additional data structures are used other than the result list.
