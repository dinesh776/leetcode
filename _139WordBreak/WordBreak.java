package Github._139WordBreak;
//139. Word Break
//https://leetcode.com/problems/word-break/description/
import java.util.*;

public class WordBreak {
    public static void main(String[] args) {
        List<String> wordDict = List.of("apple", "pen");
        String s = "applepenapple";
        System.out.println(wordBreak(s, wordDict));
    }

    public static boolean wordBreak(String s, List<String> wordDict) {
        // Using memoization to store intermediate results
        return helper(s, 0, wordDict, new HashMap<>());
    }

    private static boolean helper(String s, int start, List<String> wordDict, Map<Integer, Boolean> memo) {
        // Base case: if we reached end of string, we found a valid break
        if (start == s.length()) {
            return true;
        }

        // If we've already computed this state, return memoized result
        if (memo.containsKey(start)) {
            return memo.get(start);
        }

        // Try all possible words from current position
        for (int end = start + 1; end <= s.length(); end++) {
            String current = s.substring(start, end);
            // If current substring is in dictionary and rest of string can be broken
            if (wordDict.contains(current) && helper(s, end, wordDict, memo)) {
                memo.put(start, true);
                return true;
            }
        }

        // If no valid break found
        memo.put(start, false);
        return false;
    }
}