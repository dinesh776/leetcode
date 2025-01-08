# Count Prefix and Suffix Pairs I

## Problem Description
[Count Prefix and Suffix Pairs I](https://leetcode.com/problems/count-prefix-and-suffix-pairs-i/description/?envType=daily-question&envId=2025-01-08)

You are given an array of strings `words`. Count the number of pairs `(i, j)` where `i < j` such that:
- `words[j]` starts with `words[i]`.
- `words[j]` ends with `words[i]`.

## Example
### Input
```java[]
String[] words = {"abab", "ab"};
```
### Output
```java[]
1
```

## Solution
The solution iterates through all possible pairs `(i, j)` of words in the array. For each pair, it checks whether the second word `words[j]` starts and ends with the first word `words[i]`. This can be done using the `startsWith` and `endsWith` methods provided by Java's `String` class.

### Code Example
```java[]
public class CountPrefixAndSuffixPairs1 {
    public static void main(String[] args) {
        String[] words = {"abab", "ab"};
        System.out.println(countPrefixSuffixPairs(words));
    }

    static int countPrefixSuffixPairs(String[] words) {
        int c = 0;
        int n = words.length;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (isPrefixAndSuffix(words[i], words[j])) {
                    c++;
                }
            }
        }
        return c;
    }

    static boolean isPrefixAndSuffix(String word, String target) {
        return target.startsWith(word) && target.endsWith(word);
    }
}
```

## How It Works
1. **Nested Loops**: The outer loop iterates through each word `words[i]`.
2. **Check Pairs**: The inner loop checks pairs `(i, j)` with `j > i` to ensure unique combinations.
3. **Prefix and Suffix Check**: The helper method `isPrefixAndSuffix` uses `startsWith` and `endsWith` to verify whether `words[j]` starts and ends with `words[i]`.

### Complexity Analysis
- **Time Complexity**: `O(n^2)` where `n` is the number of words in the array. This is due to the nested loops for pair checking.
- **Space Complexity**: `O(1)` as no additional data structures are used.

## Usage
The function `countPrefixSuffixPairs(String[] words)` takes an array of strings and returns the count of valid prefix-suffix pairs.

