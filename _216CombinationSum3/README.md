# Combination Sum III

## Problem Description
The problem **[216. Combination Sum III](https://leetcode.com/problems/combination-sum-iii/description/)** requires finding all valid combinations of `k` distinct numbers (from 1 to 9) that sum up to `n`. Each number can be used only once.

## Example
```java[]
Input: k = 3, n = 7
Output: [[1,2,4]]

Input: k = 3, n = 9
Output: [[1,2,6], [1,3,5], [2,3,4]]
```

## Solution
We use **backtracking** to generate all possible combinations of numbers from 1 to 9, ensuring:
- The combination has exactly `k` numbers.
- The sum of the combination equals `n`.
- Each number is used only once.

## Code
```java[]
import java.util.ArrayList;
import java.util.List;

public class CombinationSum3 {
    public static void main(String[] args) {
        int k = 4, n = 1;
        System.out.println(combinationSum3(k, n));
    }

    public static List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> list = new ArrayList<>();
        helper(list, 1, n, new ArrayList<>(), k);
        return list;
    }

    public static void helper(List<List<Integer>> list, int ind, int target,
                              ArrayList<Integer> ds, int k) {
        if (target < 0 || ds.size() > k) {
            return;
        }
        if (ds.size() == k && target == 0) {
            list.add(new ArrayList<>(ds));
            return;
        }
        for (int i = ind; i <= 9; i++) {
            ds.add(i);
            helper(list, i + 1, target - i, ds, k);
            ds.removeLast();
        }
    }
}
```

## How It Works
1. Start from `1` and explore all numbers up to `9`.
2. Use backtracking to build combinations.
3. Stop when:
    - The combination size exceeds `k`.
    - The sum exceeds `n`.
    - The combination size is `k` and sum equals `n`.
4. Store valid combinations in the result list.

## Complexity Analysis
- **Time Complexity**: `O(2^9)` (since each number can be included or excluded in recursion)
- **Space Complexity**: `O(k)`, as we use extra space for recursion stack and storing results.

## Usage
To test the program, run the `main` method. Modify `k` and `n` values to check different cases.
