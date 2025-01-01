# Island Perimeter

## Problem Description
[Island Perimeter](https://leetcode.com/problems/island-perimeter/description/)

You are given `grid`, a 2D array representing a map where:
- `0` represents water
- `1` represents land

Each cell is square and has a side length of `1`. The grid is rectangular, with its width and height not exceeding `100`. The grid is completely surrounded by water, and there is exactly one island (i.e., one or more connected land cells).

The island does not have "lakes" (water inside that is not connected to the water surrounding the island). Cells are connected horizontally/vertically (not diagonally). Determine the perimeter of the island.

## Example

### Input
```java[]
[[0,1,0,0],
 [1,1,1,0],
 [0,1,0,0],
 [1,1,0,0]]
```

### Output
```java[]
16
```

## Solution
To compute the perimeter of the island:
1. Traverse each cell in the grid.
2. For each land cell (`grid[i][j] == 1`):
    - Start with a base perimeter of 4.
    - Subtract 1 for each neighboring land cell (up, down, left, right).
3. Sum the perimeter contributions of all land cells.

### Code Example
```java[]
public class IslandPerimeter {
    public static void main(String[] args) {
        int[][] grid = {{0,1,0,0},{1,1,1,0},{0,1,0,0},{1,1,0,0}};
        System.out.println(islandPerimeter(grid));
    }

    static int islandPerimeter(int[][] grid) {
        int perimeter = 0;
        int n = grid.length, m = grid[0].length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int p = 4;
                if (grid[i][j] == 1) {
                    if (i > 0 && grid[i - 1][j] == 1) {
                        p -= 1;
                    }
                    if (j > 0 && grid[i][j - 1] == 1) {
                        p -= 1;
                    }
                    if (j < m - 1 && grid[i][j + 1] == 1) {
                        p -= 1;
                    }
                    if (i < n - 1 && grid[i + 1][j] == 1) {
                        p -= 1;
                    }
                    perimeter += p;
                }
            }
        }
        return perimeter;
    }
}
```

## How It Works
- The nested loops traverse every cell in the grid.
- For each cell containing land (`1`), the perimeter starts as `4`.
- The conditions check neighboring cells to the top, left, bottom, and right. For each neighbor that is also land, 1 is subtracted from the perimeter of the current cell.
- The total perimeter is accumulated for all land cells.

### Complexity Analysis
- **Time Complexity**: `O(n * m)`, where `n` is the number of rows and `m` is the number of columns. Each cell is visited once.
- **Space Complexity**: `O(1)`, as no extra space is used apart from a few variables.

## Usage
- The function `islandPerimeter(int[][] grid)` takes a 2D grid as input and returns an integer representing the perimeter of the island.

