
# Find a Peak Element II

## Problem Description
**Leetcode Problem**: [1901. Find a Peak Element II](https://leetcode.com/problems/find-a-peak-element-ii/description/)

A peak element in a 2D grid is defined as an element that is strictly greater than its neighboring elements. The neighbors of an element are the elements directly above, below, left, and right of it. Find the coordinates of any peak element.

## Example
```java[]
import java.util.Arrays;

public class FindAPeakElement2 {
    public static void main(String[] args) {
        int[][] matrix = {{25,37,23,37,19},{45,19,2,43,26},{18,1,37,44,50}};
        System.out.println(Arrays.toString(findPeakGrid(matrix)));
    }
    static int[] findPeakGrid(int[][] mat) {
        int n=mat.length,start=0,m=mat[0].length,end=m-1;
        while(start<=end){
            int mid=(start+end)/2;
            int row=findMax(mat,mid,n);
            int left=(mid-1>=0)?(mat[row][mid-1]):-1;
            int right=(mid+1)<m?(mat[row][mid+1]):-1;
            if(mat[row][mid]>left&&mat[row][mid]>right){
                return new int[]{row,mid};
            }
            else if(mat[row][mid]<left){
                end=mid-1;
            }
            else{
                start=mid+1;
            }
        }
        return new int[]{-1,-1};
    }
    static int findMax(int[][] mat,int mid,int n) {
        int max=Integer.MIN_VALUE,row=-1;
        for(int i=0;i<n;i++){
            if(max<mat[i][mid]){
                max=mat[i][mid];
                row=i;
            }
        }
        return row;
    }
}
```

## How It Works
1. **Binary Search on Columns**:
    - Perform a binary search on the middle column.
    - Identify the row index of the maximum element in the current column.

2. **Check Peak Conditions**:
    - Compare the maximum element in the current column with its left and right neighbors.
    - If it's greater than its neighbors, it is a peak.

3. **Adjust Search**:
    - If the left neighbor is greater, move to the left half.
    - If the right neighbor is greater, move to the right half.

4. **Return Peak Coordinates**:
    - Once a peak is identified, return its coordinates.

## Usage
To use the code:
1. Compile the file: `javac FindAPeakElement2.java`
2. Run the program: `java FindAPeakElement2`

## Complexity Analysis
- **Time Complexity**: (O(nlog(m)), where `m` is the number of columns and `n` is the number of rows.
    - The binary search reduces the search space by half at each step for the columns (log m).
    - For each column, finding the maximum takes \(O(n)\).
- **Space Complexity**: \(O(1)\), as no extra space is used apart from a few variables.

