# U_Github - Koko Eating Bananas

## Problem Description
Koko loves to eat bananas. There are `n` piles of bananas, where the `i-th` pile has `piles[i]` bananas. The guards have gone and will come back in `h` hours. Koko can decide her bananas-per-hour eating speed `k`. Each hour, she chooses a pile of bananas and eats up to `k` bananas. If the pile has fewer than `k` bananas, she eats all of them instead and does not eat any more bananas during that hour.

Return the minimum integer `k` such that she can eat all the bananas within `h` hours.

[Problem Link](https://leetcode.com/problems/koko-eating-bananas/description/)

---

## Example

### Input:
```java[]
piles = {805306368, 805306368, 805306368};
h = 1000000000;
```

### Output:
```java[]
1
```

---

## Solution
This problem is solved using binary search. We aim to find the minimum speed `k` by iteratively narrowing down the range between the smallest possible speed (`1`) and the maximum pile size.

### Key Functions:
1. **`minEatingSpeed1`**: Implements an alternative approach to compute the minimum speed.
2. **`minEatingSpeed`**: Core function using binary search to determine the optimal speed.
3. **`totalHours`**: Computes the total hours needed to eat all bananas at a given speed.
4. **`findMax`**: Finds the maximum pile size.

---

## Code

```java
public class kokoEatingBananas {
    public static void main(String[] args) {
        int[] piles = {805306368, 805306368, 805306368};
        int h = 1000000000;
        System.out.println(minEatingSpeed1(piles, h));
    }

    static int minEatingSpeed1(int[] piles, int h) {
        int n = piles.length;
        long total = 0;
        for (int p : piles) total += p;

        int left = (int) ((total - 1) / h) + 1;
        int right = (int) ((total - n) / (h - n + 1)) + 1;

        while (left < right) {
            int mid = left + (right - left) / 2;
            int time = 0;
            for (int p : piles) {
                time += (p - 1) / mid + 1;
            }
            if (time > h) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        return left;
    }

    static int minEatingSpeed(int[] piles, int h) {
        int n = piles.length, start = 1, end = findMax(piles, n), ans = 0;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            long total_hrs = totalHours(piles, mid, n);
            if (total_hrs <= h) {
                ans = mid;
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return ans;
    }

    static long totalHours(int[] arr, int mid, int n) {
        long total_hrs = 0;
        for (int i = 0; i < n; i++) {
            total_hrs = total_hrs + (long) Math.ceil((double) arr[i] / (double) mid);
        }
        return total_hrs;
    }

    static int findMax(int[] arr, int n) {
        int max = arr[0];
        for (int i = 1; i < n; i++) {
            max = Math.max(arr[i], max);
        }
        return max;
    }
}
```

---

## How It Works
1. **Binary Search Range**:
    - Start with `1` as the minimum speed and the largest pile size as the maximum speed.
    - Use binary search to find the optimal speed `k`.

2. **Validation**:
    - For a given speed `k`, calculate the total hours needed using `totalHours`.
    - Adjust the binary search range based on whether the total hours exceed `h`.

---

## Complexity Analysis
- **Time Complexity**: `O(n * log(maxPileSize))`, where `n` is the number of piles.
- **Space Complexity**: `O(1)` (in-place computation).

---

## Usage
- Run the `main` method with different `piles` arrays and `h` values to test the implementation.
- Verify the correctness using the example inputs provided above.

---
