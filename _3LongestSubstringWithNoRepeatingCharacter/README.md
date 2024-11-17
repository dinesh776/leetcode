# Longest Substring Without Repeating Characters


This repository contains a solution to the LeetCode problem [Longest Substring Without Repeating Characters](https://leetcode.com/problems/longest-substring-without-repeating-characters/), implemented in Java.

## Problem Description

Given a string `s`, find the length of the longest substring that does not contain any repeating characters.

### Example

**Input:**
- ```java
  s = "pwwkew"


**Output:**
-  ```java
    3

## Explanation:
The longest substring without repeating characters is `"wke"` with a length of 3.

## Solution

The solution uses a sliding window approach to check each possible substring without repeating characters. By maintaining a hash array to record the last seen position of each character, we efficiently slide the window and update the maximum length.

## Code Example


- ```java
  import java.util.Arrays;

    public class LongestSubstringWithNoRepeatingCharacter {
    public static void main(String[] args) {
    String s = "pwwkew";
    System.out.println(maxLen(s));
    }

    static int maxLen(String s) {
        int[] hash = new int[256];
        Arrays.fill(hash, -1);
        int l = 0, r = 0, max_length = 0, n = s.length();
        while (r < n) {
            if (hash[s.charAt(r)] != -1 && hash[s.charAt(r)] >= l) {
                l = hash[s.charAt(r)] + 1;
            }
            max_length = Math.max(max_length, (r - l + 1));
            hash[s.charAt(r)] = r;
            r++;
        }
        return max_length;
    }
    }


## How it Works

- **Initialize Hash Array:** An integer array `hash` of size 256 is used to store the last seen positions of each character.
- **Sliding Window:** Two pointers, `l` and `r`, mark the boundaries of the substring. `l` moves right whenever a duplicate character is encountered.
- **Update Max Length:** For each position of `r`, calculate the current substring length and update `max_length` if the current length is longer.
- **Store Position:** Each character's last position is updated in the `hash` array.

## How to Use

To run the solution, compile and execute the `LongestSubstringWithNoRepeatingCharacter` class in your Java environment:

- ```bash
  javac LongestSubstringWithNoRepeatingCharacter.java
  java LongestSubstringWithNoRepeatingCharacter


This will output the length of the longest substring without repeating characters.

## Complexity Analysis

- **Time Complexity:** O(n), where n is the length of the string. Each character is processed once in the sliding window.
- **Space Complexity:** O(1), as the `hash` array is of fixed size.
