package Github._2220MinimumBitFlipsToConvertNumber;
//2220. Minimum Bit Flips to Convert Number
//https://leetcode.com/problems/minimum-bit-flips-to-convert-number/description/
public class Flip {
    public static void main(String[] args) {
        int s=10,g=7;
        System.out.println(minBitFlips(s,g));
    }
    public static int minBitFlips(int start, int goal) {

        int xor = start ^ goal;

        return Integer.bitCount(xor);
    }
}
