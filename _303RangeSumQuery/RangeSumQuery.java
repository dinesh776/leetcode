package Github._303RangeSumQuery;

//303. Range Sum Query - Immutable
//https://leetcode.com/problems/range-sum-query-immutable/description/

import java.util.Arrays;

public class RangeSumQuery {
    public static void main(String[] args) {
        int[] nums={-2, 0, 3, -5, 2, -1};
        int[][] queries={{0,2},{2,5},{0,5}};
        NumArray rangeSumQuery = new NumArray(nums);
        int[] ans=new int[queries.length];
        for(int i=0;i<queries.length;i++){
            ans[i]=rangeSumQuery.sumRange(queries[i][0], queries[i][1]);
        }
        System.out.println(Arrays.toString(ans));
    }
}
