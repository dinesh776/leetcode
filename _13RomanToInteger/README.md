
# Roman to Integer

This project provides a solution to the LeetCode problem **13. Roman to Integer**.

## Problem Description

Roman numerals are represented by seven different symbols: I, V, X, L, C, D, and M.

| Symbol | Value |
|--------|-------|
| I      | 1     |
| V      | 5     |
| X      | 10    |
| L      | 50    |
| C      | 100   |
| D      | 500   |
| M      | 1000  |

For example, 2 is written as II in Roman numeral, just two ones added together. 12 is written as XII, which is simply X + II. The number 27 is written as XXVII, which is XX + V + II.

Given a Roman numeral, convert it to an integer.

### Example

Input:
```
s = "MCMXCIV"
```

Output:
```
1994
```

Explanation:
```
M = 1000, CM = 900, XC = 90, IV = 4. Total = 1994.
```

## Solution

### Approach: Backward Traversal

The approach involves traversing the Roman numeral string from the end while converting it to its integer value.

### Code:
```java[]
public class RomanToInteger {
    public static void main(String[] args) {
        String s = "MCMXCIV";
        System.out.println(romanToInt(s));
    }

    static int romanToInt(String s) {
        int sum = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            char second = s.charAt(i);
            char first = (i > 0) ? s.charAt(i - 1) : second;
            int sVal = roman(second);
            int fVal = roman(first);
            int temp;
            if (sVal > fVal) {
                temp = sVal - fVal;
                if (i > 0) {
                    i--;
                }
            } else {
                temp = sVal;
            }
            sum += temp;
        }
        return sum;
    }

    static int roman(char c) {
        return switch (c) {
            case 'I' -> 1;
            case 'V' -> 5;
            case 'X' -> 10;
            case 'L' -> 50;
            case 'C' -> 100;
            case 'D' -> 500;
            case 'M' -> 1000;
            default -> 0;
        };
    }
}
```

## How It Works

1. **Backward Traversal**: Iterate through the string from the end, comparing each Roman numeral's value with the previous one.
2. **Check Value Relation**:
    - If the current value is greater than the previous one, subtract the previous value from the current value.
    - Otherwise, add the current value to the sum.
3. **Sum Calculation**: Keep a running sum of the converted values.

## Complexity Analysis

- **Time Complexity**: `O(n)`
    - Iterates through the string of length `n` once.
- **Space Complexity**: `O(1)`
    - Uses constant extra space.

## Usage

1. Clone or download the repository.
2. Compile and run the Java file using your preferred IDE or command line.

## LeetCode Problem Link

[13. Roman to Integer](https://leetcode.com/problems/roman-to-integer/description/)
