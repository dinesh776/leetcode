# Combination Sum II

## Problem Description
Given a collection of candidate numbers (`candidates`) and a target number (`target`), find all unique combinations in `candidates` where the candidate numbers sum to `target`. Each number in `candidates` may only be used once in the combination.

[LeetCode Problem: Combination Sum II](https://leetcode.com/problems/combination-sum-ii/description/)

## Example
### Input:
```java[]
int[] candidates = {10,1,2,7,6,1,5};
int target = 8;
```
### Output:
```java[]
[[1,1,6],[1,2,5],[1,7],[2,6]]
```

## Solution
The approach used here involves:
1. Sorting the input array to handle duplicate values and ensure elements are considered in order.
2. Using a backtracking method to explore all possible combinations.
3. Skipping duplicate elements to avoid redundant combinations.

## Code
```java[]
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum2 {
    public static void main(String[] args) {
        int[] c = {10,1,2,7,6,1,5};
        int target = 8;
        System.out.println(combinationSum2(c, target));
    }
    
    public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(candidates);
        findCombinations(0, candidates, target, ans, new ArrayList<>());
        return ans;
    }
    
    private static void findCombinations(int ind, int[] arr, int target, List<List<Integer>> ans, List<Integer> ds) {
        if (target == 0) {
            ans.add(new ArrayList<>(ds));
            return;
        }
        
        for (int i = ind; i < arr.length; i++) {
            if (i > ind && arr[i] == arr[i - 1]) continue; // Skip duplicates
            if (arr[i] > target) break; // No point in continuing if the number exceeds target
            
            ds.add(arr[i]);
            findCombinations(i + 1, arr, target - arr[i], ans, ds);
            ds.remove(ds.size() - 1);
        }
    }
}
```

## How It Works
1. **Sorting**: The array is sorted to help with duplicate elimination.
2. **Backtracking**:
    - We iterate through the array, selecting each element once.
    - If a duplicate element is encountered (and it's not the first occurrence at the given level), we skip it.
    - If the target is reached, the combination is stored.
    - Backtracking ensures all possibilities are explored while maintaining uniqueness.

## Complexity Analysis
- **Sorting**: `O(N log N)`
- **Backtracking**: `O(2^N)`, where `N` is the number of elements in `candidates`
- **Overall Complexity**: `O(2^N)` (exponential in the worst case scenario)
