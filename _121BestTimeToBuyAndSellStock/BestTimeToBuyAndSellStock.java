package Github._121BestTimeToBuyAndSellStock;

//121. Best Time to Buy and Sell Stock
//https://leetcode.com/problems/best-time-to-buy-and-sell-stock/description/


public class BestTimeToBuyAndSellStock {
    public static void main(String[] args) {
        int[] prices = {7,1,5,3,6,4};
        System.out.println(maxProfit(prices));
    }
    static int maxProfit(int[] prices){
//Optimal Approach with time O(n) & space O(1)
        int min=prices[0],profit=0;
        for(int i=1;i<prices.length;i=i+1){
            int cost=prices[i]-min;
            profit=Math.max(profit,cost);
            min=Math.min(min,prices[i]);
        }
        return profit;

//        bruteforce with time O(n^2) & space O(1)
//        int max_profit=0,n=prices.length;
//        for(int i=0;i<n;i++){
//            for(int j=i+1;j<n;j++){
//                int profit=prices[j]-prices[i];
//                max_profit=Math.max(max_profit,profit);
//            }
//        }
//        return max_profit;
    }
}
