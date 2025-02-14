package Github._90Subsets2;
//90. Subsets II
//https://leetcode.com/problems/subsets-ii/description/
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Subsets2 {
    public static void main(String[] args) {
        int[] nums={1,2,2};
        System.out.println(subsetsWithDup(nums));
    }
    public static List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> list=new ArrayList<>();
        helper(nums,0,new ArrayList<>(),list);
        return list;
    }
    private static void helper(int[] nums, int index, ArrayList<Integer> ds,List<List<Integer>> list){
        list.add(new ArrayList<>(ds));
        for(int i=index;i<nums.length;i++){
            if(i!=index&&nums[i]==nums[i-1]){
                continue;
            }
            ds.add(nums[i]);
            helper(nums,i+1,ds,list);
            ds.removeLast();
        }
    }
}
