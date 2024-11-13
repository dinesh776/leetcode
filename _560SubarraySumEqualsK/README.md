
# Subarray Sum Equals K

This repository contains a solution to the LeetCode problem [Subarray Sum Equals K](https://leetcode.com/problems/subarray-sum-equals-k/description/?source=submission-ac), implemented in Java.

## Problem Description

Given an integer array `nums` and an integer `k`, return the total number of continuous subarrays whose sum equals to `k`.

### Example

**Input:**
```java[]
nums = [0,0,0,0,0,0,0,0,0,0]
k = 0
```

**Output:**
```java[]
55
```

## Solution

The solution uses a HashMap to store the prefix sum and its frequency. As we iterate through the array, we calculate the current prefix sum and check if there's a previous prefix sum that, when subtracted from the current sum, equals `k`. This approach has a time complexity of O(n) and space complexity of O(n).

### Brute Force Approach

The brute force solution uses two nested loops to check all subarrays. The time complexity is O(n^2) and space complexity is O(1).

```java[]
int ct = 0;
for (int i = 0; i < nums.length; i++) {
    int sum = 0;
    for (int j = i; j < nums.length; j++) {
        sum += nums[j];
        if (sum > k){
            break;
        }
        if (sum == k) {
            ct++;
        }
    }
}
return ct;
```

### Optimized Approach

The optimized approach uses a HashMap to store the prefix sums.

```java[]
import java.util.HashMap;

public class SubarraySumEqualsK {
    public static void main(String[] args) {
        int[] nums = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        int k = 0;
        System.out.println(subarraySum(nums, k));
    }

    static int subarraySum(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        int ct = 0, preSum = 0;
        for (int i = 0; i < nums.length; i++) {
            preSum += nums[i];
            int remove = preSum - k;
            ct += map.getOrDefault(remove, 0);
            map.put(preSum, map.getOrDefault(preSum, 0) + 1);
        }
        return ct;
    }
}
```

## How it Works

- **HashMap to store prefix sums:** We use a HashMap to track the frequency of prefix sums encountered.
- **Iterate through the array:** For each element in the array, update the current prefix sum and check if there's a previous sum that makes the difference equal to `k`.
- **Count subarrays:** If the difference exists in the map, it means there are subarrays that sum to `k`, and we increment the count.

## How to Use

To run the solution, compile and execute the `SubarraySumEqualsK` class in your Java environment:

```bash[]
javac SubarraySumEqualsK.java
java SubarraySumEqualsK
```

This will output the total number of subarrays whose sum equals `k`.

## Complexity Analysis

**Optimised**
- **Time Complexity:** O(n), where n is the length of the array. Each element is processed once.
- **Space Complexity:** O(n), where n is the number of unique prefix sums stored in the HashMap.

**Bruteforce**
- **Time Complexity:** O(n^2), where n is the length of the array, as we check every possible subarray.
- **Space Complexity:** O(1), since no extra space is used except for variables for the counters.