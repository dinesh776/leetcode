# Minimum Bit Flips to Convert Number

## Problem Description

**LeetCode Problem:** [2220. Minimum Bit Flips to Convert Number](https://leetcode.com/problems/minimum-bit-flips-to-convert-number/description/)

Given two integers `start` and `goal`, return the minimum number of bit flips required to convert `start` to `goal`. A bit flip changes a `0` to `1` or vice versa.

---

## Example

```java[]
public class Flip {
    public static void main(String[] args) {
        int s = 10, g = 7;
        System.out.println(minBitFlips(s, g));
    }

    public static int minBitFlips(int start, int goal) {
        int xor = start ^ goal;
        return Integer.bitCount(xor);
    }
}
```

### Input
- `start = 10`
- `goal = 7`

### Output
```
3
```

### Explanation
- `10` in binary: `1010`
- `7` in binary:  `0111`
- Number of bits to flip: `3`

---

## Solution Explanation

The core logic uses the XOR (`^`) operator:
- XOR returns `1` for bits that are different.
- `Integer.bitCount()` counts the number of `1`s in the binary representation of the XOR result.

### Steps:
1. XOR the `start` and `goal` numbers.
2. Count the set bits (`1`s) in the result.
3. Return the count as the minimum bit flips needed.

---

## Complexity Analysis

- **Time Complexity:** `O(1)` — Constant time, as the bit manipulation operations are done in a fixed number of bits.
- **Space Complexity:** `O(1)` — Constant space, since no additional data structures are used.

---

## Usage

1. Copy the code into a Java file (`Flip.java`).
2. Compile and run the program:

```[]
javac Flip.java
java Flip
```

3. View the output — the number of bit flips required.

---

## Conclusion

This solution provides an efficient way to calculate the minimum bit flips required to convert one number into another, leveraging bit manipulation techniques for optimal performance.
