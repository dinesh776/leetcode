# Minimum Index Sum of Two Lists

## Problem Description
You are given two arrays `list1` and `list2` of strings, representing restaurant names. You need to find the restaurant(s) that appear in both arrays with the smallest combined index sum. If there is a tie, return all restaurants with the same minimum index sum in any order.

### Problem Link
[LeetCode - Minimum Index Sum of Two Lists](https://leetcode.com/problems/minimum-index-sum-of-two-lists/description/)

## Approach
This problem is solved using a hashmap to store the indices of the restaurants in `list1`. Then, iterate through `list2` to calculate the index sums for restaurants appearing in both lists. Keep track of the smallest index sum and update the result list accordingly.

### Algorithm
1. Use a hashmap (`indexMap`) to store the restaurant names from `list1` as keys and their indices as values.
2. Iterate through `list2`:
    - Check if the current restaurant exists in `indexMap`.
    - Calculate the index sum (`j + indexMap.get(restaurant)`) for the current restaurant.
    - If the index sum is smaller than the current `minIndexSum`, clear the result list and add this restaurant.
    - If the index sum is equal to `minIndexSum`, add the restaurant to the result list.
3. Return the result list as an array.

## Code
```java[]
import java.util.*;

public class MinimumIndexSumOfTwoLists {
    public static void main(String[] args) {
        String[] list1 = {"happy", "sad", "good"};
        String[] list2 = {"sad", "happy", "good"};
        System.out.println(Arrays.toString(findRestaurant(list1, list2)));
    }

    static String[] findRestaurant(String[] list1, String[] list2) {
        Map<String, Integer> indexMap = new HashMap<>();
        for (int i = 0; i < list1.length; i++) {
            indexMap.put(list1[i], i);
        }

        List<String> result = new ArrayList<>();
        int minIndexSum = Integer.MAX_VALUE;

        for (int j = 0; j < list2.length; j++) {
            String restaurant = list2[j];
            if (indexMap.containsKey(restaurant)) {
                int indexSum = j + indexMap.get(restaurant);

                if (indexSum < minIndexSum) {
                    // Found a smaller index sum, clear and update result
                    result.clear();
                    result.add(restaurant);
                    minIndexSum = indexSum;
                } else if (indexSum == minIndexSum) {
                    // Found another restaurant with the same minimum index sum
                    result.add(restaurant);
                }
            }
        }

        // Convert result list to array
        return result.toArray(new String[0]);
    }
}
```

## Example
### Input
```java[]
list1 = ["happy", "sad", "good"]
list2 = ["sad", "happy", "good"]
```
### Output
```java[]
["sad", "happy"]
```

### Explanation
The common restaurants are:
- "happy" (index sum = 0+1 = 1)
- "sad" (index sum = 1+0 = 1)

Since both have the smallest index sum, they are included in the output.

## Complexity Analysis
- **Time Complexity**: O(n + m), where `n` is the length of `list1` and `m` is the length of `list2`.
    - Building the hashmap takes O(n).
    - Iterating through `list2` and checking the hashmap takes O(m).
- **Space Complexity**: O(n), for the hashmap to store `list1` indices.
