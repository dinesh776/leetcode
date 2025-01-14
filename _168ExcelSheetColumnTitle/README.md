# Excel Sheet Column Title

## Problem Description
Given a positive integer `columnNumber`, return its corresponding column title as it appears in an Excel sheet. For example:

- 1 -> A
- 2 -> B
- 3 -> C
- ...
- 26 -> Z
- 27 -> AA
- 28 -> AB

### Problem Link
[Excel Sheet Column Title](https://leetcode.com/problems/excel-sheet-column-title/description/)

---

## Approach
This problem involves converting a given column number to its corresponding Excel column title. The relationship between numbers and column titles follows a base-26 system similar to alphabets (A-Z).

### Steps
1. Create a mapping for letters A-Z represented as indices 0-25.
2. Use a loop to compute the column title:
    - Subtract 1 from `columnNumber` to make it zero-based.
    - Find the remainder when dividing by 26, which gives the current letter.
    - Append the letter to a `StringBuilder`.
    - Divide the `columnNumber` by 26 to process the next digit.
3. Reverse the `StringBuilder` to get the correct order.
4. Return the result as a string.

### Complexity
- **Time Complexity:** O(log26(n)) where `n` is the input column number. This is because the number is repeatedly divided by 26.
- **Space Complexity:** O(log26(n)) for the string storage.

---

## Code Implementation
```java[]
public class ExcelSheetColumnTitle {
    public static void main(String[] args) {
        int c = 702;
        System.out.println(convertToTitle(c));
    }

    static String convertToTitle(int columnNumber) {
        String[] map = {"A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z"};
        StringBuilder s = new StringBuilder();
        while (columnNumber > 0) {
            columnNumber--;
            int mod = columnNumber % 26;
            s.append(map[mod]);
            columnNumber /= 26;
        }

        return s.reverse().toString();
    }
}
```

---

## Example

### Input
```java[]
int c = 702;
```

### Output
```java[]
ZZ
```

---

## How It Works
1. Input `columnNumber = 702`.
2. Initial `StringBuilder` is empty.
3. Loop through:
    - `702 - 1 = 701`, remainder `701 % 26 = 25` (Z), append Z.
    - Divide `701 / 26 = 26`.
    - `26 - 1 = 25`, remainder `25 % 26 = 25` (Z), append Z.
    - Divide `25 / 26 = 0`, exit loop.
4. Reverse the string to get `"ZZ"`.

---

## Usage
This function can be used in scenarios like converting Excel column numbers to titles programmatically, which is often required in data processing tasks involving spreadsheets.
