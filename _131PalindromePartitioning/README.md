# Palindrome Partitioning

## Problem Description
The problem requires partitioning a given string into all possible palindrome substrings. A palindrome is a string that reads the same forward and backward. Each partition must contain only palindromic substrings.

**LeetCode Problem:** [131. Palindrome Partitioning](https://leetcode.com/problems/palindrome-partitioning/description/)

## Example
### Input:
```java[]
String s = "aab";
System.out.println(partition(s));
```
### Output:
```[]
[["a","a","b"],["aa","b"]]
```
### Explanation:
- "a | a | b" → All substrings are palindromes.
- "aa | b" → Both substrings are palindromes.

## Solution Approach
The solution is implemented using **Backtracking**:
1. Iterate over possible partitions of the string.
2. Check if each partition is a palindrome.
3. If it is, recursively proceed with the remaining substring.
4. If the end of the string is reached, store the valid partition.

## Code Example
```java[]
import java.util.ArrayList;
import java.util.List;

public class palindromePartitioning {
    public static void main(String[] args) {
        String s = "aab";
        System.out.println(partition(s));
    }

    public static List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        helper(s, 0, new ArrayList<>(), res);
        return res;
    }

    public static void helper(String s, int index, ArrayList<String> path, List<List<String>> res) {
        if (index == s.length()) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = index; i < s.length(); i++) {
            if (isPalindrome(s, index, i)) {
                path.add(s.substring(index, i + 1));
                helper(s, i + 1, path, res);
                path.remove(path.size() - 1);
            }
        }
    }

    public static boolean isPalindrome(String s, int start, int end) {
        while (start <= end) {
            if (s.charAt(start++) != s.charAt(end--)) {
                return false;
            }
        }
        return true;
    }
}
```

## How It Works
- The `partition` function initializes the result list and calls the recursive helper function.
- The `helper` function generates all possible partitions using **backtracking**.
- The `isPalindrome` function checks whether a substring is a palindrome.

## Complexity Analysis
- **Time Complexity:** `O(N * 2^N)`, since each character can either be included in the same partition or start a new partition.
- **Space Complexity:** `O(N)`, considering the recursive stack depth.

## Usage
Run the Java file in a Java-supported environment to see all possible palindrome partitions for the given input string.

## Tags
`Backtracking` `Palindrome` `Recursion` `String Manipulation`

