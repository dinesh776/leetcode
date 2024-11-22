package Github._152MaximumProductSubarray;

//152. Maximum Product Subarray
//https://leetcode.com/problems/maximum-product-subarray/description/

public class MaximumProductSubarray {
    public static void main(String[] args) {
        int[] nums={-2,0,-1};
        System.out.println(maxProduct(nums));
    }
    static int maxProduct(int[] nums) {
        int max_prod=Integer.MIN_VALUE,pref=1,suff=1,n=nums.length;
        for(int i=0;i<n;i++){
            if(pref==0)pref=1;
            if(suff==0)suff=1;
            pref=pref*nums[i];
            suff=suff*nums[n-i-1];
            max_prod=Math.max(max_prod,Math.max(pref,suff));
        }
        return max_prod;
    }
}
