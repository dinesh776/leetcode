# Summary Ranges

## Problem Description

[228. Summary Ranges](https://leetcode.com/problems/summary-ranges/submissions/1491445826/)

Given a sorted integer array `nums`, return the smallest sorted list of ranges that cover all the numbers in the array exactly. That is, each element of `nums` is covered by exactly one of the ranges, and there is no integer `x` such that `x` is in one of the ranges but not in `nums`.

Each range `[a,b]` in the list should be output as:
- `"a->b"` if `a != b`
- `"a"` if `a == b`

## Example

### Input
```java[]
int[] nums = {0, 1, 2, 4, 5, 7};
```

### Output
```
["0->2", "4->5", "7"]
```

### Explanation
The ranges are as follows:
- Numbers 0, 1, 2 form the range "0->2".
- Numbers 4, 5 form the range "4->5".
- Number 7 forms the range "7".

## Code Example

```java[]
import java.util.ArrayList;
import java.util.List;

public class SummaryRanges {
    public static void main(String[] args) {
        int[] nums = {0, 1, 2, 4, 5, 7};
        System.out.println(summaryRanges(nums));
    }

    static List<String> summaryRanges(int[] nums) {
        if (nums.length == 0) {
            return List.of();
        }
        List<String> result = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            StringBuilder sb = new StringBuilder();
            int start = nums[i];
            while (i + 1 < nums.length && nums[i + 1] - nums[i] == 1) {
                i++;
            }
            if (start != nums[i]) {
                sb.append(start).append("->").append(nums[i]);
                result.add(sb.toString());
            } else {
                sb.append(start);
                result.add(sb.toString());
            }
        }
        return result;
    }
}
```

## How It Works

1. **Initialization:**
    - Start iterating through the `nums` array.
    - Use a `StringBuilder` to construct range strings dynamically.

2. **Finding Ranges:**
    - For each number, check if it is part of a continuous range by comparing it to the next number.
    - If it is part of a range, increment the index.

3. **Adding Ranges to Result:**
    - If the start of the range differs from the end, append both values in the format `"start->end"`.
    - If not, append the single value.

4. **Return the Result:**
    - After iterating through the array, return the list of ranges.

## Usage
To run this code, compile and execute it in a Java environment. Pass a sorted array of integers to the `summaryRanges` method to get the list of ranges.

## Complexity Analysis

- **Time Complexity:**
    - O(n), where `n` is the length of the `nums` array. Each element is visited once.

- **Space Complexity:**
    - O(1) for extra space, excluding the space used for the result list.
