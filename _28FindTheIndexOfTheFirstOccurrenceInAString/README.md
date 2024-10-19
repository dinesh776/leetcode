# 28. Find the Index of the First Occurrence in a String

This repository contains a solution to the LeetCode problem [Find the Index of the First Occurrence in a String,](https://leetcode.com/problems/find-the-index-of-the-first-occurrence-in-a-string/description/), implemented in Java.

## Problem Description

You are given two strings, `haystack` and `needle`. You need to find the index of the first occurrence of `needle` in `haystack`, or return `-1` if `needle` is not part of `haystack`.

### Example

**Input:**

- ```java
    haystack = "leetcode", needle = "code"

**Output:**
-  ```java
    4

## Explanation

After removing all occurrences of 2, the new length of the array is 5, and the modified array could be [0, 1, 4, 3, 0, _, _, _] (the actual values beyond the new length can be ignored).

## Solution

This problem can be solved using the built-in indexOf function or using more optimized algorithms like Brute Force or Knuth-Morris-Pratt (KMP) pattern matching algorithm.


## Code Example

- ```java
    public class FindTheIndexOfTheFirstOccurrenceInAString {
       public static void main(String[] args) {
           String haystack = "leetcode", needle = "code";
           System.out.println(strStr(haystack, needle));
       }
   
       static int strStr(String haystack, String needle) {
           return haystack.indexOf(needle);
       }
   }

## Alternative Solutions
- Brute Force Approach:
   - ```java
     static int strStrBruteForce(String haystack, String needle) {
        int n = needle.length(), i, j;
         for (i = 0; i <= haystack.length() - n; i++) {
            for (j = 0; j < n; j++) {
               if (haystack.charAt(i + j) != needle.charAt(j)) {
                  break;
               }
            }
            if (j == n) {
               return i;
            }
         }
        return -1;
      }
- Knuth-Morris-Pratt (KMP) Algorithm:
  - ```java
    static int strStrKMP(String haystack, String needle) {
       int[] lps = new int[needle.length()];
       int i = 1, prev = 0;
       while (i < needle.length()) {
          if (needle.charAt(i) == needle.charAt(prev)) {
            lps[i++] = ++prev;
          } else if (prev == 0) {
            lps[i++] = 0;
          } else {
            prev = lps[prev - 1];
          }
       }

       int k = 0, j = 0;
       while (k < haystack.length()) {
         if (haystack.charAt(k) == needle.charAt(j)) {
            k++;
            j++;
            } else {
               if (j == 0) {
                  k++;
                  } else {
                  j = lps[j - 1];
               }
            }
            if (j == needle.length()) {
                  return k - needle.length();
               }
            }
         return -1;
       }


## How it Works

1. **Built-in Function:** The built-in `indexOf` method returns the index of the first occurrence of a substring within another string. If the substring is not found, it returns `-1`.
2. **Brute Force Approach:** 
   1) Loop through `haystack`, checking each substring of the same length as `needle`.
   2) If all characters match, return the starting index.
   3) If no match is found, return `-1`.
3. **KMP Algorithm:** \
   1) Preprocess `needle` to build a "Longest Prefix which is also Suffix" (LPS) array.
   2) Use the LPS array to skip unnecessary comparisons while searching through `haystack`.

## How to Use

To run the solution, simply compile and execute the `FindTheIndexOfTheFirstOccurrenceInAString` class in your Java environment.
- ```bash
  javac FindTheIndexOfTheFirstOccurrenceInAString.java
  java FindTheIndexOfTheFirstOccurrenceInAString


## Complexity Analysis

- **Time Complexity:** 
   - Built-in indexOf: O(n * m) where n is the length of `haystack` and m is the length of `needle`.
   - Brute Force: O(n * m)
  - KMP: O(n + m)
- **Space Complexity:** 
  - Built-in indexOf and Brute Force: O(1)
  - KMP: O(m) for the LPS array.