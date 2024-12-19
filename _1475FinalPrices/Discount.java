package Github._1475FinalPrices;

import java.util.Arrays;

//1475. Final Prices With a Special Discount in a Shop
//https://leetcode.com/problems/final-prices-with-a-special-discount-in-a-shop/description/?envType=daily-question&envId=2024-12-18

public class Discount {
    public static void main(String[] args) {
        int[] arr = {8, 7, 4, 2, 8, 1, 7, 7, 10, 1};
        System.out.println(Arrays.toString(finalPrices(arr)));
    }

    static int[] finalPrices(int[] prices) {
        int n = prices.length;
        int[] finalPrices = new int[n];

        for (int i = 0; i < n; i++) {
            // Initialize the discounted price as the original price
            finalPrices[i] = prices[i];

            // Find the first smaller or equal price
            for (int j = i + 1; j < n; j++) {
                if (prices[j] <= prices[i]) {
                    finalPrices[i] = prices[i] - prices[j];
                    break;
                }
            }
        }
        return finalPrices;
    }
}
