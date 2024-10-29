
# Fibonacci Number

This repository contains a solution to the LeetCode problem [Fibonacci Number](https://leetcode.com/problems/fibonacci-number/description/), implemented in Java.

## Problem Description

The Fibonacci sequence is a series of numbers where each number is the sum of the two preceding ones, starting from `0` and `1`. The function `F(n)` returns the `n`th Fibonacci number.

### Example

**Input:**
```java[]
n = 5
```

**Output:**
```java[]
5
```

## Explanation:
The Fibonacci sequence for the first few numbers is `0, 1, 1, 2, 3, 5, ...`. For `n = 5`, the result is `5`.

## Solution

The solution uses Binet's formula to calculate the Fibonacci number efficiently without recursion or iteration. This approach avoids the exponential time complexity of recursive solutions.

## Code Example

```java[]
public class Fibonacci {
    public static void main(String[] args) {
        int n = 5;
        System.out.println(fib(n));
    }

    static int fib(int n) {
        double phi = (1 + Math.sqrt(5)) / 2;
        double sqrt5 = Math.sqrt(5);
        int k = (int) ((Math.pow(phi, n) - Math.pow(1 - phi, n)) / sqrt5);
        return k;
    }
}
```

## How it Works

- **Binet's Formula:** The formula `(φ^n - (1 - φ)^n) / sqrt(5)` calculates the Fibonacci number directly, where `φ` (phi) is the golden ratio `(1 + √5) / 2`.
- **Efficiency:** This approach computes Fibonacci numbers in constant time, making it much faster than recursion for large values of `n`.

## How to Use

To run this solution, compile and execute the `Fibonacci` class in your Java environment:

```bash[]
javac Fibonacci.java
java Fibonacci
```

This will output the Fibonacci number for the specified `n`.

## Complexity Analysis

- **Time Complexity:** O(1), due to direct computation using Binet's formula.
- **Space Complexity:** O(1), as no additional data structures are used.
