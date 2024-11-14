package Github._229MajorityElement2;

//229. Majority Element II
//https://leetcode.com/problems/majority-element-ii/description/


import java.util.ArrayList;
import java.util.List;

public class MajorityElement2 {
    public static void main(String[] args) {
        int[] nums={1,1,1,3,3,2,2,2};
        System.out.println(majorityElement(nums));
    }
    static List<Integer> majorityElement(int[] nums) {
//        optimised solution with boyer's moore algorithm
        int ct1=0,ct2=0,el1=0,el2=-1,n= nums.length;
        List<Integer> list=new ArrayList<>();
        for(int i=0;i<n;i=i+1){
            if(ct1==0&&nums[i]!=el2){
                ct1=1;
                el1=nums[i];
            }
            else if(ct2==0&&nums[i]!=el1){
                ct2=1;
                el2=nums[i];
            }
            else if(el1==nums[i]){
                ct1=ct1+1;
            }
            else if(el2==nums[i]){
                ct2=ct2+1;
            }
            else{
                ct1=ct1-1;
                ct2=ct2-1;
            }
        }
        int c1=0,c2=0,k=n/3;
        for(int i=0;i< n;i=i+1){
            if(nums[i]==el1){
                c1=c1+1;
            }
            else if(nums[i]==el2){
                c2=c2+1;
            }
        }
        if(c1>(k))
            list.add(el1);
        if(c2>k)
            list.add(el2);
        return list;


//        better solution with time O(n) and space O(n)
//        List<Integer> list=new ArrayList<>();
//        HashMap<Integer,Integer> map=new HashMap<>();
//        int n=nums.length,k=n/3+1;
//        for(int i=0;i<n;i++){
//            if(map.containsKey(nums[i])){
//                map.put(nums[i],map.get(nums[i])+1);
//            }else{
//                map.put(nums[i],1);
//            }
//            if(map.get(nums[i])==k){
//                list.add(nums[i]);
//            }
//        }
//        return list;
    }

}
