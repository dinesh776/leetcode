# Next Greater Element I

## Problem Description
[Next Greater Element I](https://leetcode.com/problems/next-greater-element-i/description/)

The problem requires finding the **next greater element** for each element in an array `nums1` given another array `nums2` where:
- `nums1` is a subset of `nums2`.
- For each element in `nums1`, find the first greater element to its right in `nums2`.
- If no such greater element exists, return `-1` for that element.

## Example
### Input
```java[]
int[] nums1 = {2, 4};
int[] nums2 = {1, 2, 3, 4};
```
### Output
```java[]
[-1, -1]
```

## Solution
The solution involves mapping the indices of `nums2` using a `HashMap` to efficiently determine the position of each element in `nums2`. For each element in `nums1`, the algorithm checks for the next greater element in `nums2` starting from its position.

### Code Example
```java[]
import java.util.Arrays;
import java.util.HashMap;

public class NextGreaterElement1 {
    public static void main(String[] args) {
        int[] nums1 = {2, 4}, nums2 = {1, 2, 3, 4};
        System.out.println(Arrays.toString(nextGreaterElement(nums1, nums2)));
    }

    static int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int n = nums1.length, m = nums2.length;
        int[] res = new int[n];
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < m; i++) {
            map.put(nums2[i], i);
        }
        for (int i = 0; i < n; i++) {
            int temp = -1;
            int index = map.get(nums1[i]) + 1;
            while (index < m) {
                if (nums2[index] > nums1[i]) {
                    temp = nums2[index];
                    break;
                }
                index++;
            }
            res[i] = temp;
        }
        return res;
    }
}
```

## How It Works
1. **Mapping Indices**: Use a `HashMap` to store the indices of elements in `nums2` for quick access.
2. **Finding Next Greater Element**: For each element in `nums1`, locate its position in `nums2` and check subsequent elements until a greater one is found or the end of the array is reached.
3. **Result Array**: Store the next greater element or `-1` if no such element exists.

### Complexity Analysis
- **Time Complexity**:
    - Building the map: `O(m)`
    - Searching for each element in `nums1`: `O(n * m)` in the worst case.
- **Space Complexity**: `O(m)` for the `HashMap`.

## Usage
The function `nextGreaterElement(int[] nums1, int[] nums2)` takes two arrays as input and returns an array of integers representing the next greater elements for the elements in `nums1`.
