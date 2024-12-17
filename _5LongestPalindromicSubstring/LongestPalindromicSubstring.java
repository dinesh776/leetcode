package Github._5LongestPalindromicSubstring;

//5. Longest Palindromic Substring
//https://leetcode.com/problems/longest-palindromic-substring/description/

public class LongestPalindromicSubstring {
    public static void main(String[] args) {
        System.out.println(longestPalindrome("babad"));
    }
    public static String longestPalindrome(String s) {
        if (s == null || s.length() < 1) return "";

        int start = 0, end = 0;

        for (int i = 0; i < s.length(); i++) {
            // Expand for odd-length palindrome
            int len1 = expandAroundCenter(s, i, i);
            // Expand for even-length palindrome
            int len2 = expandAroundCenter(s, i, i + 1);

            // Get the maximum length
            int len = Math.max(len1, len2);

            // Update start and end indices if a longer palindrome is found
            if (len > end - start) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }

        return s.substring(start, end + 1);
    }

    // Expand around the given center and return the length of the palindrome
    private static int expandAroundCenter(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        return right - left - 1; // Length of the palindrome
    }
}
