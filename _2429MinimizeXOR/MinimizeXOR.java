package Github._2429MinimizeXOR;
//2429. Minimize XOR
//https://leetcode.com/problems/minimize-xor/description/?envType=daily-question&envId=2025-01-15
public class MinimizeXOR {
    public static void main(String[] args) {
        int num1=3,num2=5;
        System.out.println(minimizeXor(num1,num2));
    }
    static int minimizeXor(int num1, int num2) {
        int num2Ones = Integer.bitCount(num2); // Count the number of 1s in num2
        int result = 0;

        // Step 1: Use the 1s from num1 (highest bits first)
        for (int i = 31; i >= 0 && num2Ones > 0; i--) {
            if ((num1 & (1 << i)) != 0) {
                result |= (1 << i); // Set this bit in the result
                num2Ones--;        // Decrease the count of 1s to place
            }
        }

        // Step 2: If num2Ones are left, fill the lowest available bits
        for (int i = 0; i < 32 && num2Ones > 0; i++) {
            if ((result & (1 << i)) == 0) {
                result |= (1 << i); // Set this bit in the result
                num2Ones--;        // Decrease the count of 1s to place
            }
        }

        return result;
    }
}
