# Count Good Numbers

## Problem Description
Given an integer `n`, return the number of `good` digit strings of length `n`. A string is good if:
- The digits at even indices (0-based) are even digits (0, 2, 4, 6, 8).
- The digits at odd indices are prime digits (2, 3, 5, 7).

Since the answer may be large, return it modulo `10^9 + 7`.

[LeetCode Problem 1922 - Count Good Numbers](https://leetcode.com/problems/count-good-numbers/description/)

## Example

**Input:** `n = 50`

**Output:** `564908303`

## Solution Approach
- Count the number of even positions: `(n + 1) / 2`
- Count the number of odd positions: `n / 2`
- Since there are 5 choices for even positions (0, 2, 4, 6, 8), compute `5^(even positions) % MOD`.
- Since there are 4 choices for odd positions (2, 3, 5, 7), compute `4^(odd positions) % MOD`.
- Use modular exponentiation to efficiently compute the powers.
- Multiply both values and return the result modulo `10^9 + 7`.

## Code Implementation
```java[]
package Github._1992CountGoodNumbers;

public class CountGoodNumbers {
    private static final int MOD = 1_000_000_007;

    public int countGoodNumbers(long n) {
        long evenCount = (n + 1) / 2; // Number of even positions
        long oddCount = n / 2;        // Number of odd positions

        long evenProduct = modPow(5, evenCount, MOD); // 5 choices for even positions
        long oddProduct = modPow(4, oddCount, MOD);   // 4 choices for odd positions

        return (int) (evenProduct * oddProduct % MOD);
    }

    private long modPow(long base, long exp, int mod) {
        long result = 1;
        while (exp > 0) {
            if ((exp & 1) == 1) {
                result = result * base % mod;
            }
            base = base * base % mod;
            exp >>= 1;
        }
        return result;
    }
}
```

## How It Works
1. **Power Calculation using Modulo**: Since direct exponentiation can cause overflow, we use modular exponentiation to compute powers efficiently.
2. **Optimized Computation**: Using bitwise operations (`exp & 1` and `exp >>= 1`) helps speed up the calculations.
3. **Modular Arithmetic**: Since the result needs to be modulo `10^9 + 7`, we ensure every intermediate calculation follows modular rules.

## Complexity Analysis
- **Time Complexity**: `O(log n)`, as modular exponentiation runs in logarithmic time.
- **Space Complexity**: `O(1)`, since only a few integer variables are used.

## Usage
This approach efficiently computes the count of good numbers even for large values of `n`. The modular exponentiation method ensures the computation remains within feasible limits.

