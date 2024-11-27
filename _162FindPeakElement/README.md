# Find Peak Element

## Problem Description
- **Problem Name:** Find Peak Element
- **Problem Link:** [162. Find Peak Element](https://leetcode.com/problems/find-peak-element/description/)

Given an integer array `nums`, find a peak element, and return its index. A peak element is an element that is strictly greater than its neighbors. If the array contains multiple peaks, return the index to any of the peaks.

You may imagine `nums[-1] = nums[n] = -∞`. The array may contain multiple peaks, in which case you return the index of any one of the peaks.

---

## Example

### Example 1:
```
Input: nums = [1,2,3,1]
Output: 2
Explanation: 3 is a peak element and your function should return the index number 2.
```

### Example 2:
```
Input: nums = [1,2,1,3,5,6,4]
Output: 5
Explanation: Your function can return either index number 1 where the peak element is 2, or index number 5 where the peak element is 6.
```

---

## Solution

### Approach:
1. If the array has only one element, return its index.
2. Check the boundaries:
    - If the first element is greater than the second, it is a peak.
    - If the last element is greater than the second last, it is a peak.
3. Use binary search for the middle portion of the array:
    - Check if the middle element is greater than its neighbors; if so, return it.
    - If the middle element is increasing towards the right, search in the right half.
    - Otherwise, search in the left half.

### Complexity:
- **Time Complexity:** O(log n) due to binary search.
- **Space Complexity:** O(1) as no additional space is used.

---

## Code

```java[]
public class FindPeakElement {
    public static void main(String[] args) {
        int[] nums={1,2,1,3,5,6,4};
        System.out.println(findPeakElement(nums));
    }
    static int findPeakElement(int[] nums) {
        int n=nums.length;
        if(n==1)return 0;
        if(nums[0]>nums[1])return 0;
        if(nums[n-1]>nums[n-2])return n-1;
        int start=1,end=n-2;
        while(start<=end){
            int mid=start+(end-start)/2;
            if(nums[mid]>nums[mid-1]&&nums[mid]>nums[mid+1])return mid;
            else if(nums[mid]>nums[mid-1]){
                start=mid+1;
            }
            else{
                end=mid-1;
            }
        }
        return -1;
    }
}
```

---

## Usage
1. Copy the code into a Java file.
2. Compile and run the program with an array input to find a peak element's index.

---

## How It Works
The binary search divides the problem space into smaller parts, leveraging the property of peaks in the array:
- If an element is larger than its neighbors, it is a peak.
- The algorithm narrows down the search space until it finds a peak.

---

