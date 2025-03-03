# Count Primes

## Problem Description

**LeetCode Problem 204: Count Primes**

[Link to the problem](https://leetcode.com/problems/count-primes/description/)

Given an integer `n`, return *the number of prime numbers less than* `n`.

## Example

**Input:** `n = 10`

**Output:** `4`

**Explanation:** The prime numbers less than 10 are `2, 3, 5, 7`.

## Solution

We use the **Sieve of Eratosthenes** algorithm to efficiently count prime numbers.

### Code Example

```java[]
package Practice;

import java.util.Arrays;

public class CountPrimes {

    public static void main(String[] args) {
        int n = 10;
        System.out.println(countPrimes(n));
    }

    public static int countPrimes(int n) {
        if (n <= 2) {
            return 0;
        }

        boolean[] isPrime = new boolean[n];
        Arrays.fill(isPrime, true);
        isPrime[0] = false;
        isPrime[1] = false;

        for (int i = 2; i * i < n; i++) {
            if (isPrime[i]) {
                for (int j = i * i; j < n; j += i) {
                    isPrime[j] = false;
                }
            }
        }

        int count = 0;
        for (boolean prime : isPrime) {
            if (prime) {
                count++;
            }
        }

        return count;
    }
}
```

## How It Works

1. **Initialization:** Create a boolean array `isPrime` of size `n` and initialize all elements to `true`. Set `isPrime[0]` and `isPrime[1]` to `false` since `0` and `1` are not primes.
2. **Mark Non-Primes:** For each prime number `i`, mark all its multiples as `false`, starting from `i * i`.
3. **Count Primes:** After marking, count all `true` values in the array, which represent prime numbers.

## Usage

Run the program with the following command:

```bash[]
javac CountPrimes.java
java CountPrimes
```

## Complexity Analysis

- **Time Complexity:** `O(n log log n)` — efficient for counting primes.
- **Space Complexity:** `O(n)` — to store the boolean array.

---

