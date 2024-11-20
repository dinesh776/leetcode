package Github._88MergeSortedArray;

//88. Merge Sorted Array
//https://leetcode.com/problems/merge-sorted-array/description/


import java.util.Arrays;

public class MergeSortedArrays {
    public static void main(String[] args) {
        int[] nums1 = {0},nums2 = {1};
        int  m = 0, n = 1;
        merge(nums1,m,nums2,n);
        System.out.println(Arrays.toString(nums1));
    }
    static void merge(int[] nums1, int m, int[] nums2, int n){
//        optimal solution with time O(m+n) time and space is O(1)
        int i=m-1,j=n-1,k=m+n-1;
        while(i>=0&&j>=0){
            if(nums1[i]>nums2[j]){
                nums1[k]=nums1[i];
                k=k-1;
                i=i-1;
            }
            else{
                nums1[k]=nums2[j];
                k=k-1;
                j=j-1;
            }
        }
        while(j>=0){
            nums1[k]=nums2[j];
            k=k-1;
            j=j-1;
        }


// better with time O(m+n) and space O(m+n)
//        int[] res=new int[m+n];
//        int i=0,j=0,ind=0;
//        while(i<m&&j<n){
//            if(nums1[i]<=nums2[j]){
//                res[ind]=nums1[i];
//                ind++;
//                i++;
//            }
//            else{
//                res[ind]=nums2[j];
//                ind++;
//                j++;
//            }
//        }
//        while(i<m){
//            res[ind++]=nums1[i++];
//        }
//        while(j<n){
//            res[ind++]=nums2[j++];
//        }
//        for(i=0;i<(m+n);i++){
//            nums1[i]=res[i];
//        }


//        bruteforce O((m+n)log(m+n)) time && O(1) space
//        for(int i=0;i<n;i++){
//            nums1[m+i]=nums2[i];
//        }
//        Arrays.sort(nums1);
    }
}
