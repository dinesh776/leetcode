
# Best Time to Buy and Sell Stock

This repository contains a Java solution to the LeetCode problem [Best Time to Buy and Sell Stock](https://leetcode.com/problems/best-time-to-buy-and-sell-stock/).

## Problem Description

The **Best Time to Buy and Sell Stock** problem requires finding the maximum profit from a series of stock prices, where you are allowed to complete at most one transaction (buy one and sell one share of the stock).

- **Input:** An array of prices where `prices[i]` is the price of a stock on the `i-th` day.
- **Output:** The maximum profit you can achieve. If no profit is possible, return 0.

### Example

**Input:**
```java[]
int[] prices = {7, 1, 5, 3, 6, 4};
```

**Output:**
```java[]
5
```

**Explanation:** Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6 - 1 = 5. Note that the profit cannot be achieved by selling before buying.

## Solution

### Optimal Approach

- **Time Complexity:** O(n)
- **Space Complexity:** O(1)

The algorithm iterates through the array, keeping track of the minimum price encountered so far and calculating the profit for each price.

### Code Example

```java[]
public class BestTimeToBuyAndSellStock {
    public static void main(String[] args) {
        int[] prices = {7,1,5,3,6,4};
        System.out.println(maxProfit(prices));
    }

    static int maxProfit(int[] prices) {
        int min = prices[0], profit = 0;
        for (int i = 1; i < prices.length; i++) {
            int cost = prices[i] - min;
            profit = Math.max(profit, cost);
            min = Math.min(min, prices[i]);
        }
        return profit;
    }
}
```

### Brute Force Approach

- **Time Complexity:** O(n²)
- **Space Complexity:** O(1)

This approach uses nested loops to calculate the profit for every possible pair of days and keeps track of the maximum profit.

```java[]
static int maxProfitBruteForce(int[] prices) {
    int max_profit = 0, n = prices.length;
    for (int i = 0; i < n; i++) {
        for (int j = i + 1; j < n; j++) {
            int profit = prices[j] - prices[i];
            max_profit = Math.max(max_profit, profit);
        }
    }
    return max_profit;
}
```

## How It Works

1. **Optimal Approach:**
    - Track the minimum price encountered so far.
    - For each price, calculate the potential profit and update the maximum profit.

2. **Brute Force Approach:**
    - Compare all pairs of prices to find the maximum profit.

## How to Use

To execute the solution, compile and run the `BestTimeToBuyAndSellStock` class:

```bash[]
javac BestTimeToBuyAndSellStock.java
java BestTimeToBuyAndSellStock
```

## Complexity Analysis

| Approach      | Time Complexity | Space Complexity |
|---------------|-----------------|------------------|
| Optimal       | O(n)            | O(1)             |
| Brute Force   | O(n²)           | O(1)             |
