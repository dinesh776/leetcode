package Github._1769MinimumNumberOfOperationsToMoveAllBallsToEachBox;
//1769. Minimum Number of Operations to Move All Balls to Each Box
//https://leetcode.com/problems/minimum-number-of-operations-to-move-all-balls-to-each-box/description/?envType=daily-question&envId=2025-01-06
import java.util.Arrays;

public class MinimumNumberOfOperationsToMoveAllBallsToEachBox {
    public static void main(String[] args) {
        String boxes="001011";
        System.out.println(Arrays.toString(minOperations(boxes)));
    }
    static int[] minOperations(String boxes) {
        int n = boxes.length();
        int[] result = new int[n];

        // Left-to-right pass
        int balls = 0; // Count of balls encountered
        int operations = 0; // Cumulative operations
        for (int i = 0; i < n; i++) {
            result[i] = operations;
            balls += boxes.charAt(i) - '0'; // Add the current box's balls
            operations += balls; // Update operations for the next box
        }
        balls = 0;
        operations = 0;
        for (int i = n - 1; i >= 0; i--) {
            result[i] += operations;
            balls += boxes.charAt(i) - '0'; // Add the current box's balls
            operations += balls; // Update operations for the previous box
        }

        return result;
//        brute force O(n^2) TLE
//        int n=boxes.length(),k=0;
//        int[] ones=new int[n];
//        char[] arr=boxes.toCharArray();
//        for(int i=0;i<n;i++){
//            if(arr[i]=='1'){
//                ones[k++]=i;
//            }
//        }
//        int[] res=new int[n];
//        for(int i=0;i<n;i++){
//            int sum=0;
//            for(int j=0;j<k;j++){
//                sum+=(Math.abs(ones[j]-i));
//            }
//            res[i]=sum;
//        }
//        return res;
    }
}
