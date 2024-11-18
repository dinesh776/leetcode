package Github._18FourSum;

//4 Sum
//https://leetcode.com/problems/4sum/submissions/1456018844/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class _4Sum {
    public static void main(String[] args) {
        int[] nums = {1000000000,1000000000,1000000000,1000000000};
        int target = -294967296;
        System.out.println(fourSum(nums,target));
    }
    static List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> list =new ArrayList<>();
        Arrays.sort(nums);
        int n=nums.length;
        for(int i=0;i<n;i++){
            if(i>0&&nums[i]==nums[i-1]){
                continue;
            }
            for(int j=i+1;j<n;j++){
                if(j!=i+1&&nums[j]==nums[j-1]){
                    continue;
                }
                int l=n-1,k=j+1;
                while(k<l){
                    long sum=(long) nums[i]+nums[j]+nums[k]+nums[l];
                    if(sum==target){
                        List<Integer> temp=new ArrayList<>();
                        temp.add(nums[i]);
                        temp.add(nums[j]);
                        temp.add(nums[k]);
                        temp.add(nums[l]);
                        list.add(temp);
                        k++;
                        l--;
                        while(k<l && nums[k]==nums[k-1]){
                            k++;
                        }
                        while(k<l&& nums[l]==nums[l+1]){
                            l--;
                        }
                    }
                    else if(sum<target){
                        k++;
                    }
                    else{
                        l--;
                    }

            }


            }
        }


        return list;
    }
}
