# String Matching in an Array

## Problem Description
[String Matching in an Array](https://leetcode.com/problems/string-matching-in-an-array/description/?envType=daily-question&envId=2025-01-07)

Given an array of strings `words`, find all the strings in `words` that are substrings of another string in the array. Return all such strings in a list. The returned strings should not contain duplicates.

## Example
### Input
```java[]
String[] words = {"blue", "green", "bu"};
```
### Output
```java[]
["bu"]
```

## Solution
The solution involves iterating over all pairs of strings in the `words` array. For each pair, check if one string is a substring of the other. If a string is a substring, add it to the result list.

### Code Example
```java[]
import java.util.ArrayList;
import java.util.List;

public class StringMatchingInAnArray {
    public static void main(String[] args) {
        String[] words = {"blue", "green", "bu"};
        System.out.println(stringMatching(words));
    }

    static List<String> stringMatching(String[] words) {
        List<String> list = new ArrayList<>();
        int n = words.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i != j && words[j].contains(words[i])) {
                    list.add(words[i]);
                    break;
                }
            }
        }
        return list;
    }
}
```

## How It Works
1. **Iterate Over Pairs**: The nested loop iterates through all pairs of strings in the `words` array.
2. **Substring Check**: For each pair of strings `(i, j)`, check if `words[i]` is a substring of `words[j]`.
3. **Avoid Duplicates**: Use `break` to ensure each string is added to the result list only once.

### Complexity Analysis
- **Time Complexity**: `O(n^2 * k)`, where `n` is the number of strings in the array and `k` is the average length of a string. The `contains` method has a complexity proportional to the length of the strings.
- **Space Complexity**: `O(r)`, where `r` is the size of the result list.

## Usage
The function `stringMatching(String[] words)` takes an array of strings as input and returns a list of strings that are substrings of another string in the array.
