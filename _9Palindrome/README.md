
# Palindrome Number

This repository contains a solution to the LeetCode problem [Palindrome Number](https://leetcode.com/problems/palindrome-number/), implemented in Java.

## Problem Description

Determine whether an integer is a palindrome. An integer is a palindrome when it reads the same backward as forward.

- **Example:** 121 is a palindrome, while -121 is not.

### Example

**Input:**
```java[]
int x = 121;
```
**Output:**
```java[]
true
```

**Explanation:**

The number `121` reads the same backward and forward, so it is a palindrome.

## Solution

The solution works by reversing the digits of the input number `x` and comparing it to the original value. For negative numbers, the function immediately returns `false` since negative values cannot be palindromic.

## Code Example

```java[]
public class PalindromeNumber {
    public static void main(String[] args) {
        int x = 121;
        System.out.println(isPalindrome(x));
    }

    static boolean isPalindrome(int x) {
        int t = x, rev = 0;
        if (x < 0) {
            return false;
        }
        if(x==0)
            return true;
        while (x > 0) {
            rev = (rev * 10) + (x % 10);
            x /= 10;
        }
        return rev == t;
    }
}
```

## How it Works

- **Negative Check:** If `x` is negative, return `false` since negative numbers are not palindromic.
- **Reverse Integer:** The code iteratively builds the reversed integer by extracting digits from the end of `x` and adding them to `rev`.
- **Comparison:** The original integer `t` is compared to `rev`. If they are equal, `x` is a palindrome.

## How to Use

To run the solution, compile and execute the `PalindromeNumber` class in your Java environment:

```bash[]
javac PalindromeNumber.java
java PalindromeNumber
```
This will output `true` if the input integer is a palindrome, otherwise `false`.

## Complexity Analysis

- **Time Complexity:** O(log₁₀(x)), where `x` is the input integer. This is due to the number of digits in `x`, which determines the number of iterations.
- **Space Complexity:** O(1), as only a fixed amount of space is used.
