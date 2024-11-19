package Github._56MergeIntervals;

//56. Merge Intervals
//https://leetcode.com/problems/merge-intervals/description/

import java.util.*;


public class MergeIntervals {
    public static void main(String[] args) {
        int[][] intervals = {{1,4},{0,2},{3,5},{7,9}};
        System.out.println(Arrays.deepToString(merge(intervals)));
    }
    static int[][] merge(int[][] intervals) {
        int m=intervals.length,j=0;
        List<List<Integer>> list=new ArrayList<>();
        Arrays.sort(intervals, new Comparator<int[]>() {
            public int compare(int[] a, int[] b) {
                return a[0] - b[0];
            }
        });

        for(int i=0;i<m;i++){
            if(list.isEmpty()||intervals[i][0]>list.get(list.size()-1).get(1)){
                list.add(Arrays.asList(intervals[i][0],intervals[i][1]));
            }
            else{
                list.get(list.size()-1).set(1,Math.max(intervals[i][1],list.get(list.size()-1).get(1)));
            }
        }
        int n=list.size();
        int[][] res=new int[n][2];
        for(int i=0;i<n;i++){
            res[i][0]=list.get(i).get(0);
            res[i][1]=list.get(i).get(1);
        }
        return res;
    }
}
