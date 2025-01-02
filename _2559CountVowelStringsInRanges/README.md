# Count Vowel Strings in Ranges

## Problem Description
[Count Vowel Strings in Ranges](https://leetcode.com/problems/count-vowel-strings-in-ranges/description/?envType=daily-question&envId=2025-01-02)

You are given an array of strings `words` and a 2D array `queries`. Each query consists of two indices `[l, r]`. Determine the number of strings in the subarray `words[l..r]` that both:
- Start with a vowel (one of `a`, `e`, `i`, `o`, `u`), and
- End with a vowel.

## Example
### Input
```java[]
String[] words = {"aba", "bcb", "ece", "aa", "e"};
int[][] queries = {{0, 2}, {1, 4}, {1, 1}};
```
### Output
```java[]
[2, 3, 0]
```

## Solution
The solution involves preprocessing the input array `words` into a prefix sum array, where each position stores the count of vowel strings encountered so far. This enables efficient computation of the number of vowel strings within any range specified in `queries`.

### Code Example
```java[]
import java.util.Arrays;

public class CountVowelStringsInRange {
    public static void main(String[] args) {
        String[] words = {"aba", "bcb", "ece", "aa", "e"};
        int[][] queries = {{0, 2}, {1, 4}, {1, 1}};
        System.out.println(Arrays.toString(vowelStrings(words, queries)));
    }

    static int[] vowelStrings(String[] words, int[][] queries) {
        int n = queries.length, k = 0, m = words.length;
        int[] prefixSum = new int[m + 1];
        for (int j = 0; j < m; j++) {
            if (isVowel(words[j].charAt(0)) && isVowel(words[j].charAt(words[j].length() - 1))) {
                prefixSum[j + 1] = prefixSum[j] + 1;
            } else {
                prefixSum[j + 1] = prefixSum[j];
            }
        }

        int[] result = new int[n];
        for (int[] query : queries) {
            result[k++] = prefixSum[query[1] + 1] - prefixSum[query[0]];
        }
        return result;
    }

    static boolean isVowel(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }
}
```

## How It Works
1. **Prefix Sum Array**: The `prefixSum` array stores the cumulative count of vowel strings up to each index.
2. **Efficient Range Queries**: For each query `[l, r]`, compute the result as:
   ```java[]
   prefixSum[r + 1] - prefixSum[l]
   ```
   This gives the count of vowel strings in the range `l` to `r`.
3. **Helper Function**: The function `isVowel` determines whether a character is a vowel.

### Complexity Analysis
- **Preprocessing Time Complexity**: `O(m)`, where `m` is the number of words in the `words` array.
- **Query Time Complexity**: `O(n)`, where `n` is the number of queries.
- **Space Complexity**: `O(m)`, for the `prefixSum` array.

## Usage
The function `vowelStrings(String[] words, int[][] queries)` takes an array of strings and a 2D query array as input and returns an array of integers representing the results for each query.

