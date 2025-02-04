package Github._1992CountGoodNumbers;
//1922. Count Good Numbers
//https://leetcode.com/problems/count-good-numbers/description/
public class CountGoodNumbers {
    private static final int MOD = 1_000_000_007;

    public int countGoodNumbers(long n) {
        long evenCount = (n + 1) / 2; // Number of even positions
        long oddCount = n / 2;        // Number of odd positions

        long evenProduct = modPow(5, evenCount, MOD); // 5 choices for even positions
        long oddProduct = modPow(4, oddCount, MOD);   // 4 choices for odd positions

        return (int) (evenProduct * oddProduct % MOD);
    }

    private long modPow(long base, long exp, int mod) {
        long result = 1;
        while (exp > 0) {
            if ((exp & 1) == 1) {
                result = result * base % mod;
            }
            base = base * base % mod;
            exp >>= 1;
        }
        return result;
    }
}
