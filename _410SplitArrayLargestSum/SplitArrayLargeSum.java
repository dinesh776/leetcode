package Github._410SplitArrayLargestSum;

//410. Split Array Largest Sum
//https://leetcode.com/problems/split-array-largest-sum/description/

public class SplitArrayLargeSum {
    public static void main(String[] args) {
        int k=2;
        int[] nums={1,2,3,4,5};
        System.out.println(splitArray(nums,k));
    }
    static int splitArray(int[] nums, int k) {
        int[] temp=findMaxSum(nums);
        int start=temp[0],end=temp[1];
        while(start<=end){
            int mid=(start+end)/2;
            int res=no_of_splits(nums,mid);
            if(res>k){
                start=mid+1;
            }
            else{
                end=mid-1;
            }
        }
        return start;
    }
    static int no_of_splits(int[] nums, int mid) {
        int sum=0,ct=0;
        for(int i=0;i<nums.length;i++){
            sum+=nums[i];
            if(sum>mid){
                ct++;
                sum=nums[i];
            }
        }
        if(sum<=mid){
            ct++;
        }
        return ct;
    }
    static int[] findMaxSum(int[] nums) {
        int sum=0,max=Integer.MIN_VALUE;
        for(int i=0;i<nums.length;i++){
            sum+=nums[i];
            max=Math.max(max,nums[i]);
        }
        return new int[]{max,sum};
    }
}
