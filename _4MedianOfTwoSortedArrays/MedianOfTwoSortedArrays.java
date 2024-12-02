package Github._4MedianOfTwoSortedArrays;

//4. Median of Two Sorted Arrays
//https://leetcode.com/problems/median-of-two-sorted-arrays/submissions/1468252558/

public class MedianOfTwoSortedArrays {
    public static void main(String[] args) {
        int[] nums1={1,2},nums2={3,4};
        System.out.println(findMedianSortedArrays(nums1, nums2));
    }
    static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n1=nums1.length,n2=nums2.length;
        if(n1>n2){
            return findMedianSortedArrays(nums2,nums1);
        }
        int n=n1+n2;
        int start=0,end=n1;
        int left=(n1+n2+1)/2;
        while(start<=end){
            int mid1=(start+end)/2;
            int mid2=left-mid1;
            int l1=Integer.MIN_VALUE,l2=Integer.MIN_VALUE;
            int r1=Integer.MAX_VALUE,r2=Integer.MAX_VALUE;
            if(mid1<n1){
                r1=nums1[mid1];
            }
            if(mid2<n2){
                r2=nums2[mid2];
            }
            if(mid1-1>=0){
                l1=nums1[mid1-1];
            }
            if(mid2-1>=0){
                l2=nums2[mid2-1];
            }
            if(l1<=r2&&l2<r1){
                if(n%2==1){
                    return Math.max(l1,l2);
                }
                return (double)(Math.max(l1,l2)+Math.min(r1,r2))/2.0;
            }
            else if(l1>r2){
                end=mid1-1;
            }
            else{
                start=mid1+1;
            }
        }
        return 0.0;
    }
}
