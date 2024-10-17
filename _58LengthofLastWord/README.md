# Length of Last Word

This repository contains a solution to the LeetCode problem [Length of Last Word](https://leetcode.com/problems/length-of-last-word/description/), implemented in Java.

## Problem Description

Given a string `s` consisting of words and spaces, return the length of the last word in the string.

A **word** is a maximal substring consisting of non-space characters only.

### Example

**Input:**

- ```java
    s = "luffy is still joyboy"
**Output:**
- ```java
  6

## Explanation

The last word is "joyboy", which has a length of 6.

## Solution

The solution splits the input string `s` into words using spaces as the delimiter and then returns the length of the last word. This is done in the `lengthOfLastWord` function.

## Code Example

- ```java
    public class LengthOfLastWord {
        public static void main(String[] args) {
            String s = "luffy is still joyboy";
            System.out.println(lengthOfLastWord(s)); // Output: 6
        }
    
        static int lengthOfLastWord(String s) {
            String[] arr = s.split(" ");
            return arr[arr.length - 1].length();
        }
    }

## How it Works

1. **Split the String:** The input string is split into an array of words using the `split()` method.
2. **Get the Last Word:** The last element of the array is selected as the last word.
3. **Return the Length:** The `length()` method is used to return the length of the last word.

## How to Use

To run the solution, simply compile and execute the `LengthOfLastWord` class in your Java environment.
- ```bash
  javac LengthOfLastWord.java
    java LengthOfLastWord
This will output the length of the last word in the provided string.

## Complexity Analysis

- **Time Complexity:** O(n) where n is the length of the input string, since we are splitting the string and accessing the last element of the resulting array.
- **Space Complexity:** O(n) due to the space required to store the array of words created by the `split()` method.
