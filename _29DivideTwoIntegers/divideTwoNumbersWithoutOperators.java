package Github._29DivideTwoIntegers;
//29. Divide Two Integers
//https://leetcode.com/problems/divide-two-integers/description/
public class divideTwoNumbersWithoutOperators {
    public static void main(String[] args) {
        int dividend=10,divisor=3;
        System.out.println(divide(dividend,divisor));
    }
    public static int divide(int dividend, int divisor) {
        // Handle overflow case
        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }

        // Handle division by 1 or -1 as a special case
        if (divisor == 1) return dividend;
        if (divisor == -1) return -dividend;

        // Determine the sign of the result
        boolean sign = (dividend >= 0) == (divisor >= 0);

        // Convert to long to avoid overflow, use abs value carefully
        long n = Math.abs((long) dividend);
        long d = Math.abs((long) divisor);
        int ans = 0;

        // Bit manipulation to speed up division
        while (n >= d) {
            long temp = d, multiple = 1;
            while (n >= (temp << 1)) {
                temp <<= 1;
                multiple <<= 1;
            }
            n -= temp;
            ans += multiple;
        }

        // Apply the sign
        return sign ? ans : -ans;
    }
}
