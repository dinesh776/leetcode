# Keyboard Row

## Problem Description
[Keyboard Row](https://leetcode.com/problems/keyboard-row/description/)

Given an array of strings `words`, return the words that can be typed using letters of only one row on a keyboard. Assume the keyboard layout consists of the following rows:
- First row: `"qwertyuiop"`
- Second row: `"asdfghjkl"`
- Third row: `"zxcvbnm"`

## Example
### Input
```java[]
String[] words = {"asdfghjklASDFGHJKL", "qwertyuiopQWERTYUIOP", "zxcvbnmZXCVBNM"};
```
### Output
```java[]
["asdfghjklASDFGHJKL", "qwertyuiopQWERTYUIOP", "zxcvbnmZXCVBNM"]
```

## Solution
The solution involves checking each word to ensure that all its characters belong to the same keyboard row. For this purpose, each character is mapped to its corresponding row.

### Code Example
```java[]
import java.util.Arrays;

public class KeyboardRow {
    public static void main(String[] args) {
        String[] words = {"asdfghjklASDFGHJKL", "qwertyuiopQWERTYUIOP", "zxcvbnmZXCVBNM"};
        System.out.println(Arrays.toString(findWords(words)));
    }

    static String[] findWords(String[] words) {
        String[] res = new String[words.length];
        int k = 0;
        for (String word : words) {
            String temp = word.toLowerCase();
            int in = 1;
            int firstCharRow = rowCheck(temp.charAt(0));
            for (int i = 1; i < word.length(); i++) {
                int row = rowCheck(temp.charAt(i));
                if (row != firstCharRow) {
                    in = 0;
                    break;
                }
            }
            if (in == 1) {
                res[k++] = word;
            }
        }
        return Arrays.copyOf(res, k);
    }

    static int rowCheck(char c) {
        String firstRow = "qwertyuiop";
        String secondRow = "asdfghjkl";
        String thirdRow = "zxcvbnm";
        if (firstRow.contains(String.valueOf(c))) {
            return 1;
        } else if (secondRow.contains(String.valueOf(c))) {
            return 2;
        } else {
            return 3;
        }
    }
}
```

## How It Works
1. **Character Row Mapping**: The function `rowCheck` maps each character to its respective keyboard row.
2. **Row Consistency Check**: For each word, all characters are checked to ensure they belong to the same row. If they do, the word is included in the result.
3. **Result Construction**: The result array is dynamically updated to include only valid words.

### Complexity Analysis
- **Time Complexity**: `O(n * m)`, where `n` is the number of words and `m` is the average length of a word. Each character is checked for its keyboard row.
- **Space Complexity**: `O(k)`, where `k` is the number of valid words in the result array.

## Usage
The function `findWords(String[] words)` takes an array of strings and returns an array containing words that can be typed using a single keyboard row.

