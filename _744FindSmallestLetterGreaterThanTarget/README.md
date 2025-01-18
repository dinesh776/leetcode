# Practice Package

This package contains the implementation of the LeetCode problem [744. Find Smallest Letter Greater Than Target](https://leetcode.com/problems/find-smallest-letter-greater-than-target/description/). The problem involves finding the smallest letter in a sorted array of characters that is strictly greater than a given target character.

## Problem Statement
Given a characters array `letters` that is sorted in non-decreasing order and a character `target`, return the smallest character in the array that is larger than `target`.

The letters wrap around. For example, if `target == 'z'` and `letters == ['a', 'b']`, the answer will be `'a'`.

### Example

#### Input:
```java[]
letters = {'c', 'f', 'z'}
target = 'd'
```

#### Output:
```java[]
'f'
```

### Constraints:
- `2 <= letters.length <= 10^4`
- `letters[i]` is a lowercase English letter.
- `letters` is sorted in non-decreasing order.
- `target` is a lowercase English letter.

## Implementation
The implementation uses a binary search approach to efficiently find the result:

### Code:
```java[]
public class FindSmallestLetterGreaterThanTarget {
    public static void main(String[] args) {
        char[] letters = {'c', 'f', 'z'};
        char target = 'd';
        System.out.println(nextGreatestLetter(letters, target));
    }

    static char nextGreatestLetter(char[] letters, char target) {
        int start = 0, end = letters.length;
        char res = letters[0];
        while (start < end) {
            int mid = start + (end - start) / 2;
            if (letters[mid] <= target) {
                start = mid + 1;
            } else {
                res = letters[mid];
                end = mid;
            }
        }
        return res;
    }
}
```

## How It Works
1. **Binary Search Logic**: The algorithm uses a binary search to navigate through the sorted array.
2. **Target Comparison**: If the middle element of the array is less than or equal to the target, the search space is narrowed to the right half. Otherwise, the result is updated to the current middle element, and the search space is narrowed to the left half.
3. **Edge Cases**: If no character is strictly greater than the target, the result wraps around to the first element in the array, as initialized by `res = letters[0]`.

## How to Use
1. Clone or copy the `FindSmallestLetterGreaterThanTarget` class into your Java project.
2. Modify the `letters` array and `target` variable as needed.
3. Run the `main` method to see the output.

## Complexity
- **Time Complexity**: `O(log n)` where `n` is the length of the `letters` array.
- **Space Complexity**: `O(1)` since no additional space is used.

## License
This implementation is provided as-is for educational purposes and can be used freely in your projects.

