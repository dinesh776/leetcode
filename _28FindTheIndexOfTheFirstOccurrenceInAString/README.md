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



## Complexity Analysis

- **Time Complexity:** 
   - Built-in indexOf: O(n * m) where n is the length of `haystack` and m is the length of `needle`.
   - Brute Force: O(n * m)
  - KMP: O(n + m)
- **Space Complexity:** 
  - Built-in indexOf and Brute Force: O(1)
  - KMP: O(m) for the LPS array.

## Explanation

1. **Built-in Function Approach (`indexOf`)**:
  This is the simplest approach. Java provides a built-in method indexOf for strings, which searches for a substring within a string and returns the index of the first occurrence.

   - How it works:
     - The indexOf function scans through the haystack string and looks for a match with the needle.
     - If found, it returns the index where the needle starts within the haystack.
     - If not found, it returns -1.
   - Advantages:
     - Very concise and easy to implement.
     - Efficient for simple use cases.
   - Disadvantages:
     - This method might not be the most efficient for large inputs because it doesn't implement optimizations like KMP (Knuth-Morris-Pratt) algorithm.
2. **Brute Force Approach:**
   The brute force approach checks each possible substring in haystack of the same length as needle and compares character by character.

   - How it works:
      - We iterate over each index in the haystack, where the remaining length is greater than or equal to the length of needle.
      - For each index, we compare the substring starting from that index with needle character by character.
      - If all characters match, we return the starting index.
      - If no match is found after checking all positions, return -1.
   - Advantages:
      - Simple to understand and implement.
   - Disadvantages:
      - This approach has a time complexity of O(n * m), where n is the length of haystack and m is the length of needle. This can be slow for large inputs, as it involves a lot of repeated comparisons.
3. **KMP (Knuth-Morris-Pratt) Algorithm:**
   The KMP algorithm is an optimized pattern-searching algorithm. It uses information from previous failed comparisons to avoid redundant checks, which significantly speeds up the search process.

   - How it works:
      1) Preprocess the needle string:
         - We create an array LPS (Longest Prefix which is also Suffix) that helps in determining how much we can skip after a mismatch.
         - This array is built in O(m) time, where m is the length of the needle.
      2) Search in haystack:
         - We use the LPS array to jump over unnecessary comparisons when we encounter mismatches in haystack.
         - When characters from haystack and needle match, we continue. If a mismatch happens, we use the LPS array to skip part of the search.
         - This ensures that the overall time complexity is reduced to O(n + m), making it much faster for larger inputs.
      - Advantages:
        - Significantly faster for large inputs compared to the brute force method.
        - Reduces the number of comparisons by using the LPS array.
      - Disadvantages:
        - Slightly more complex to implement and understand than the brute force approach.
## KMP in Action
   Here's an example of how the KMP algorithm processes the needle and haystack:

   - For haystack = "abcxabcdabcdabcy" and needle = "abcdabcy", the algorithm:
      1) Precomputes the LPS array for needle:
         - LPS = [0, 0, 0, 0, 1, 2, 3]
      2) Uses this array to skip redundant comparisons while searching through haystack.
      3) Finds that needle starts at index 8 in haystack.
## Why KMP is Better:
- In the brute force approach, when there’s a mismatch, you start the comparison all over again from the next index in haystack.
- KMP optimizes this by using the LPS array to skip over unnecessary comparisons, making the search faster in many cases.
## Conclusion
For smaller or simpler inputs, the built-in indexOf function works well. For larger inputs where efficiency is crucial, the KMP algorithm is a better choice due to its optimized time complexity.

## How to Use

To run the solution, simply compile and execute the `FindTheIndexOfTheFirstOccurrenceInAString` class in your Java environment.
- ```bash
  javac FindTheIndexOfTheFirstOccurrenceInAString.java
  java FindTheIndexOfTheFirstOccurrenceInAString
