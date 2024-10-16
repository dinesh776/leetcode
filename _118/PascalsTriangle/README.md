# LeetCode Problem 118: Pascal's Triangle

## Problem Statement
This is a solution to LeetCode's **[Pascal's Triangle](https://leetcode.com/problems/pascals-triangle/)** problem. The task is to generate the first `numRows` of Pascal's Triangle.

### Problem Example:
Given `n = 5`, the output will be:

## Approach

Pascal’s Triangle is constructed such that:
- The number at the top of the triangle (at row 0) is 1.
- Each subsequent row begins and ends with 1.
- Each interior number is the sum of the two numbers directly above it from the previous row.

### Algorithm Steps:
1. Initialize a list of lists (`s`) to store the triangle.
2. Loop through each row from `0` to `numRows - 1`.
3. For each row, generate the values by adding 1 at the start and end, and the sum of two values from the previous row for other positions.
4. Return the final list representing Pascal's Triangle.

### Time Complexity:
- **Time Complexity**: O(n²) because each row has `n` elements and requires computing the sum of elements from the previous row.
- **Space Complexity**: O(n²) due to storing `n` rows, with each row containing at most `n` elements.

## Code

```java
package Github._118.PascalsTriangle;

import java.util.ArrayList;
import java.util.List;

public class Pascals_Triangle {
    public static void main(String[] args) {
        int n = 5;
        System.out.println(generate(n));
    }

    static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> s = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            ArrayList<Integer> temp = new ArrayList<>();
            for (int j = 0; j <= i; j++) {
                if (j == 0 || i == j) {
                    temp.add(1);
                } else {
                    int first = s.get(i - 1).get(j);
                    int second = s.get(i - 1).get(j - 1);
                    temp.add(first + second);
                }
            }
            s.add(temp);
        }
        return s;
    }
}
