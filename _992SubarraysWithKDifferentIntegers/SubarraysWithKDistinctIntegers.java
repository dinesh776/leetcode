package Github._992SubarraysWithKDifferentIntegers;

//992. Subarrays with K Different Integers
//https://leetcode.com/problems/subarrays-with-k-different-integers/description/

import java.util.HashMap;

public class SubarraysWithKDistinctIntegers {
    public static void main(String[] args) {
        int[] nums={1,2,1,3,4};
        int k=3;
        System.out.println(subarraysWithKDistinct(nums,k));
    }
    static int subarraysWithKDistinct(int[] nums, int k) {
        return helper(nums,k)-helper(nums,k-1);
    }

    private static int helper(int[] nums,int goal){
        if(goal<0){
            return 0;
        }
        int i=0,j=0;
        int Count=0;
        HashMap<Integer,Integer> map=new HashMap<>();
        while(j<nums.length){
            map.put(nums[j],map.getOrDefault(nums[j],0)+1);
            while(map.size()>goal){
                map.put(nums[i],map.get(nums[i])-1);
                if(map.get(nums[i])==0){
                    map.remove(nums[i]);
                }
                i++;
            }
            Count=Count+(j-i+1);
            j++;
        }
        return Count;
    }
}
