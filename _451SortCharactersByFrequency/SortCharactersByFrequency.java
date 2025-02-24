package Github._451SortCharactersByFrequency;

//451. Sort Characters By Frequency
//https://leetcode.com/problems/sort-characters-by-frequency/description/

import java.util.*;

public class SortCharactersByFrequency {
    public static void main(String[] args) {
        String s="tree";
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
