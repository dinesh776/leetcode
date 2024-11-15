
# Sort Colors

This repository contains a solution to the LeetCode problem [Sort Colors](https://leetcode.com/problems/sort-colors/), implemented in Java.

## Problem Description

The **Sort Colors** problem requires sorting an array containing integers `0`, `1`, and `2` in-place so that elements of the same value are adjacent, with the colors in the order `0`, `1`, and `2`.

- **Example:** Given the array `[2,0,2,1,1,0]`, the output should be `[0,0,1,1,2,2]`.

### Example

**Input:**
```java[]
int[] nums = {2,0,2,1,1,0};
```
**Output:**
```java[]
[0,0,1,1,2,2]
```

**Explanation:**

The array `[2,0,2,1,1,0]` is sorted in-place to `[0,0,1,1,2,2]`, grouping all `0`s first, followed by `1`s and then `2`s.

## Solution

This solution utilizes the **Dutch National Flag Algorithm**, an optimal approach that sorts the array in a single pass with constant space complexity.

## Code Example

```java[]
import java.util.Arrays;

public class SortColors {
    public static void main(String[] args) {
        int[] nums = {2,0,2,1,1,0};
        sortColors(nums);
        System.out.println(Arrays.toString(nums));
    }

    static void sortColors(int[] nums) {
        int low = 0, mid = 0, high = nums.length - 1;

        while (mid <= high) {
            if (nums[mid] == 0) {
                // Swap nums[low] and nums[mid]
                int temp = nums[low];
                nums[low] = nums[mid];
                nums[mid] = temp;
                low++;
                mid++;
            } else if (nums[mid] == 1) {
                // Move mid pointer
                mid++;
            } else { // nums[mid] == 2
                // Swap nums[mid] and nums[high]
                int temp = nums[mid];
                nums[mid] = nums[high];
                nums[high] = temp;
                high--;
            }
        }
    }
}
```

## How it Works

1. **Initialize Pointers:**
    - `low`: Points to the position where the next `0` should be placed.
    - `mid`: Traverses the array.
    - `high`: Points to the position where the next `2` should be placed.

2. **Traverse the Array:**
    - **If `nums[mid] == 0`:**
        - Swap `nums[low]` and `nums[mid]`.
        - Increment both `low` and `mid` to move to the next positions.
    - **If `nums[mid] == 1`:**
        - Simply move the `mid` pointer to the next position.
    - **If `nums[mid] == 2`:**
        - Swap `nums[mid]` and `nums[high]`.
        - Decrement `high` to move the boundary for `2`s.

3. **Continue Until `mid` Exceeds `high`:**
    - This ensures all elements are processed and placed in their correct positions.

## How to Use

To run the solution, compile and execute the `SortColors` class in your Java environment:

```bash[]
javac SortColors.java
java SortColors
```

This will output the sorted array:

```plaintext[]
[0, 0, 1, 1, 2, 2]
```

## Complexity Analysis

- **Time Complexity:** O(n), where `n` is the length of the array. The algorithm makes a single pass through the array.
- **Space Complexity:** O(1), as it sorts the array in place without using additional memory.
