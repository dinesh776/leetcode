package Github._875KokoEatingBananas;

//875. Koko Eating Bananas
//https://leetcode.com/problems/koko-eating-bananas/description/

public class kokoEatingBananas {
    public static void main(String[] args) {
        int[] piles={805306368,805306368,805306368};
        int h=1000000000;
        System.out.println(minEatingSpeed1(piles,h));
    }
    static int minEatingSpeed1(int[] piles, int h) {
        int n = piles.length;
        long total = 0;
        for (int p : piles) total += p;

        int left = (int) ((total - 1) / h) + 1;
        int right = (int) ((total - n) / (h - n + 1)) + 1;

        while (left < right) {
            int mid = left + (right - left) / 2;
            int time = 0;
            for (int p : piles) {
                time += (p - 1) / mid + 1;
            }
            if (time > h) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        return left;
    }
    static int minEatingSpeed(int[] piles, int h) {
        int n=piles.length,start=1,end=findMax(piles,n),ans=0;
        while(start<=end){
            int mid=start+(end-start)/2;
            long total_hrs=totalHours(piles,mid,n);
            if(total_hrs<=h){
                ans=mid;
                end=mid-1;
            }
            else{
                start=mid+1;
            }
        }
        return ans;
    }

    static long totalHours(int[] arr,int mid,int n){
        long total_hrs=0;
        for(int i=0;i<n;i++){
            total_hrs = total_hrs + (long)Math.ceil((double)arr[i]/(double)mid);
        }
        return total_hrs;
    }
    static int findMax(int[] arr,int n){
        int max=arr[0];
        for(int i=1;i<n;i++){
            max=Math.max(arr[i],max);
        }
        return max;
    }
}
