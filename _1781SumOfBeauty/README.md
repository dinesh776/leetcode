# Sum of Beauty of All Substrings

This Java program calculates the **sum of beauty** for all substrings of a given string `s`. The beauty of a substring is defined as the difference between the frequency of the most frequent character and the least frequent character in the substring.

## Problem Details

- **LeetCode Problem**: [1781. Sum of Beauty of All Substrings](https://leetcode.com/problems/sum-of-beauty-of-all-substrings/description/)

## Code

```java[]
public class Beauty {
    public static void main(String[] args) {
        String s = "aabcbaa";
        System.out.println(beautySum(s));
    }

    static int beautySum(String s) {
        int sum = 0;
        for (int i = 0; i < s.length(); i++) {
            int[] charCount = new int[26];
            for (int j = i; j < s.length(); j++) {
                int index = s.charAt(j) - 'a';
                charCount[index]++;
                int[] temp = findMaxMin(charCount);
                sum = sum + (temp[0] - temp[1]);
            }
        }
        return sum;
    }

    static int[] findMaxMin(int[] arr) {
        int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
        for (int i = 0; i < arr.length; i++) {
            max = Math.max(max, arr[i]);
            if (arr[i] < min && arr[i] > 0) {
                min = arr[i];
            }
        }
        return new int[]{max, min};
    }
}
```

## Explanation

### **Algorithm**
1. Iterate through all possible substrings of the string `s` using two nested loops.
2. For each substring:
    - Count the frequency of each character using an array of size 26 (one for each lowercase English letter).
    - Calculate the maximum and minimum frequencies of characters in the substring using the `findMaxMin` helper function.
    - Compute the beauty of the substring as the difference between the maximum and minimum frequencies and add it to the total sum.

3. Return the total sum.

### **Helper Function**
- `findMaxMin`: Finds the maximum and minimum frequencies in the given frequency array. Ensures the minimum frequency is greater than zero to exclude unused characters.

### **Example**
#### Input
```java[]
String s = "aabcbaa";
```
#### Output
```java[]
17
```
#### Explanation
The total beauty sum is calculated as follows:
- Substrings and their beauties:
    - "a": Beauty = 0
    - "aa": Beauty = 0
    - "aab": Beauty = 1
    - ...
    - "aabcbaa": Beauty = 4

Summing these beauties gives the result: 17.

## Complexity Analysis

- **Time Complexity**: \(O(n^2 \times 26) \approx O(n^2)\), where \(n\) is the length of the string.
- **Space Complexity**: \(O(26) \approx O(1)\) for the character frequency array.

## How It Works

1. **Input Handling**: The program accepts a single string `s`.
2. **Frequency Calculation**: A character frequency array is updated for each substring.
3. **Beauty Calculation**: Differences between the max and min frequencies are summed.

## Usage
1. Modify the `main` method to test with different strings.
2. Compile and run the program to view results.

### Example Run
```bash[]
javac Beauty.java
java Beauty
17
```
