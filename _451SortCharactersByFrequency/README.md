# Sort Characters By Frequency

## Problem Description
**LeetCode Problem #451:** [Sort Characters By Frequency](https://leetcode.com/problems/sort-characters-by-frequency/description/)

Given a string `s`, sort it in decreasing order based on the frequency of characters.

### Example:
**Input:** `tree`  
**Output:** `eert`  
**Explanation:** 'e' appears twice, so it comes first, followed by 'r' and 't'.

---

## Solution
This implementation sorts characters by frequency using a bucket sort approach.

### Steps:
1. **Count Character Frequencies:** Use a `HashMap` to count occurrences of each character.
2. **Create Buckets:** Use a list array where the index represents frequency, and store characters in the appropriate bucket.
3. **Build Result String:** Iterate through buckets in reverse order to construct the sorted string.

---

## Code Example
```java[]
package U_Github;

import java.util.*;

public class SortCharactersByFrequency {
    public static void main(String[] args) {
        String s = "tree";
        System.out.println(frequencySort(s));
    }

    static String frequencySort(String s) {
        // Step 1: Count the frequency of each character
        Map<Character, Integer> frequencyMap = new HashMap<>();
        for (char c : s.toCharArray()) {
            frequencyMap.put(c, frequencyMap.getOrDefault(c, 0) + 1);
        }

        // Step 2: Create buckets where index represents frequency
        int maxFrequency = Collections.max(frequencyMap.values());
        List<Character>[] buckets = new List[maxFrequency + 1];
        for (int i = 0; i <= maxFrequency; i++) {
            buckets[i] = new ArrayList<>();
        }

        // Fill the buckets
        for (Map.Entry<Character, Integer> entry : frequencyMap.entrySet()) {
            int frequency = entry.getValue();
            char character = entry.getKey();
            buckets[frequency].add(character);
        }

        // Step 3: Build the result string from the buckets
        StringBuilder result = new StringBuilder();
        for (int i = maxFrequency; i > 0; i--) {
            for (char c : buckets[i]) {
                result.append(String.valueOf(c).repeat(i));
            }
        }

        return result.toString();
    }
}
```

---

## How It Works
- `frequencyMap`: Stores character counts.
- `buckets`: Groups characters by frequency.
- `StringBuilder`: Concatenates characters from highest to lowest frequency.

---

## Complexity Analysis
- **Time Complexity:** `O(n)` — Iterating through the string and buckets takes linear time.
- **Space Complexity:** `O(n)` — Extra space for frequency map and buckets.

---

## Usage
Run the program:
```sh[]
javac SortCharactersByFrequency.java
java SortCharactersByFrequency
```

Test with different inputs by modifying the `s` variable.

---


