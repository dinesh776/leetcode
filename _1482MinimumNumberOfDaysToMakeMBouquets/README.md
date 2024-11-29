
# Minimum Number of Days to Make m Bouquets

## Problem Description

Given an array `bloomDay`, an integer `m` representing the number of bouquets, and an integer `k` representing the number of adjacent flowers needed to make one bouquet, this program finds the minimum number of days required to make at least `m` bouquets.

- **LeetCode Problem**: [1482. Minimum Number of Days to Make m Bouquets](https://leetcode.com/problems/minimum-number-of-days-to-make-m-bouquets/description/)

---

## Example

### Input
```java[]
int[] arr = {7, 7, 7, 7, 12, 7, 7};
int m = 2, k = 3;
```

### Output
```java[]
12
```

---

## Solution

### Approach

1. **Binary Search**: The solution employs binary search to find the minimum day required.
    - The search range is between the smallest and largest bloom day in the input array.
2. **Validation**: A helper function checks if it is possible to form at least `m` bouquets using the current mid-day value.
3. **Optimization**: Minimize the maximum day for forming the bouquets.

### Functions

1. **`findMinMax`**: Determines the minimum and maximum values in the `bloomDay` array.
2. **`flowersBloom`**: Calculates the number of bouquets that can be formed for a given day.

---

## Complexity Analysis

- **Time Complexity**:
    - Binary search: \(O(log(	ext{max} - 	ext{min}))\)
    - Helper functions: \(O(n)\) per iteration  
      Overall: \(O(nlog(ext{max} - ext{min}))\).

- **Space Complexity**: \(O(1)\).

---

## Code

```java[]
public class MinimumNumberOfDaysToMakeMBouquets {
    public static void main(String[] args) {
        int[] arr = {7, 7, 7, 7, 12, 7, 7};
        int m = 2, k = 3;
        System.out.println(minDays(arr, m, k));
    }

    static int minDays(int[] bloomDay, int m, int k) {
        int n = bloomDay.length;
        if (n < m * k) {
            return -1;
        }
        int[] temp = findMinMax(bloomDay, n);
        int start = temp[0], end = temp[1], ans = -1;
        while (start <= end) {
            int mid = (start + end) / 2;
            int no_of_flowers = flowersBloom(bloomDay, n, mid, k);
            if (no_of_flowers >= m) {
                ans = mid;
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return ans;
    }

    static int flowersBloom(int[] bloomDay, int n, int mid, int k) {
        int Adjacent_flowers = 0, ct = 0;
        for (int i = 0; i < n; i++) {
            if (bloomDay[i] <= mid) {
                ct++;
            } else {
                Adjacent_flowers = Adjacent_flowers + (ct / k);
                ct = 0;
            }
        }
        return Adjacent_flowers + (ct / k);
    }

    static int[] findMinMax(int[] arr, int n) {
        int min = arr[0], max = arr[0];
        for (int i = 1; i < n; i++) {
            min = Math.min(min, arr[i]);
            max = Math.max(max, arr[i]);
        }
        return new int[]{min, max};
    }
}
```

---

## Usage

1. Copy the code into a file named `MinimumNumberOfDaysToMakeMBouquets.java`.
2. Compile and run the program.
3. Provide the input array and parameters `m` and `k` as required.

---

## How It Works

1. The program calculates the minimum and maximum bloom days to define the binary search range.
2. It checks for each potential day whether enough bouquets can be formed.
3. It optimizes to find the earliest possible day.

---

