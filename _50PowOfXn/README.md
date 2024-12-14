# Pow(x, n)

## Problem Description

Implement the `Pow(x, n)` function that calculates \(x^n\). The function must handle both positive and negative powers, as well as zero. The implementation should be efficient to handle very large values of \(n\).

**Problem Link:** [50. Pow(x, n)](https://leetcode.com/problems/powx-n/description/)

---

## Approaches

### Approach 1: Recursive Method
This approach uses recursion to calculate \(x^n\). If \(n\) is negative, we invert the result. By handling even and odd powers separately, the approach minimizes redundant computations.

```java
// Recursive approach
static double myPow(double x, int n) {
    long nn = n;
    nn = (nn < 0) ? -nn : nn;
    double res = helper(x, nn, 1.0);
    if (n < 0) {
        res = 1 / res;
    }
    return res;
}

static double helper(double x, long n, double ans) {
    if (n <= 0) {
        return ans;
    }
    if (n % 2 == 1) {
        ans = ans * x;
        return helper(x, n - 1, ans);
    } else {
        x = x * x;
        return helper(x, n / 2, ans);
    }
}
```

### Approach 2: Iterative Method
This approach iteratively calculates \(x^n\) using a loop. It handles even and odd powers and reduces \(n\) in each iteration, making it efficient.

```java
// Iterative approach
static double myPow1(double x, int n) {
    double ans = 1.0;
    long nn = n;
    nn = (nn < 0) ? -nn : nn;
    while (nn > 0) {
        if (nn % 2 == 1) {
            ans = ans * x;
            nn = nn - 1;
        } else {
            x = x * x;
            nn = nn / 2;
        }
    }
    if (n < 0) {
        ans = 1.0 / ans;
    }
    return ans;
}
```

---

## Time and Space Complexity

### Recursive Approach
- **Time Complexity:** \(O(\log n)\) - The recursion reduces \(n\) by half in each step.
- **Space Complexity:** \(O(\log n)\) - Recursive call stack.

### Iterative Approach
- **Time Complexity:** \(O(\log n)\) - The loop iterates \(\log n\) times.
- **Space Complexity:** \(O(1)\) - No additional space used.

---

## Examples

### Example 1
**Input:**
```
x = 2.00000, n = 10
```
**Output:**
```
1024.00000
```

### Example 2
**Input:**
```
x = 2.10000, n = 3
```
**Output:**
```
9.26100
```

### Example 3
**Input:**
```
x = 2.00000, n = -2
```
**Output:**
```
0.25000
```

---

## How It Works
1. **Recursive Approach:**
    - Break the problem into smaller subproblems.
    - Multiply the result if \(n\) is odd.
    - Square the base and halve \(n\) if \(n\) is even.

2. **Iterative Approach:**
    - Use a loop to perform repeated squaring and multiplication.
    - Keep track of the result and reduce \(n\) accordingly.

---
