
# Isomorphic Strings

This project provides a solution to the LeetCode problem **205. Isomorphic Strings**.

## Problem Description

Given two strings `s` and `t`, determine if they are isomorphic.

Two strings `s` and `t` are isomorphic if the characters in `s` can be replaced to get `t`. All occurrences of a character must be replaced with another character while preserving the order of characters. No two characters may map to the same character, but a character may map to itself.

### Example

Input:
```
s = "foo", t = "bar"
```

Output:
```
false
```

## Solution

### Approach: Character Mapping with Arrays

This approach uses two arrays to track the mapping of characters from `s` to `t` and `t` to `s`. The indices of characters are stored, and mismatches are checked during traversal.

### Code:
```java[]
public class IsomorphicStrings {
    public static void main(String[] args) {
        String s = "foo", t = "bar";
        System.out.println(isIsomorphic(s, t));
    }

    static boolean isIsomorphic(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        int[] sChar = new int[256];
        int[] tChar = new int[256];
        for (int i = 0; i < s.length(); i++) {
            if (sChar[s.charAt(i)] != tChar[t.charAt(i)]) {
                return false;
            }
            sChar[s.charAt(i)] = i + 1;
            tChar[t.charAt(i)] = i + 1;
        }
        return true;
    }
}
```

## How It Works

1. **Length Check**: If `s` and `t` have different lengths, return `false`.
2. **Character Mapping**: Use two arrays to track the latest indices of characters in `s` and `t`.
3. **Validation**: During traversal, ensure the mappings are consistent.
4. **Update Mapping**: Update the indices in both arrays.

## Complexity Analysis

- **Time Complexity**: `O(n)`
    - Iterates through the strings once.
- **Space Complexity**: `O(1)`
    - Uses fixed-size arrays of length 256.

## Usage

1. Clone or download the repository.
2. Compile and run the Java file using your preferred IDE or command line.

## LeetCode Problem Link

[205. Isomorphic Strings](https://leetcode.com/problems/isomorphic-strings/description/)
