# LeetCode Problem 268: Missing Number

## Problem Statement
This is a solution to LeetCode's **[Missing Number](https://leetcode.com/problems/missing-number/)** problem. The task is to find the missing number in an array `nums` containing `n` distinct numbers taken from the range `[0, n]`.

### Problem Example:
Given the array `nums = [2,1,0]`, the function returns `3` because 3 is missing from the range `[0,3]`.

## Approach

The solution uses **Cycle Sort** to place the numbers in their correct indices. After sorting, we iterate through the array to identify the index where the number doesn't match the index, which indicates the missing number. If all numbers match their indices, the missing number is the length of the array (`n`).

### Algorithm Steps:
1. Use **Cycle Sort** to place numbers in their correct indices (i.e., number `n` should be at index `n`).
2. After sorting, iterate through the array to find the index where the number does not match the index.
3. If no mismatches are found, the missing number is `n`.
4. Return the missing number.

### Time Complexity:
- **Time Complexity**: O(n) because each element is moved to its correct position in the array exactly once.
- **Space Complexity**: O(1) as we use constant extra space (excluding the input array).

## Code

```java
package Github._268.MissingNumber;

public class MissingNumber {
    public static void main(String[] args) {
        int[] arr={2,1,0};
        cycle_sort(arr);
        int missing_number= arr.length;
        for(int i=0;i< arr.length;i++){
            if(arr[i]!=i){
                missing_number=i;
            }
        }
        System.out.println(missing_number);
    }

    static void cycle_sort(int[] arr){
        int i=0;
        while(i<arr.length) {
            int correctIndex = arr[i];
            if(arr[i]< arr.length && arr[i] != arr[correctIndex]){
                swap(arr,i,correctIndex);
            }else{
                i++;
            }
        }
    }

    static void swap(int[] arr,int first,int last){
        int temp=arr[first];
        arr[first]=arr[last];
        arr[last]=temp;
    }
}
