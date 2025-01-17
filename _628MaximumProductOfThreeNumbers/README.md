# Max Product of Three Numbers

## Problem Description

Given an integer array `nums`, find three numbers whose product is maximum and return the maximum product.

- **LeetCode Problem:** [Maximum Product of Three Numbers](https://leetcode.com/problems/maximum-product-of-three-numbers/description/)

---

## Code Implementation

```java[]
import java.util.Arrays;

public class MaxProductOfThreeNumbers {
    public static void main(String[] args) {
        int[] nums = {-100, -98, -1, 2, 3, 4};
        System.out.println(maximumProduct(nums));
    }

    static int maximumProduct(int[] nums) {
        // Sort the array
        Arrays.sort(nums);

        // Compute the two potential maximum products
        int n = nums.length;
        int option1 = nums[n - 1] * nums[n - 2] * nums[n - 3];
        int option2 = nums[0] * nums[1] * nums[n - 1];

        // Return the maximum of the two
        return Math.max(option1, option2);
    }
}
```

---

## How It Works

1. **Sorting the Array**:
    - The input array `nums` is sorted in ascending order. Sorting helps us easily pick the largest and smallest values for comparison.

2. **Computing Two Potential Maximum Products**:
    - **Option 1**: The product of the largest three numbers in the array: `nums[n - 1] * nums[n - 2] * nums[n - 3]`.
    - **Option 2**: The product of the two smallest numbers and the largest number: `nums[0] * nums[1] * nums[n - 1]`. This covers cases where the smallest numbers are negative, and their product becomes positive when multiplied by the largest positive number.

3. **Returning the Maximum**:
    - The maximum of `option1` and `option2` is returned as the final result.

---

## Example

### Input:
```java[]
nums = {-100, -98, -1, 2, 3, 4};
```

### Output:
```java[]
39200
```

### Explanation:
- **Option 1**: Product of the three largest numbers (4, 3, 2): `4 * 3 * 2 = 24`.
- **Option 2**: Product of the two smallest numbers (-100, -98) and the largest number (4): `(-100) * (-98) * 4 = 39200`.
- The maximum product is `39200`.

---

## Complexity Analysis

### Time Complexity:
- Sorting the array takes `O(n log n)`, where `n` is the number of elements in `nums`.
- Calculating the two potential products takes constant time, `O(1)`.
- **Overall Complexity**: `O(n log n)`.

### Space Complexity:
- The algorithm uses `O(1)` additional space.

---

## Notes

- The approach leverages sorting to simplify finding the largest and smallest values, ensuring accuracy and efficiency.
- Handles negative numbers effectively by considering their product with the largest positive number.
