# Pascal's Triangle II

### Problem Description
The task is to return the `k`th (0-indexed) row of Pascal's Triangle.

Pascal's Triangle is a triangular array where:
- Each row starts and ends with `1`.
- Each number in between is the sum of the two numbers directly above it.

#### LeetCode Problem
[119. Pascal's Triangle II](https://leetcode.com/problems/pascals-triangle-ii/description/)

---

### Example
**Input:**
```java[]
rowIndex = 3
```

**Output:**
```java[]
[1, 3, 3, 1]
```

---

### Solution Explanation
We use an optimized approach to generate the specific row of Pascal's Triangle without constructing all previous rows. This approach utilizes the formula for binomial coefficients:

\[
C(k, i) = \frac{C(k, i-1) \cdot (k - i + 1)}{i}
\]

#### Steps:
1. Initialize the first element of the row as `1`.
2. Use the binomial coefficient formula to compute the remaining elements iteratively.
3. Return the constructed row.

---

### Code Implementation
```java[]
import java.util.ArrayList;
import java.util.List;

public class Pascals_Triangle2 {
    public static void main(String[] args) {
        int rowIndex = 3;
        System.out.println(getRow(rowIndex));
    }

    static List<Integer> getRow(int rowIndex) {
        // Optimized Approach
        List<Integer> row = new ArrayList<>();

        row.add(1); // First element is always 1

        for (int j = 1; j <= rowIndex; j++) {
            int val = (int) ((long) row.get(j - 1) * (rowIndex - j + 1) / j);
            row.add(val);
        }

        return row;
    }
}
```

---

### How It Works
1. **Initialization**: Start with `row = [1]`.
2. **Iterative Calculation**: For each position in the row (from 1 to `rowIndex`), compute the next value using the formula for binomial coefficients.
3. **Output the Result**: Return the list containing the values for the `k`th row.

---

### Complexity Analysis
- **Time Complexity**: \(O(k)\)
    - We compute each element of the row exactly once.
- **Space Complexity**: \(O(k)\)
    - The list storing the row requires space proportional to the row index.

---

### Usage
This implementation is ideal for generating a specific row of Pascal's Triangle efficiently without computing unnecessary rows. It leverages mathematical insights for optimal performance.
