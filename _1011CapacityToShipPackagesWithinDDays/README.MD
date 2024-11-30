
# Practice: Capacity To Ship Packages Within D Days

This Java program solves the problem [1011. Capacity To Ship Packages Within D Days](https://leetcode.com/problems/capacity-to-ship-packages-within-d-days/).

## Problem Description

Given an array `weights` and an integer `days`, find the minimum capacity of a ship required to deliver all packages within the given number of days.

### Example:
```java[]
int[] weights = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
int days = 5;
System.out.println(shipWithinDays(weights, days)); // Output: 15
```

## Solution

The solution uses binary search to determine the minimum capacity required.

### Approach:
1. **Initialization**: Calculate the maximum weight of a package and the total weight as the range for binary search.
2. **Binary Search**:
    - Check if the current mid-value can accommodate all packages within the given days using the `checkCapacity` function.
    - Adjust the search range based on the result.
3. **Helper Functions**:
    - `checkCapacity`: Verifies if the given capacity can deliver all packages within the days.
    - `findMax`: Finds the maximum package weight and the total weight.

## Code

```java[]
public class CapacityToShipPackagesWithinDDays {
    public static void main(String[] args) {
        int[] weights = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int days = 5;
        System.out.println(shipWithinDays(weights, days));
    }
    static int shipWithinDays(int[] weights, int days) {
        int n = weights.length;
        int[] temp = findMax(weights, n);
        int start = temp[0], end = temp[1], ans = temp[1];
        while (start <= end) {
            int mid = (start + end) / 2;
            if (checkCapacity(weights, mid, days, n)) {
                ans = mid;
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return ans;
    }
    static boolean checkCapacity(int[] weights, int mid, int days, int n) {
        int max_days = 0, sum = 0;
        for (int i = 0; i < n; i++) {
            sum += weights[i];
            if (sum > mid) {
                max_days++;
                sum = weights[i];
            }
        }
        if (sum <= mid) max_days++;
        return max_days <= days;
    }
    static int[] findMax(int[] weights, int n) {
        int max = weights[0], sum = 0;
        for (int i = 0; i < weights.length; i++) {
            max = Math.max(max, weights[i]);
            sum += weights[i];
        }
        return new int[]{max, sum};
    }
}
```

## How It Works

- **Binary Search**: Determines the minimum ship capacity by narrowing down the range between the maximum package weight and the total weight.
- **Validation**: The `checkCapacity` function ensures that the current capacity is sufficient to ship all packages within the given days.

## Complexity Analysis

- **Time Complexity**: O(N * log(S)), where N is the number of weights and S is the range between the maximum package weight and the total weight.
- **Space Complexity**: O(1).

## Usage

1. Copy and paste the code into a Java file.
2. Compile and run the program with your input.
3. The program will return the minimum capacity required.

## References

- [LeetCode Problem 1011](https://leetcode.com/problems/capacity-to-ship-packages-within-d-days/)
