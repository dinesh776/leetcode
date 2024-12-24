# Longest Repeating Character Replacement

## Problem Description
Given a string `s` and an integer `k`, you are allowed to replace at most `k` characters in the string so that the resultant string contains the longest contiguous block of the same character. Return the length of such a block.

Problem Link: [Longest Repeating Character Replacement](https://leetcode.com/problems/longest-repeating-character-replacement/description/)

---

## Example

**Input:**
```java[]
String s = "ABBB";
int k = 2;
```

**Output:**
```
4
```

---

## Solution

### Approach
This solution uses a sliding window approach to find the longest contiguous substring of the same character after replacing at most `k` characters.

### Algorithm
1. Use two pointers, `i` and `j`, to define the sliding window.
2. Maintain a frequency array `hash` to store the frequency of characters in the current window.
3. Track the maximum frequency of any character in the window with `maxFreq`.
4. Adjust the window size such that the number of characters that need to be replaced (`(j - i + 1 - maxFreq)`) does not exceed `k`.
5. Update the maximum length of the substring (`maxLen`) as you iterate.

### Code
```java[]
public class longestRepeatingCharacter {
    public static void main(String[] args) {
        String s = "ABBB";
        int k = 2;
        System.out.println(characterReplacement(s, k));
    }

    static int characterReplacement(String s, int k) {
        int maxFreq = 0, maxLen = 0;
        int i = 0, j = 0;
        int[] hash = new int[26];

        while (j < s.length()) {
            hash[s.charAt(j) - 'A']++;
            maxFreq = Math.max(maxFreq, hash[s.charAt(j) - 'A']);

            while ((j - i + 1 - maxFreq) > k) {
                hash[s.charAt(i) - 'A']--;
                i++;
            }

            if ((j - i + 1 - maxFreq) <= k) {
                maxLen = Math.max(maxLen, (j - i + 1));
            }

            j++;
        }

        return maxLen;
    }
}
```

---

## Complexity Analysis

### Time Complexity
- **O(n)**: The sliding window iterates through the string once, and the internal operations are constant time.

### Space Complexity
- **O(1)**: A fixed array of size 26 is used for the frequency count.

---

## How It Works
1. **Initialize Variables**: Set pointers `i` and `j` to the start of the string and create a frequency array `hash`.
2. **Expand Window**: Increment `j` to add characters to the current window.
3. **Update Maximum Frequency**: Track the most frequent character in the current window.
4. **Adjust Window**: Shrink the window from the left if the number of replacements exceeds `k`.
5. **Calculate Max Length**: At each step, update the maximum length of a valid window.

---

## Usage
To test the code, run the `main` method and provide inputs directly in the code.

---

## Additional Notes
- This solution efficiently handles large strings due to its linear time complexity.
- Edge cases like empty strings or `k = 0` are handled implicitly by the algorithm.
