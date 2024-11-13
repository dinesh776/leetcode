package Github._560SubarraySumEqualsK;

//560. Subarray Sum Equals K
//https://leetcode.com/problems/subarray-sum-equals-k/description/?source=submission-ac


import java.util.HashMap;

public class SubarraySumEqualsK {
    public static void main(String[] args) {
        int[] nums={0,0,0,0,0,0,0,0,0,0};
        int k=0;
        System.out.println(subarraySum(nums,k));
    }
    static int subarraySum(int[] nums, int k) {
       HashMap<Integer,Integer> map=new HashMap<>();
       map.put(0,1);
       int ct=0,preSum=0;
        for(int i=0;i<nums.length;i++){
            preSum=preSum+nums[i];
            int remove=preSum-k;
            ct=ct+map.getOrDefault(remove,0);
            if(map.containsKey(preSum)){
                map.put(preSum,map.get(preSum)+1);
            }
            else{
                map.put(preSum,1);
            }

        }
        return ct;



//        brute force time=O(n^2) ,space = O(1)
//        int ct=0;
//        for(int i=0;i<nums.length;i++){
//            int sum=0;
//            for(int j=i;j< nums.length;j++){
//                sum+=nums[j];
//                if(sum>k){
//                    break;
//                }
//                if(sum==k){
//                    ct++;
//                }
//            }
//        }
//        return ct;
    }
}
