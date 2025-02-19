# Word Break (LeetCode 139)

## Problem Description
Given a string `s` and a list of words `wordDict`, determine if `s` can be segmented into a space-separated sequence of one or more dictionary words.

### Example
#### Input:
```java[]
s = "applepenapple"
wordDict = ["apple", "pen"]
```
#### Output:
```java[]
true
```
#### Explanation:
"applepenapple" can be segmented as "apple pen apple". Both "apple" and "pen" are in the dictionary.

## Solution Approach
This solution uses **memoization (top-down dynamic programming)** to efficiently check if the string can be segmented:
- A helper function recursively checks substrings from the start index.
- If a valid word is found in `wordDict`, it recursively checks the remaining part of the string.
- Intermediate results are stored in a **hash map (memoization)** to avoid redundant computations.

## Code Implementation
```java[]
import java.util.*;

public class WordBreak {
    public static void main(String[] args) {
        List<String> wordDict = List.of("apple", "pen");
        String s = "applepenapple";
        System.out.println(wordBreak(s, wordDict));
    }

    public static boolean wordBreak(String s, List<String> wordDict) {
        return helper(s, 0, wordDict, new HashMap<>());
    }

    private static boolean helper(String s, int start, List<String> wordDict, Map<Integer, Boolean> memo) {
        if (start == s.length()) {
            return true;
        }
        if (memo.containsKey(start)) {
            return memo.get(start);
        }
        for (int end = start + 1; end <= s.length(); end++) {
            String current = s.substring(start, end);
            if (wordDict.contains(current) && helper(s, end, wordDict, memo)) {
                memo.put(start, true);
                return true;
            }
        }
        memo.put(start, false);
        return false;
    }
}
```

## How It Works
1. The `wordBreak` function initiates the recursion with a memoization map.
2. The `helper` function checks substrings starting from each index.
3. If a substring matches a dictionary word and the remaining string can be broken, it returns `true`.
4. Otherwise, it stores the result in the memoization map to optimize performance.

## Complexity Analysis
- **Time Complexity**: `O(n^2)`, where `n` is the length of the string `s`. Each substring is checked once and stored in the memo.
- **Space Complexity**: `O(n)`, used for the memoization map.

## Usage
Run the `WordBreak` class in a Java environment to check if a given string can be broken into words from the dictionary.

---
This implementation optimally solves the **Word Break** problem using memoization to improve efficiency!
