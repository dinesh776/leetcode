package Github._1482MinimumNumberOfDaysToMakeMBouquets;

//1482. Minimum Number of Days to Make m Bouquets
//https://leetcode.com/problems/minimum-number-of-days-to-make-m-bouquets/description/


public class MinimumNumberOfDaysToMakeMBouquets {
    public static void main(String[] args) {
        int[] arr={7,7,7,7,12,7,7};
        int m=2,k=3;
        System.out.println(minDays(arr,m,k));
    }
    static int minDays(int[] bloomDay, int m, int k) {
        int n=bloomDay.length;
        if(n<m*k){
            return -1;
        }
        int[] temp=findMinMax(bloomDay,n);
        int start=temp[0],end=temp[1],ans=-1;
        while(start<=end){
            int mid=(start+end)/2;
            int no_of_flowers=flowersBloom(bloomDay,n,mid,k);
            if(no_of_flowers>=m){
                ans=mid;
                end=mid-1;
            }
            else {
                start=mid+1;
            }
        }
    return ans;
    }
    static int flowersBloom(int[] bloomDay, int n,int mid,int k) {
        int Adjacent_flowers=0,ct=0;
        for(int i=0;i<n;i++){
            if(bloomDay[i]<=mid){
                ct++;
            }
            else{
                Adjacent_flowers=Adjacent_flowers+(ct/k);
                ct=0;
            }
        }
        return Adjacent_flowers+(ct/k);
    }

    static int[] findMinMax(int[] arr,int n){
        int min=arr[0],max=arr[0];
        for(int i=1;i<n;i++){
            min=Math.min(min,arr[i]);
            max=Math.max(max,arr[i]);
        }
        return new int[]{min,max};
    }
}
