
# Valid Anagram

This project provides a solution to the LeetCode problem **242. Valid Anagram**.

## Problem Description

Given two strings `s1` and `s2`, return `true` if `s2` is an anagram of `s1`, and `false` otherwise.

An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase, using all the original letters exactly once.

### Example

Input:
```
s1 = "aa", s2 = "bb"
```

Output:
```
false
```

## Solution

The solution includes multiple approaches to determine if two strings are anagrams, each with varying runtime and complexity.

### Approach 1: Optimized (1ms)
- Uses a fixed-size array to count character frequencies.
- Compares frequencies in `s1` and `s2`.

#### Code:
```java[]
static boolean isAnagram(String s1, String s2) {
    if (s1.length() != s2.length()) return false;
    int[] map = new int[26];
    for (char ch : s1.toCharArray()) {
        map[ch - 'a']++;
    }
    for (char ch : s2.toCharArray()) {
        map[ch - 'a']--;
    }
    for (int x : map) {
        if (x != 0) return false;
    }
    return true;
}
```
- **Time Complexity**: `O(n)`
- **Space Complexity**: `O(1)`

### Approach 2: Balanced Count (5ms)
- Counts and balances character frequencies in a single loop.

#### Code:
```java[]
static boolean isAnagram(String s1, String s2) {
    if (s1.length() != s2.length()) return false;
    int[] map = new int[26];
    for (int i = 0; i < s1.length(); i++) {
        map[s1.charAt(i) - 97]++;
        map[s2.charAt(i) - 97]--;
    }
    for (int x : map) {
        if (x != 0) return false;
    }
    return true;
}
```
- **Time Complexity**: `O(n)`
- **Space Complexity**: `O(1)`

### Approach 3: HashMap Frequency Balance (16ms)
- Uses a single `HashMap` to count and balance character frequencies.

#### Code:
```java[]
static boolean isAnagram(String s1, String s2) {
    if (s1.length() != s2.length()) return false;
    HashMap<Character, Integer> map = new HashMap<>();
    for (int i = 0; i < s1.length(); i++) {
        map.put(s1.charAt(i), map.getOrDefault(s1.charAt(i), 0) + 1);
        map.put(s2.charAt(i), map.getOrDefault(s2.charAt(i), 0) - 1);
    }
    for (int val : map.values()) {
        if (val != 0) return false;
    }
    return true;
}
```
- **Time Complexity**: `O(n)`
- **Space Complexity**: `O(n)`

### Approach 4: Dual HashMaps (27ms)
- Creates two `HashMaps` for both strings and compares their values.

#### Code:
```java[]
static boolean isAnagram(String s1, String s2) {
    if (s1.length() != s2.length()) return false;
    HashMap<Character, Integer> map1 = new HashMap<>();
    HashMap<Character, Integer> map2 = new HashMap<>();
    for (int i = 0; i < s1.length(); i++) {
        map1.put(s1.charAt(i), map1.getOrDefault(s1.charAt(i), 0) + 1);
        map2.put(s2.charAt(i), map2.getOrDefault(s2.charAt(i), 0) + 1);
    }
    for (char c : map1.keySet()) {
        if (!map1.get(c).equals(map2.get(c))) {
            return false;
        }
    }
    return true;
}
```
- **Time Complexity**: `O(n)`
- **Space Complexity**: `O(n)`

## Usage

1. Clone or download the repository.
2. Compile and run the Java file using your preferred IDE or command line.

## Complexity Summary

| Approach              | Time Complexity | Space Complexity |
|-----------------------|-----------------|------------------|
| Optimized (1ms)       | O(n)            | O(1)             |
| Balanced Count (5ms)  | O(n)            | O(1)             |
| HashMap Balance (16ms)| O(n)            | O(n)             |
| Dual HashMaps (27ms)  | O(n)            | O(n)             |

## LeetCode Problem Link

[242. Valid Anagram](https://leetcode.com/problems/valid-anagram/description/)
