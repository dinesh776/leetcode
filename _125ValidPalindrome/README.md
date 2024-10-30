
# Valid Palindrome

This repository contains a solution to the LeetCode problem [Valid Palindrome](https://leetcode.com/problems/valid-palindrome/description/), implemented in Java.

## Problem Description

Given a string `s`, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases. A palindrome reads the same forward and backward.

### Example

**Input:**
```java[]
s = "0P"
```

**Output:**
```java[]
false
```

## Explanation:
The function considers only alphanumeric characters and ignores cases. In this case, the processed string does not read the same forward and backward.

## Solution

This solution iterates through the string with two pointers from the start and end, checking characters to confirm if they match. Non-alphanumeric characters are skipped. The string is converted to lowercase to avoid case sensitivity issues.

## Code Example

```java[]
public class ValidPalindrome {
    public static void main(String[] args) {
        String s = "0P";
        System.out.println(isPalindrome(s));
    }

    static boolean isPalindrome(String s) {
        s = s.toLowerCase();
        int r = s.length() - 1, i = 0;
        while (i <= r) {
            char s1 = s.charAt(i), s2 = s.charAt(r);
            if (!(s1 >= 'a' && s1 <= 'z') && !(s1 >= '0' && s1 <= '9')) {
                i++;
            } else if (!(s2 >= 'a' && s2 <= 'z') && !(s2 >= '0' && s2 <= '9')) {
                r--;
            } else {
                if (s1 == s2) {
                    i++;
                    r--;
                } else {
                    return false;
                }
            }
        }
        return true;
    }
}
```

## How it Works

- **Two Pointers:** The `isPalindrome` method uses two pointers, `i` and `r`, starting at the beginning and end of the string, respectively.
- **Character Matching:** Only alphanumeric characters are considered for comparison. If a match fails, the function returns `false`, otherwise, it continues to check until all characters match.

## How to Use

To run the solution, compile and execute the `ValidPalindrome` class in your Java environment:

```bash[]
javac ValidPalindrome.java
java ValidPalindrome
```

This will output `true` if the string is a valid palindrome, and `false` otherwise.

## Complexity Analysis

- **Time Complexity:** O(n), where `n` is the length of the string, as each character is processed once.
- **Space Complexity:** O(1), as no extra data structures are used.
