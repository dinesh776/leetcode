
# Longest Palindromic Substring

## Problem Description

Given a string `s`, return the longest palindromic substring in `s`. A palindrome is a string that reads the same forward and backward.

**Problem Link:** [5. Longest Palindromic Substring](https://leetcode.com/problems/longest-palindromic-substring/description/)

---

## Approach

The approach involves expanding around the center to identify both odd-length and even-length palindromes. For each character, we attempt to expand outward to find the maximum palindrome centered at that character (odd) or between that character and its next character (even).

---

## Implementation

```java[]
public class LongestPalindromicSubstring {
    public static void main(String[] args) {
        System.out.println(longestPalindrome("babad"));
    }

    public static String longestPalindrome(String s) {
        if (s == null || s.length() < 1) return "";

        int start = 0, end = 0;

        for (int i = 0; i < s.length(); i++) {
            // Expand for odd-length palindrome
            int len1 = expandAroundCenter(s, i, i);
            // Expand for even-length palindrome
            int len2 = expandAroundCenter(s, i, i + 1);

            // Get the maximum length
            int len = Math.max(len1, len2);

            // Update start and end indices if a longer palindrome is found
            if (len > end - start) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }

        return s.substring(start, end + 1);
    }

    // Expand around the given center and return the length of the palindrome
    private static int expandAroundCenter(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        return right - left - 1; // Length of the palindrome
    }
}
```

---

## Time Complexity
- **O(n²):** The algorithm expands around all centers, which results in O(n) centers, and each expansion takes O(n) time.

## Space Complexity
- **O(1):** The algorithm uses a constant amount of space.

---

## Examples

### Example 1
**Input:**
```
s = "babad"
```
**Output:**
```
"bab" or "aba"
```

### Example 2
**Input:**
```
s = "cbbd"
```
**Output:**
```
"bb"
```

### Example 3
**Input:**
```
s = "a"
```
**Output:**
```
"a"
```

### Example 4
**Input:**
```
s = "ac"
```
**Output:**
```
"a" or "c"
```

---

## How It Works
1. **Odd-Length Expansion:** Expand around each character as the center.
2. **Even-Length Expansion:** Expand around each pair of characters as the center.
3. **Track Maximum Length:** Update the start and end indices whenever a longer palindrome is found.
4. **Return Substring:** Extract and return the substring from the start to the end index.

---
