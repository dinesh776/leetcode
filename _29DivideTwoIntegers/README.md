# Divide Two Integers

## Problem Description
LeetCode Problem 29: [Divide Two Integers](https://leetcode.com/problems/divide-two-integers/description/)

Given two integers `dividend` and `divisor`, divide them without using multiplication, division, and mod operators. Return the quotient after dividing `dividend` by `divisor`.

## Example
```java[]
Input: dividend = 10, divisor = 3
Output: 3
Explanation: 10 / 3 = 3 with a remainder of 1.
```

## Solution
The solution uses bit manipulation to perform division. By repeatedly doubling the divisor and subtracting it from the dividend, we accumulate the quotient without using division or multiplication.

## Code Example
```java[]
public class divideTwoNumbersWithoutOperators {
    public static void main(String[] args) {
        int dividend = 10, divisor = 3;
        System.out.println(divide(dividend, divisor));
    }

    public static int divide(int dividend, int divisor) {
        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }
        if (divisor == 1) return dividend;
        if (divisor == -1) return -dividend;

        boolean sign = (dividend >= 0) == (divisor >= 0);

        long n = Math.abs((long) dividend);
        long d = Math.abs((long) divisor);
        int ans = 0;

        while (n >= d) {
            long temp = d, multiple = 1;
            while (n >= (temp << 1)) {
                temp <<= 1;
                multiple <<= 1;
            }
            n -= temp;
            ans += multiple;
        }

        return sign ? ans : -ans;
    }
}
```

## How It Works
- **Handling edge cases:** Special handling for `Integer.MIN_VALUE` to avoid overflow.
- **Bit manipulation:** Shift the divisor left until it exceeds the dividend, then subtract and accumulate the result.
- **Sign determination:** The sign of the result is determined by the signs of the input values.

## Complexity Analysis
- **Time Complexity:** `O(log N)` where `N` is the absolute value of the dividend.
- **Space Complexity:** `O(1)` because only a few extra variables are used.

## Usage
Run the program to test the division logic:
```bash[]
javac divideTwoNumbersWithoutOperators.java
java divideTwoNumbersWithoutOperators
```
Output:
```[]
3
```

