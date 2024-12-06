package Github._1283FindTheSmallestDivisorGivenAThreshold;

//1283. Find the Smallest Divisor Given a Threshold
//https://leetcode.com/problems/find-the-smallest-divisor-given-a-threshold/description/


public class _1283 {
    public static void main(String[] args) {
        int[] nums={44,22,33,11,1};
        int threshold=5;
        System.out.println(smallestDivisor(nums,threshold));
    }
    static int smallestDivisor(int[] nums, int threshold) {
        int ans=0,n=nums.length;
        int start=1,end=findMax(nums,n);
        while(start<=end){
            int mid=start+(end-start)/2;
            long div_sum=findDivSum(nums,mid,n);
            if(div_sum<=threshold){
                ans=mid;
                end=mid-1;
            }
            else{
                start=mid+1;
            }
        }
        return ans;
    }
    static long findDivSum(int[] arr,int mid,int n){
        long sum=0;
        for(int i=0;i<n;i++){
            sum = sum + (long)Math.ceil((double) arr[i]/(double) mid);
        }
        return sum;
    }
    static int findMax(int[] arr,int n){
        int max=arr[0];
        for(int i=1;i<n;i++){
            max=Math.max(arr[i],max);
        }
        return max;
    }
}
