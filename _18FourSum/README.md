
# 4Sum

This repository contains a Java implementation for solving the LeetCode problem [4Sum](https://leetcode.com/problems/4sum/submissions/1456018844/).

## Problem Description

The **4Sum** problem requires finding all unique quadruplets in an array that sum up to a given target value. The solution should not include duplicate quadruplets.

### Example

**Input:**
```java[]
int[] nums = {1000000000, 1000000000, 1000000000, 1000000000};
int target = -294967296;
```

**Output:**
```java[]
[]
```

**Explanation:** No quadruplet in the input array adds up to the given target.

## Solution

The solution employs a two-pointer approach combined with nested loops, making it efficient for sorted arrays.

### Algorithm Steps:

1. **Sort the Array:** The input array is sorted to enable the two-pointer approach.
2. **Iterate Over Pairs:** Use nested loops for the first two elements of the quadruplet.
3. **Two-Pointer Search:** Use two pointers (`k` and `l`) to find the remaining two elements.
4. **Avoid Duplicates:** Skip duplicate values during iteration to ensure unique quadruplets.
5. **Sum Validation:** If the sum matches the target, store the quadruplet.

## Code Example

```java[]
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _4Sum {
    public static void main(String[] args) {
        int[] nums = {1000000000, 1000000000, 1000000000, 1000000000};
        int target = -294967296;
        System.out.println(fourSum(nums, target));
    }
    static List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(nums);
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            for (int j = i + 1; j < n; j++) {
                if (j != i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                }
                int l = n - 1, k = j + 1;
                while (k < l) {
                    long sum = (long) nums[i] + nums[j] + nums[k] + nums[l];
                    if (sum == target) {
                        List<Integer> temp = new ArrayList<>();
                        temp.add(nums[i]);
                        temp.add(nums[j]);
                        temp.add(nums[k]);
                        temp.add(nums[l]);
                        list.add(temp);
                        k++;
                        l--;
                        while (k < l && nums[k] == nums[k - 1]) {
                            k++;
                        }
                        while (k < l && nums[l] == nums[l + 1]) {
                            l--;
                        }
                    } else if (sum < target) {
                        k++;
                    } else {
                        l--;
                    }
                }
            }
        }
        return list;
    }
}
```

## How to Use

To execute this solution:
1. Compile the `_4Sum` class.
2. Run the program with a valid array and target as input.

```bash[]
javac _4Sum.java
java _4Sum
```

## Complexity Analysis

- **Time Complexity:** O(n³), where `n` is the size of the input array. This is due to the nested loops and two-pointer traversal.
- **Space Complexity:** O(1), as no additional space is used beyond the result list.

---

Feel free to contribute or raise issues for improvements!
