# Minimize XOR

This repository contains a solution to the LeetCode problem [2429. Minimize XOR](https://leetcode.com/problems/minimize-xor/description/?envType=daily-question&envId=2025-01-15).

## Problem Description

You are given two positive integers `num1` and `num2`. The goal is to minimize the XOR value of `num1` and a new integer `result`, which must have the same number of `1` bits in its binary representation as `num2`. Return the integer `result`.

### Example

#### Input
```java[]
num1 = 3, num2 = 5
```

#### Output
```java[]
3
```

#### Explanation
The binary representation of `num1` is `11` and of `num2` is `101`. The number `3` has two `1`s, matching the count of `1`s in `num2`. The XOR of `3` and `3` is minimized to `0`.

### Constraints
- `1 <= num1, num2 <= 10^9`

## Solution Approach

1. **Count the 1s in `num2`'s binary representation**: Using `Integer.bitCount()` to count the number of 1s in `num2`.
2. **Set bits in `result` starting from the highest bit in `num1`**: To minimize XOR, match the significant bits of `num1` with `result`.
3. **Fill remaining bits in `result` starting from the least significant bit**: If more bits are needed to match the count of `1`s in `num2`, set the lowest available bits in `result`.

## Implementation

```java[]
public class MinimizeXOR {
    public static void main(String[] args) {
        int num1 = 3, num2 = 5;
        System.out.println(minimizeXor(num1, num2));
    }

    static int minimizeXor(int num1, int num2) {
        int num2Ones = Integer.bitCount(num2); // Count the number of 1s in num2
        int result = 0;

        // Step 1: Use the 1s from num1 (highest bits first)
        for (int i = 31; i >= 0 && num2Ones > 0; i--) {
            if ((num1 & (1 << i)) != 0) {
                result |= (1 << i); // Set this bit in the result
                num2Ones--;        // Decrease the count of 1s to place
            }
        }

        // Step 2: If num2Ones are left, fill the lowest available bits
        for (int i = 0; i < 32 && num2Ones > 0; i++) {
            if ((result & (1 << i)) == 0) {
                result |= (1 << i); // Set this bit in the result
                num2Ones--;        // Decrease the count of 1s to place
            }
        }

        return result;
    }
}
```

## How It Works

- **Count the `1`s in `num2`**: This ensures the result has the same number of set bits as `num2`.
- **Set significant bits of `num1`**: Prioritize bits from `num1` to minimize XOR.
- **Fill remaining bits**: Use the least significant bits to complete the required number of set bits.

## Complexity Analysis

- **Time Complexity**: `O(32)` since we iterate over a fixed number of bits (32-bit integer).
- **Space Complexity**: `O(1)` as no additional space is used.

## Usage

To run the solution, compile and execute the Java file:

```bash[]
javac MinimizeXOR.java
java MinimizeXOR
```
