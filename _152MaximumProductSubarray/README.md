# Maximum Product Subarray

This repository contains a solution to the LeetCode problem [Maximum Product Subarray](https://leetcode.com/problems/maximum-product-subarray/description/), implemented in Java.

## Problem Description

The **Maximum Product Subarray** problem requires finding the contiguous subarray within a given array (containing at least one number) that has the largest product.

- **Example:** Given `nums = [-2, 0, -1]`, the output would be `0`.

### Example

**Input:**
```java[]
int[] nums = {-2, 0, -1};
```
**Output:**
```java[]
0
```

**Explanation:**  
The maximum product subarray is `{0}`, with a product of `0`.

## Solution

This solution uses a prefix and suffix product approach to track the maximum product subarray efficiently.

### Optimal Solution

- **Algorithm:**  
  The algorithm maintains two variables, `pref` (prefix product) and `suff` (suffix product). Both are reset to 1 if they encounter a zero. The maximum product is updated during each iteration, comparing both prefix and suffix products.

- **Time Complexity:** O(n)
- **Space Complexity:** O(1)

### Code Example

```java[]
public class MaximumProductSubarray {
    public static void main(String[] args) {
        int[] nums = {-2, 0, -1};
        System.out.println(maxProduct(nums));
    }
    static int maxProduct(int[] nums) {
        int max_prod = Integer.MIN_VALUE, pref = 1, suff = 1, n = nums.length;
        for (int i = 0; i < n; i++) {
            if (pref == 0) pref = 1;
            if (suff == 0) suff = 1;
            pref = pref * nums[i];
            suff = suff * nums[n - i - 1];
            max_prod = Math.max(max_prod, Math.max(pref, suff));
        }
        return max_prod;
    }
}
```

## How it Works

1. **Initialization:**
    - Set `pref`, `suff` to 1, and `max_prod` to `Integer.MIN_VALUE`.

2. **Iteration:**
    - Compute prefix product (`pref`) and suffix product (`suff`) for each element in the array.
    - Reset prefix and suffix products to 1 when encountering zeroes.

3. **Update Maximum:**
    - At each step, update `max_prod` with the maximum of the prefix or suffix products.

4. **Result:**
    - Return the maximum product found.

## How to Use

To run the solution, compile and execute the `MaximumProductSubarray` class in your Java environment:

```bash[]
javac MaximumProductSubarray.java
java MaximumProductSubarray
```

This will output the maximum product of a contiguous subarray in the given input array.

## Complexity Analysis

- **Time Complexity:** O(n), where `n` is the length of the input array.
- **Space Complexity:** O(1), as no additional space is used apart from variables.

---

