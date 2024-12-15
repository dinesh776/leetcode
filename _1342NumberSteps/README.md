# Number of Steps to Reduce a Number to Zero

## Problem Description

Given an integer `num`, the task is to return the number of steps to reduce it to zero. In each step, if the number is even, divide it by 2; otherwise, subtract 1 from it.

**Problem Link:** [1342. Number of Steps to Reduce a Number to Zero](https://leetcode.com/problems/number-of-steps-to-reduce-a-number-to-zero/description/)

---

## Approach

### Recursive Approach
This approach uses recursion to count the steps required to reduce the number to zero.

#### Implementation
```java
public class CountSteps {
    public static void main(String[] args) {
        int num = 8;
        System.out.println(numberOfSteps(num));
    }

    static int numberOfSteps(int num) {
        if (num == 0) {
            return 0;
        }
        return 1 + ((num % 2 == 0) ? numberOfSteps(num / 2) : numberOfSteps(num - 1));
    }
}
```

---

## Complexity Analysis

### Time Complexity
- **O(log(n)):** For every even number, the value is halved, and for odd numbers, subtraction occurs, reducing the value significantly. The overall time complexity is logarithmic.

### Space Complexity
- **O(log(n)):** The recursive call stack can go as deep as `log(n)` for the halving operations.

---

## Examples

### Example 1
**Input:**
```
num = 14
```
**Output:**
```
6
```
**Explanation:**
- Step 1: 14 is even; divide by 2 to get 7.
- Step 2: 7 is odd; subtract 1 to get 6.
- Step 3: 6 is even; divide by 2 to get 3.
- Step 4: 3 is odd; subtract 1 to get 2.
- Step 5: 2 is even; divide by 2 to get 1.
- Step 6: 1 is odd; subtract 1 to get 0.

### Example 2
**Input:**
```
num = 8
```
**Output:**
```
4
```
**Explanation:**
- Step 1: 8 is even; divide by 2 to get 4.
- Step 2: 4 is even; divide by 2 to get 2.
- Step 3: 2 is even; divide by 2 to get 1.
- Step 4: 1 is odd; subtract 1 to get 0.

### Example 3
**Input:**
```
num = 123
```
**Output:**
```
12
```

---

## How It Works
1. **Base Case:** If `num` equals 0, return 0.
2. **Recursive Step:**
    - If `num` is even, divide by 2.
    - If `num` is odd, subtract 1.
3. The function recursively adds `1` for every step taken.

---
