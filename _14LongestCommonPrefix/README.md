# Longest Common Prefix

## Problem Description

Write a function to find the longest common prefix string amongst an array of strings. If there is no common prefix, return an empty string `""`.

**Problem Link:** [14. Longest Common Prefix](https://leetcode.com/problems/longest-common-prefix/description/)

---

## Approach

### Implementation

```java[]
public class LongestCommonPrefix {
    public static void main(String[] args) {
        String[] s = {"cir", "car"};
        System.out.println(longestCommonPrefix(s));
    }

    static String longestCommonPrefix(String[] strs) {
        String ans = "";
        int len = strs.length;
        for (int i = 0; i < strs[0].length(); i++) {
            int ct = 0;
            for (int j = 1; j < len; j++) {
                if (i < strs[j].length() && strs[j].charAt(i) == strs[0].charAt(i)) {
                    ct++;
                } else {
                    break;
                }
            }
            if (ct == len - 1) {
                ans += strs[0].charAt(i);
            } else {
                break;
            }
        }
        return ans;
    }
}
```

---

## Time Complexity
- **O(n \* m):** where `n` is the number of strings and `m` is the length of the shortest string. Each character in the strings is compared once.

## Space Complexity
- **O(1):** No additional space is used apart from variables.

---

## Examples

### Example 1
**Input:**
```
s = ["flower", "flow", "flight"]
```
**Output:**
```
"fl"
```

### Example 2
**Input:**
```
s = ["dog", "racecar", "car"]
```
**Output:**
```
""
```

**Explanation:** There is no common prefix among the input strings.

### Example 3
**Input:**
```
s = ["cir", "car"]
```
**Output:**
```
"c"
```

---

## How It Works
1. **Iterate Over Characters:** Traverse each character of the first string.
2. **Compare With Other Strings:** For each character, compare it with the corresponding character in all other strings.
3. **Update Prefix:** If all strings have the same character at the current position, add it to the prefix. Otherwise, stop the iteration.
4. **Return Result:** The accumulated prefix is the result.

---
