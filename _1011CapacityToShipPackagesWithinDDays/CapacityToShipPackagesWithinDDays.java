package Github._1011CapacityToShipPackagesWithinDDays;

//1011. Capacity To Ship Packages Within D Days
//https://leetcode.com/problems/capacity-to-ship-packages-within-d-days/

public class CapacityToShipPackagesWithinDDays {
    public static void main(String[] args) {
        int[] weights={1,2,3,4,5,6,7,8,9,10};
        int days=1;
        System.out.println(shipWithinDays(weights,days));
    }
    static int shipWithinDays(int[] weights, int days) {
        int n=weights.length;
        int[] temp=findMax(weights,n);
        int start=temp[0],end=temp[1],ans=temp[1];
        while(start<=end){
            int mid=(start+end)/2;
            if(checkCapacity(weights,mid,days,n)){
                ans=mid;
                end=mid-1;
            }
            else{
                start=mid+1;
            }
        }
        return ans;
    }
    static boolean checkCapacity(int[] weights,int mid, int days,int n) {
        int max_days=0,sum=0;
        for(int i=0;i<n;i++){
            sum+=weights[i];
            if(sum>mid){
                max_days++;
                sum=weights[i];
            }
        }
        if(sum<=mid) max_days++;
        return max_days<=days;
    }
    static int[] findMax(int[] weights, int n) {
        int max=weights[0],sum=0;
        for(int i=0;i<weights.length;i++){
            max=Math.max(max,weights[i]);
            sum+=weights[i];
        }
        return new int[]{max,sum};
    }
}
