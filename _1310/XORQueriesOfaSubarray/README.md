# LeetCode Problem 1310: XOR Queries of a Subarray

## Problem Statement
This is a solution to LeetCode's **[XOR Queries of a Subarray](https://leetcode.com/problems/xor-queries-of-a-subarray/)** problem. The task is to process several queries on a given array, where each query consists of two indices, and the result of each query is the XOR of the subarray between those two indices (inclusive).

### Problem Example:
Given the array `arr = [16]` and `queries = [[0,0],[0,0],[0,0]]`, the function returns `[16, 16, 16]` because the XOR of the single element `16` is `16` for all the queries.

## Approach

The solution uses a brute-force approach to calculate the XOR for each query:
1. Loop through each query in the `queries` array.
2. For each query, calculate the XOR of the elements between the start and end indices specified by the query.
3. Store the result of each query in a result array.
4. Return the result array once all queries are processed.

### Time Complexity:
- **Time Complexity**: O(m * n), where `m` is the number of queries and `n` is the length of the subarray processed for each query.
- **Space Complexity**: O(m), where `m` is the number of queries (for the result array).

## Code

```java
package Github._1310.XORQueriesOfaSubarray;

import java.util.Arrays;

public class Xor {
    public static void main(String[] args) {
        int[] arr = {16};
        int[][] queries = {{0,0},{0,0},{0,0}};
        System.out.println(Arrays.toString(xorQueries(arr, queries)));
    }

    static int[] xorQueries(int[] arr, int[][] queries) {
        int[] res = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int xor = 0;
            for (int j = queries[i][0]; j <= queries[i][1]; j++) {
                xor = xor ^ arr[j];
            }
            res[i] = xor;
        }
        return res;
    }
}
