# Combination Sum

## Problem Description
The **Combination Sum** problem requires us to find all unique combinations in a given array of integers where the numbers sum up to a target value. Each number in the array may be used an unlimited number of times.

**LeetCode Link:** [Combination Sum](https://leetcode.com/problems/combination-sum/description/)

## Example
### Input:
```java[]
int[] candidates = {2, 3, 6, 7};
int target = 7;
```
### Output:
```
[[2, 2, 3], [7]]
```
### Explanation:
- The number `2` can be used multiple times to form `[2,2,3]` which sums to 7.
- The number `7` itself forms another valid combination `[7]`.

## Solution Approach
This problem is solved using **Backtracking**. The approach involves:
1. Recursively exploring all possible combinations.
2. Keeping track of the current index to avoid duplicate computations.
3. Using a list to store the current combination and modifying it dynamically.

## Code Implementation
```java[]
import java.util.ArrayList;
import java.util.List;

public class CombinationSum {
    public static void main(String[] args) {
        int[] c = {2, 3, 6, 7};
        int target = 7;
        System.out.println(combinationSum(c, target));
    }

    private static void findCombinations(int ind, int[] arr, int target, List<List<Integer>> ans, List<Integer> ds) {
        if (ind == arr.length) {
            if (target == 0) {
                ans.add(new ArrayList<>(ds));
            }
            return;
        }
        if (target == 0) {
            ans.add(new ArrayList<>(ds));
            return;
        }
        if (arr[ind] <= target) {
            ds.add(arr[ind]);
            findCombinations(ind, arr, target - arr[ind], ans, ds);
            ds.remove(ds.size() - 1);
        }
        findCombinations(ind + 1, arr, target, ans, ds);
    }

    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        findCombinations(0, candidates, target, ans, new ArrayList<>());
        return ans;
    }
}
```

## How It Works
1. The function `findCombinations()` is a recursive function that explores all possible combinations.
2. If the `target` becomes `0`, the current combination is added to the list of results.
3. The function tries to pick the current element as many times as possible before moving to the next element.
4. It backtracks by removing the last element added when exploring a different path.

## Complexity Analysis
- **Time Complexity:** `O(2^t * k)` where `t` is the target value and `k` is the average length of a combination.
- **Space Complexity:** `O(k * x)`, where `x` is the number of valid combinations.

## Usage
To use this implementation, call `combinationSum(int[] candidates, int target)`, passing an array of numbers and a target sum.

## Summary
This solution efficiently finds all possible combinations that sum to a given target using backtracking. The recursive approach ensures that all valid combinations are explored without unnecessary computations.

