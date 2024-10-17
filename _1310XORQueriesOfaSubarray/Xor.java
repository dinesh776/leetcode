package Github._1310XORQueriesOfaSubarray;

import java.util.Arrays;

//https://leetcode.com/problems/xor-queries-of-a-subarray/description/
//_1310.XORQueriesOfaSubarray

public class Xor {
    public static void main(String[] args) {
        int[] arr = {16};
        int[][] queries = {{0,0},{0,0},{0,0}};
        System.out.println(Arrays.toString(xorQueries(arr,queries)));
        
    }
    static int[] xorQueries(int[] arr, int[][] queries) {
        int[] res=new int[queries.length];
        for(int i=0;i<queries.length;i++){
            int xor=0;
            for(int j=queries[i][0];j<=queries[i][1];j++){
                xor=xor^arr[j];
            }
            res[i]=xor;
        }
        return res;
    }
}
