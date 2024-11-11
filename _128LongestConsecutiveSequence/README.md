
# Longest Consecutive Sequence

This repository contains a solution to the LeetCode problem [Longest Consecutive Sequence](https://leetcode.com/problems/longest-consecutive-sequence/), implemented in Java.

## Problem Description

Given an unsorted array of integers `nums`, return the length of the longest consecutive elements sequence. The algorithm should run in O(n) time complexity.

### Example

**Input:**
```java[]
int[] nums = {100, 4, 200, 1, 3, 2};
```

**Output:**
```java[]
4
```

## Explanation

The longest consecutive sequence is `[1, 2, 3, 4]`, which has a length of 4.

## Solution

This solution uses a HashSet to store each element of `nums`, allowing for O(1) average time complexity when checking for existence. By iterating through the set and checking only the start of potential sequences (elements for which `element - 1` does not exist in the set), we can efficiently count the length of each consecutive sequence.

## Code Example

```java[]
import java.util.HashSet;

public class LongestConsecutiveSequence {
    public static void main(String[] args) {
        int[] nums = {100, 4, 200, 1, 3, 2};
        System.out.println(longestConsecutive(nums));
    }

    static int longestConsecutive(int[] nums) {
        int n = nums.length, longest = 1;
        if (n == 0)
            return 0;
        HashSet<Integer> set = new HashSet<>();
        for (int i : nums) {
            set.add(i);
        }

        for (int it : set) {
            if (!set.contains(it - 1)) {
                int ct = 1;
                int x = it;
                while (set.contains(x + 1)) {
                    ct = ct + 1;
                    x = x + 1;
                }
                longest = Math.max(ct, longest);
            }
        }
        return longest;
    }
}
```

## How it Works

1. **Initialization**: We add all elements of `nums` to a HashSet for O(1) access.
2. **Sequence Check**: For each element, if it does not have a predecessor (`element - 1`), it is the start of a sequence. The code then checks the consecutive sequence length starting from this element.
3. **Update Longest**: If the current sequence is longer than previous ones, we update the `longest` variable.

## How to Use

To run this solution, compile and execute the `LongestConsecutiveSequence` class in your Java environment:

```bash[]
javac LongestConsecutiveSequence.java
java LongestConsecutiveSequence
```

## Complexity Analysis

- **Time Complexity**: O(n), where `n` is the number of elements in `nums`, as we only iterate over the elements and sequences once.
- **Space Complexity**: O(n), as we store each element in a HashSet.
