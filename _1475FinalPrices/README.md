# Final Prices With a Special Discount in a Shop

## Problem Description

You are given an integer array `prices` where `prices[i]` is the price of the `i-th` item in a shop. There is a special discount rule: you will get a discount equal to the price of the first subsequent item that has a price less than or equal to the price of the current item. If no such item exists, you will not get any discount for the current item.

Return an array where the `i-th` element is the final price you will pay for the `i-th` item.

**Problem Link:** [1475. Final Prices With a Special Discount in a Shop](https://leetcode.com/problems/final-prices-with-a-special-discount-in-a-shop/description/?envType=daily-question&envId=2024-12-18)

---

## Approach

### Implementation

```java[]
import java.util.Arrays;

public class Discount {
    public static void main(String[] args) {
        int[] arr = {8, 7, 4, 2, 8, 1, 7, 7, 10, 1};
        System.out.println(Arrays.toString(finalPrices(arr)));
    }

    static int[] finalPrices(int[] prices) {
        int n = prices.length;
        int[] finalPrices = new int[n];

        for (int i = 0; i < n; i++) {
            // Initialize the discounted price as the original price
            finalPrices[i] = prices[i];

            // Find the first smaller or equal price
            for (int j = i + 1; j < n; j++) {
                if (prices[j] <= prices[i]) {
                    finalPrices[i] = prices[i] - prices[j];
                    break;
                }
            }
        }
        return finalPrices;
    }
}
```

---

## Time Complexity
- **O(n²):** For each item in the array, we potentially iterate through all subsequent items to find the discount.

## Space Complexity
- **O(n):** Additional space is used for the `finalPrices` array.

---

## Examples

### Example 1
**Input:**
```
prices = [8, 4, 6, 2, 3]
```
**Output:**
```
[4, 2, 4, 2, 3]
```

### Example 2
**Input:**
```
prices = [1, 2, 3, 4, 5]
```
**Output:**
```
[1, 2, 3, 4, 5]
```

### Example 3
**Input:**
```
prices = [10, 1, 1, 6]
```
**Output:**
```
[9, 0, 1, 6]
```

---

## How It Works
1. **Initialization:** Create an array `finalPrices` initialized with the original prices.
2. **Nested Loop:** For each price, iterate over the subsequent items to find the first smaller or equal price.
3. **Discount Calculation:** Update the final price by subtracting the discount value.
4. **Return Result:** Return the `finalPrices` array after processing all items.
