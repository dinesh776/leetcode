
# Letter Combinations of a Phone Number

## Problem Description

Given a string containing digits from 2-9 inclusive, return all possible letter combinations that the number could represent. The mapping of digit to letters (just like on the telephone buttons) is given below. Note that 1 does not map to any letters.

**Problem Link:** [17. Letter Combinations of a Phone Number](https://leetcode.com/problems/letter-combinations-of-a-phone-number/description/)

---

## Approach

### Implementation

```java[]
import java.util.ArrayList;
import java.util.List;

public class LetterCombinationsOfAPhoneNumber {
    public static void main(String[] args) {
        System.out.println(letterCombinations("23"));
    }

    // Run time: 5ms
    static List<String> letterCombinations(String digits) {
        if(digits.isEmpty()){
            return new ArrayList<>();
        }
        String[] mappings = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        ArrayList<String> list = new ArrayList<>();
        Permutations(list, "", digits, 0, mappings);
        return list;
    }

    static void Permutations(ArrayList<String> list, String p, String up, int index, String[] mappings) {
        if(index == up.length()){
            list.add(p);
            return;
        }
        int digit = up.charAt(index) - '0';
        String letters = mappings[digit];
        for(char ch : letters.toCharArray()){
            Permutations(list, p + ch, up, index + 1, mappings);
        }
    }
}
```

---

## Time and Space Complexity

- **Time Complexity:** O(3^n * 4^m), where n is the number of digits that map to 3 letters and m is the number of digits that map to 4 letters (e.g., 7 and 9).
- **Space Complexity:** O(n), where n is the length of the input string, due to the recursion stack.

---

## Examples

### Example 1
**Input:**
```
digits = "23"
```
**Output:**
```
["ad","ae","af","bd","be","bf","cd","ce","cf"]
```

### Example 2
**Input:**
```
digits = ""
```
**Output:**
```
[]
```

### Example 3
**Input:**
```
digits = "2"
```
**Output:**
```
["a","b","c"]
```

---

## How It Works

1. **Mapping Initialization:** The `mappings` array maps each digit from 2-9 to its corresponding letters.
2. **Recursion:** The `Permutations` method builds combinations recursively by appending each possible letter for the current digit.
3. **Base Case:** When the current index equals the length of the input string, the current combination is added to the list.
4. **Result Compilation:** The final list of combinations is returned.

---
