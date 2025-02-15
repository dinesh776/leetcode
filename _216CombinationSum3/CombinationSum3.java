package Github._216CombinationSum3;
//216. Combination Sum III
//https://leetcode.com/problems/combination-sum-iii/description/
import java.util.ArrayList;
import java.util.List;

public class CombinationSum3 {
    public static void main(String[] args) {
        int k=4,n=1;
        System.out.println(combinationSum3(k,n));
    }
    public static List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> list=new ArrayList<>();
        helper(list,1,n,new ArrayList<>(),k);
        return list;
    }

    public static void helper(List<List<Integer>> list,int ind,int target,
                              ArrayList<Integer> ds,int k){
        if(target<0||ds.size()>k)
        {
            return;
        }
        if(ds.size()==k&&target==0){
            list.add(new ArrayList<>(ds));
            return;
        }
        for(int i=ind;i<=9;i++){
            ds.add(i);
            helper(list,i+1,target-i,ds,k);
            ds.removeLast();
        }
    }
}
