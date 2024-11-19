
# Merge Intervals

This repository contains a solution to the LeetCode problem [Merge Intervals](https://leetcode.com/problems/merge-intervals/description/), implemented in Java.

## Problem Description

The **Merge Intervals** problem requires merging overlapping intervals in a given list of intervals such that no intervals overlap, and the result is sorted by the starting interval.

### Example

**Input:**
```java[]
int[][] intervals = {{1,4},{0,2},{3,5},{7,9}};
```

**Output:**
```java[]
[[0, 5], [7, 9]]
```

**Explanation:**

The intervals `[1,4]` and `[0,2]` overlap and merge into `[0,5]`. The interval `[3,5]` overlaps with `[0,5]` and also merges into `[0,5]`. The interval `[7,9]` has no overlap.

## Solution

This solution uses an **optimal approach** with a time complexity of `O(n log n)` due to sorting and a space complexity of `O(n)` for the output list.

## Code Example

```java[]
import java.util.*;

public class MergeIntervals {
    public static void main(String[] args) {
        int[][] intervals = {{1,4},{0,2},{3,5},{7,9}};
        System.out.println(Arrays.deepToString(merge(intervals)));
    }
    static int[][] merge(int[][] intervals) {
        int m = intervals.length, j = 0;
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(intervals, new Comparator<int[]>() {
            public int compare(int[] a, int[] b) {
                return a[0] - b[0];
            }
        });

        for (int i = 0; i < m; i++) {
            if (list.isEmpty() || intervals[i][0] > list.get(list.size() - 1).get(1)) {
                list.add(Arrays.asList(intervals[i][0], intervals[i][1]));
            } else {
                list.get(list.size() - 1).set(1, Math.max(intervals[i][1], list.get(list.size() - 1).get(1)));
            }
        }
        int n = list.size();
        int[][] res = new int[n][2];
        for (int i = 0; i < n; i++) {
            res[i][0] = list.get(i).get(0);
            res[i][1] = list.get(i).get(1);
        }
        return res;
    }
}
```

## How it Works

1. **Sorting:** The intervals are sorted based on their start times.
2. **Merging Intervals:** Iteratively check and merge overlapping intervals using a list to store the merged intervals.
3. **Result Construction:** The final merged intervals are converted into a 2D array and returned.

## How to Use

To run the solution, compile and execute the `MergeIntervals` class in your Java environment:

```bash[]
javac MergeIntervals.java
java MergeIntervals
```
This will output the merged intervals.

## Complexity Analysis

- **Time Complexity:** `O(n log n)` due to sorting.
- **Space Complexity:** `O(n)` for the output list.
