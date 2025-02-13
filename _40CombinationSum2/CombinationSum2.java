package Github._40CombinationSum2;
//40. Combination Sum II
//https://leetcode.com/problems/combination-sum-ii/description/
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum2 {
    public static void main(String[] args) {
        int[] c={10,1,2,7,6,1,5};
        int target=8;
        System.out.println(combinationSum2(c,target));
    }
    public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(candidates);
        findCombinations(0, candidates, target, ans, new ArrayList<>());
        return ans;
    }
    private static void findCombinations(int ind, int[] arr, int target, List<List<Integer>> ans, List<Integer> ds) {

        if(target== 0) {
            ans.add(new ArrayList<>(ds));
            return;
        }
       for (int i=ind;i< arr.length;i++){
           if(i>ind&&arr[i]==arr[i-1])continue;
           if (arr[i]>target)break;

           ds.add(arr[i]);
           findCombinations(i+1,arr,target-arr[i],ans,ds);
           ds.removeLast();
       }

    }

}
