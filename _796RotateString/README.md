
# Rotate String

This project provides a solution to the LeetCode problem **796. Rotate String**.

## Problem Description

Given two strings `s` and `goal`, return `true` if and only if `s` can become `goal` after some number of shifts on `s`.

A shift on `s` consists of moving the leftmost character of `s` to the rightmost position. For example, if `s = "abcde"`, then it will be `"bcdea"` after one shift.

### Example

Input:
```
s = "abcde", goal = "cdeab"
```

Output:
```
true
```

## Solution

The solution checks if `goal` is a substring of the concatenation of `s` with itself (`s + s`). If `s` and `goal` are of different lengths, it directly returns `false`.

## Code Example

```java[]
public class RotateString {
    public static void main(String[] args) {
        String s = "abcde", goal = "cdeab";
        System.out.println(rotateString(s, goal));
    }
    static boolean rotateString(String s, String goal) {
        if (s.length() != goal.length()) {
            return false;
        }
        String doubleS = s + s;
        return doubleS.contains(goal);
    }
}
```

## How It Works

1. **Length Check**: If the lengths of `s` and `goal` are not equal, return `false`.
2. **Concatenation**: Create a new string `doubleS` by concatenating `s` with itself.
3. **Substring Check**: Check if `goal` is a substring of `doubleS`.

## Usage

1. Clone or download the repository.
2. Compile and run the Java file using your preferred IDE or command line.

## Complexity Analysis

- **Time Complexity**: `O(n)`, where `n` is the length of the string `s`.
- **Space Complexity**: `O(n)`, due to the creation of the concatenated string.

## LeetCode Problem Link

[796. Rotate String](https://leetcode.com/problems/rotate-string/description/)
