# Number of Substrings Containing All Three Characters

## Problem Description

- **Problem Title:** Number of Substrings Containing All Three Characters
- **Problem Link:** [1358. Number of Substrings Containing All Three Characters](https://leetcode.com/problems/number-of-substrings-containing-all-three-characters/description/)
- **Difficulty:** Medium

## Problem Statement
Given a string `s` consisting only of characters `a`, `b`, and `c`, return the number of substrings containing at least one occurrence of all three characters `a`, `b`, and `c`.

## Example

```java[]
Input: s = "abcabc"
Output: 10
Explanation: The substrings containing at least one occurrence of all three characters are:
"abc", "abca", "abcab", "abcabc", "bca", "bcab", "bcabc", "cab", "cabc", "abc".
```

## Solution

### Approach
1. Use an array `lastSeen` to track the most recent index of each character `a`, `b`, and `c`.
2. Iterate through the string while updating the `lastSeen` indices for each character.
3. Calculate the count of substrings ending at the current position that contain all three characters.

## Code Implementation

```java[]
public class NumberOfSubstringsContaingAllThreeCharacters {
    public static void main(String[] args) {
        String s = "abcabc";
        System.out.println(numberOfSubstrings(s));
    }

    static int numberOfSubstrings(String s) {
        int ct = 0;
        int[] lastSeen = {-1, -1, -1};
        for (int i = 0; i < s.length(); i++) {
            lastSeen[s.charAt(i) - 'a'] = i;
            ct += (1 + Math.min(lastSeen[0], Math.min(lastSeen[1], lastSeen[2])));
        }
        return ct;
    }
}
```

## How It Works
1. `lastSeen` tracks the most recent index for characters `a`, `b`, and `c`.
2. For every character in the string:
    - Update its last-seen index in the array.
    - Calculate the minimum of the indices of all three characters.
    - Add the count of substrings ending at the current index that contain all three characters to `ct`.

## Usage
This program can be used to solve the problem where a string needs to be analyzed for the presence of all specific characters within substrings efficiently.

## Complexity Analysis
- **Time Complexity:** The single pass through the string results in O(n).
- **Space Complexity:** Only constant extra space is used for the `lastSeen` array and variables.
