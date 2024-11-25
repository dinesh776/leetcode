package Github._34FindFirstAndLast;

//34. Find First and Last Position of Element in Sorted Array
//https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/description/


import java.util.Arrays;

public class FirstAndLastPositionElement {
    public static void main(String[] args) {
        int[] nums = {};
        int target=0;
        System.out.println(Arrays.toString(searchRange(nums,target)));
    }
    static int[] searchRange(int[] arr, int k) {
        int n=arr.length;
        int first=first(arr,k,n);
        int last=last(arr,k,n);
        return new int[]{first,last};
    }
    static  int last(int[] arr,int k,int n){
        int last=-1;
        int start=0,end=n-1;
        while(start<=end){
            int mid=start+(end-start)/2;
            if(arr[mid]==k){
                last=mid;
                start=mid+1;
            }
            else if(k<arr[mid]){
                end=mid-1;
            }
            else {
                start=mid+1;
            }
        }
        return last;
    }
    static  int first(int[] arr,int k,int n){
        int first=-1;
        int start=0,end=n-1;
        while(start<=end){
            int mid=start+(end-start)/2;
            if(arr[mid]==k){
                first=mid;
                end=mid-1;
            }
            else if(k<arr[mid]){
                end=mid-1;
            }
            else {
                start=mid+1;
            }
        }
        return first;
    }
}
