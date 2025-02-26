# Next Greater Element II

## Problem Statement
**LeetCode 503:** [Next Greater Element II](https://leetcode.com/problems/next-greater-element-ii/description/)

Given a circular array `nums`, return the *next greater number* for every element in the array. The next greater number for an element `x` is the first greater number in the traversal order. If it doesn't exist, return `-1` for this element.

## Example

**Input:** `nums = [1, 2, 1]`  
**Output:** `[2, -1, 2]`

**Explanation:** The next greater elements for each index are:
- `1 → 2`
- `2 → -1` (no greater element)
- `1 → 2`

## Solution
The solution uses a **monotonic stack** to efficiently find the next greater element. Since the array is circular, we simulate this by iterating through the array twice (`2 * n`).

## Code Implementation

```java[]
package Practice;

import java.util.Arrays;
import java.util.Stack;

public class nextGreaterelement2 {
    public static void main(String[] args) {
        int[] nums = {1, 2, 1};
        System.out.println(Arrays.toString(nextGreaterElements(nums)));
    }

    public static int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        Stack<Integer> st = new Stack<>();
        
        for (int i = 2 * n - 1; i >= 0; i--) {
            while (!st.isEmpty() && st.peek() <= nums[i % n]) {
                st.pop();
            }
            
            if (i < n) {
                res[i] = st.isEmpty() ? -1 : st.peek();
            }
            
            st.push(nums[i % n]);
        }
        return res;
    }
}
```

## How It Works
1. **Stack Usage:** The stack stores elements in a decreasing order.
2. **Circular Array:** Using `i % n` lets us wrap around the array.
3. **Double Loop:** Iterating twice ensures all elements find their next greater element.

## Complexity Analysis
- **Time Complexity:** `O(n)` — Each element is pushed and popped at most once.
- **Space Complexity:** `O(n)` — For the result array and stack.

## Usage
Compile and run the program:

```bash[]
javac nextGreaterelement2.java
java nextGreaterelement2
```

Expected output:

```[]
[2, -1, 2]
```

## Conclusion
This solution efficiently solves the **Next Greater Element II** problem using a stack. It handles circular arrays by simulating two passes over the array, ensuring optimal performance.

---
