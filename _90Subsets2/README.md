# Subsets II

## Problem Description
The problem "Subsets II" is a variation of the "Subsets" problem where the input array may contain duplicate numbers. The goal is to generate all possible subsets (the power set) while ensuring that no duplicate subsets appear in the output.

**Problem Link:** [LeetCode - Subsets II](https://leetcode.com/problems/subsets-ii/description/)

## Example
### Input:
```java[]
int[] nums = {1,2,2};
```
### Output:
```
[[], [1], [1, 2], [1, 2, 2], [2], [2, 2]]
```

## Solution
The approach used in this solution involves:
1. **Sorting** the input array to easily handle duplicates.
2. **Backtracking** to generate all subsets.
3. **Skipping duplicate elements** to prevent duplicate subsets in the result.

## Code Implementation
```java[]
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Subsets2 {
    public static void main(String[] args) {
        int[] nums = {1,2,2};
        System.out.println(subsetsWithDup(nums));
    }
    
    public static List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> list = new ArrayList<>();
        helper(nums, 0, new ArrayList<>(), list);
        return list;
    }
    
    private static void helper(int[] nums, int index, ArrayList<Integer> ds, List<List<Integer>> list) {
        list.add(new ArrayList<>(ds));
        for (int i = index; i < nums.length; i++) {
            if (i != index && nums[i] == nums[i - 1]) {
                continue;
            }
            ds.add(nums[i]);
            helper(nums, i + 1, ds, list);
            ds.remove(ds.size() - 1);
        }
    }
}
```

## How It Works
1. The array is first **sorted** to ensure duplicate elements are adjacent.
2. The `helper` function is called recursively to explore all subsets.
3. A **base case** is used to add each subset to the result list.
4. A **condition** `(i != index && nums[i] == nums[i - 1])` is used to skip duplicate elements and avoid duplicate subsets.

## Complexity Analysis
- **Sorting the array** takes **O(n log n)**.
- **Generating all subsets** involves **O(2^n)** recursive calls.
- **Overall Time Complexity:** **O(n log n + 2^n)**.
- **Space Complexity:** **O(2^n)** due to the result storage.

## Usage
Run the Java file and pass an integer array with duplicate elements to generate all unique subsets.

## Notes
- This solution ensures that the subsets are unique by skipping duplicate elements after sorting.
- The approach follows **backtracking** with pruning to optimize performance.

