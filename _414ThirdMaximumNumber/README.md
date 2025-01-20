# Third Maximum Number

### Problem Description
This program solves the problem [Third Maximum Number](https://leetcode.com/problems/third-maximum-number/description/). Given an integer array `nums`, the task is to return the **third distinct maximum number** in the array. If the third maximum does not exist, the function should return the maximum number.

---

### Code Implementation
```java[]
import java.util.Arrays;

public class ThirdMaximumNumber {
    public static void main(String[] args) {
        int[] num = {1, 1, 2};
        System.out.println(thirdMax(num));
    }

    static int thirdMax(int[] nums) {
        Arrays.sort(nums); // Sort the array
        int n = nums.length;

        if (n < 3) {
            return nums[n - 1]; // If fewer than 3 elements, return the maximum
        }

        int i = n - 2; // Start checking from the second largest
        int max = nums[n - 1]; // Store the maximum value
        int c = 1; // Count distinct maximums

        while (i >= 0) {
            if (c == 3) {
                break; // Stop when the third distinct maximum is found
            }

            // Skip duplicates
            while (i >= 0 && nums[i] == max) {
                i--;
            }

            // Update max and count if a new maximum is found
            if (i >= 0) {
                max = nums[i];
                c++;
            }
            i--;
        }

        // Return the third maximum if it exists, otherwise the maximum
        return (c == 3) ? max : nums[n - 1];
    }
}
```

---

### Example Input and Output
#### Input
```java[]
int[] num = {1, 1, 2};
```
#### Output
```java[]
2
```

---

### How It Works
1. **Sorting the Array**: The array is sorted in ascending order to facilitate finding distinct maximums.
2. **Edge Case for Small Arrays**: If the array has fewer than three elements, the maximum number is returned immediately.
3. **Iterative Process**:
    - Traverse the array from the second-largest element to ensure distinct values.
    - Skip duplicate values by comparing the current number with the previous maximum.
    - Update the distinct maximum count `c` and current maximum.
4. **Return Result**:
    - If the count of distinct maximums (`c`) reaches 3, the third maximum is returned.
    - Otherwise, the largest maximum number is returned.

---

### Complexity Analysis
- **Time Complexity**:
    - Sorting the array: \(O(n \log n)\)
    - Iterating through the array: \(O(n)\)
    - Overall: \(O(n \log n)\)

- **Space Complexity**: \(O(1)\) (in-place operations without using additional data structures).

---

