# String to Integer (atoi)

## Problem Description

This problem involves implementing the `atoi` function, which converts a string to an integer. The function discards leading whitespaces, handles an optional sign (`+` or `-`), and converts subsequent numeric characters into an integer until a non-numeric character is encountered or the end of the string is reached. If the integer exceeds the bounds of a 32-bit signed integer, it should return the appropriate limit.

**Problem Link:** [8. String to Integer (atoi)](https://leetcode.com/problems/string-to-integer-atoi/description/)

---

## Approach

### Implementation

```java
public class myAtoi {
    public static void main(String[] args) {
        String s = "-91283472332";
        System.out.println(myAtoi(s));
    }

    static int myAtoi(String s) {
        s = s.trim(); // Remove leading and trailing whitespaces
        if (s.isEmpty()) return 0;

        int i = 0, sign = 1;
        long result = 0;

        // Handle sign
        if (s.charAt(i) == '-' || s.charAt(i) == '+') {
            sign = (s.charAt(i) == '-') ? -1 : 1;
            i++;
        }

        // Convert characters to number until non-numeric character or end of string
        while (i < s.length() && Character.isDigit(s.charAt(i))) {
            result = result * 10 + (s.charAt(i) - '0');

            // Check for overflow
            if (sign * result < Integer.MIN_VALUE) return Integer.MIN_VALUE;
            if (sign * result > Integer.MAX_VALUE) return Integer.MAX_VALUE;

            i++;
        }

        return (int) (sign * result);
    }
}
```

---

## Time Complexity
- **O(n):** The string is traversed once to parse the numeric characters.

## Space Complexity
- **O(1):** The algorithm uses a constant amount of extra space.

---

## Examples

### Example 1
**Input:**
```
s = "42"
```
**Output:**
```
42
```

### Example 2
**Input:**
```
s = "   -42"
```
**Output:**
```
-42
```

### Example 3
**Input:**
```
s = "4193 with words"
```
**Output:**
```
4193
```

### Example 4
**Input:**
```
s = "words and 987"
```
**Output:**
```
0
```

### Example 5
**Input:**
```
s = "-91283472332"
```
**Output:**
```
-2147483648
```

---

## How It Works
1. **Trimming Whitespaces:** The `trim()` method removes any leading or trailing whitespaces.
2. **Sign Handling:** If the first non-whitespace character is a sign, it sets the sign and increments the index.
3. **Digit Parsing:** Numeric characters are converted to integers and added to the result.
4. **Overflow Handling:** If the result exceeds the 32-bit integer limits, it is capped to `Integer.MIN_VALUE` or `Integer.MAX_VALUE`.
5. **Returning the Result:** The final value is returned as an integer.

---
