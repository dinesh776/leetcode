# Counting Words With a Given Prefix

## Problem Description
[Counting Words With a Given Prefix](https://leetcode.com/problems/counting-words-with-a-given-prefix/description/?envType=daily-question&envId=2025-01-09)

You are given an array of strings `words` and a string `pref`. Determine the number of strings in the array `words` that start with the given prefix `pref`.

## Example
### Input
```java[]
String[] words = {"pay", "attention", "practice", "attend"};
String pref = "at";
```
### Output
```java[]
2
```

## Solution
The solution iterates through the array of words and counts how many of them start with the given prefix using the `startsWith` method.

### Code Example
```java[]
public class CountWordsWithAGivenPrefix {
    public static void main(String[] args) {
        String pref = "at";
        String[] words = {"pay", "attention", "practice", "attend"};
        System.out.println(prefixCount(words, pref));
    }

    static int prefixCount(String[] words, String pref) {
        int c = 0;
        for (String word : words) {
            if (word.startsWith(pref)) {
                c++;
            }
        }
        return c;
    }
}
```

## How It Works
1. **Iterate Through Words**: For each word in the `words` array, check if it starts with the prefix `pref` using the `startsWith` method.
2. **Increment Counter**: If the word starts with the prefix, increment the counter.
3. **Return Result**: After checking all words, return the final count.

### Complexity Analysis
- **Time Complexity**: `O(n * m)`, where `n` is the number of words and `m` is the average length of the words. This is due to the prefix comparison.
- **Space Complexity**: `O(1)`, as no additional space is used apart from a counter.

## Usage
The function `prefixCount(String[] words, String pref)` takes an array of strings and a prefix as input and returns the count of words that start with the prefix.

