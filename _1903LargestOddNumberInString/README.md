
# Largest Odd Number in String

This project provides a solution to the LeetCode problem **1903. Largest Odd Number in String**.

## Problem Description

You are given a string `num`, representing a large integer. Return the largest-valued odd integer (as a string) that is a non-empty substring of `num`. If no odd integer exists, return an empty string.

### Example

Input:
```
s = "239537672423884969653287101"
```

Output:
```
239537672423884969653287101
```

## Solution

The solution iteratively checks characters of the string from the end to the beginning. If the current character is an odd number, the substring from the start to that character is returned. If no odd character is found, an empty string is returned.

## Code Example

```java[]
public class LargestOddNumberInString {
    public static void main(String[] args) {
        String s = "239537672423884969653287101";
        System.out.println(largestOddNumber(s));
    }
    static String largestOddNumber(String num) {
        StringBuilder sb = new StringBuilder(num);
        for (int i = sb.length() - 1; i >= 0; i--) {
            if (Integer.parseInt(String.valueOf(sb.charAt(i))) % 2 == 1) {
                return sb.toString();
            } else {
                sb.deleteCharAt(i);
            }
        }
        return "";
    }
}
```

## How It Works

1. **Start from the End**: Traverse the string from the last character to the first.
2. **Check Oddness**: For each character, check if it represents an odd number.
3. **Return Result**: If an odd character is found, return the substring from the start to that character. Otherwise, return an empty string.

## Usage

1. Clone or download the repository.
2. Compile and run the Java file using your preferred IDE or command line.

## Complexity Analysis

- **Time Complexity**: `O(n)`, where `n` is the length of the string.
- **Space Complexity**: `O(n)`, due to the use of a `StringBuilder`.

## LeetCode Problem Link

[1903. Largest Odd Number in String](https://leetcode.com/problems/largest-odd-number-in-string/description/)
