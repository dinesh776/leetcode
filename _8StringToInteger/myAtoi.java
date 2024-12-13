package Github._8StringToInteger;

//8. String to Integer (atoi)
//https://leetcode.com/problems/string-to-integer-atoi/description/

public class myAtoi {
    public static void main(String[] args) {
        String s = "-91283472332";
        System.out.println(myAtoi(s));
    }

    static int myAtoi(String s) {
        s = s.trim(); // Remove leading and trailing whitespaces
        if (s.isEmpty()) return 0;

        int i = 0, sign = 1;
        long result = 0;

        // Handle sign
        if (s.charAt(i) == '-' || s.charAt(i) == '+') {
            sign = (s.charAt(i) == '-') ? -1 : 1;
            i++;
        }

        // Convert characters to number until non-numeric character or end of string
        while (i < s.length() && Character.isDigit(s.charAt(i))) {
            result = result * 10 + (s.charAt(i) - '0');

            // Check for overflow
            if (sign * result < Integer.MIN_VALUE) return Integer.MIN_VALUE;
            if (sign * result > Integer.MAX_VALUE) return Integer.MAX_VALUE;

            i++;
        }

        return (int) (sign * result);
    }
}
