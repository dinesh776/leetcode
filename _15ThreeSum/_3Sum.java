package Github._15ThreeSum;

//3 Sum
//https://leetcode.com/problems/3sum/


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _3Sum {
    public static void main(String[] args) {
        int[] nums = {0,0,0};
        System.out.println(threeSum(nums));
    }
    static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> finaList=new ArrayList<>();
        Arrays.sort(nums);
        int n=nums.length;
        for(int i=0;i<n;i++){
            if(i>0 && nums[i]==nums[i-1]){
                continue;
            }
            int j=i+1,k=n-1;
            while(j<k){
                int sum=nums[i]+nums[j]+nums[k];
                if(sum<0){
                    j++;
                }
                else if(sum>0){
                    k--;
                }
                else{
                    List<Integer> list=new ArrayList<>();
                    list.add(nums[i]);
                    list.add(nums[j]);
                    list.add(nums[k]);
                    finaList.add(list);
                    j++;
                    k--;
                    while(j<k&&nums[j]==nums[j-1]){
                        j++;
                    }
                    while(j<k&&nums[k]==nums[k+1]){
                        k--;
                    }
                }
            }
        }

        return finaList;
    }
}
