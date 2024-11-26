package Github._540SingleElementInASortedArray;

//540. Single Element in a Sorted Array
//https://leetcode.com/problems/single-element-in-a-sorted-array/description/


public class SingleElementInASortedArray {
    public static void main(String[] args) {
        int[] num={3,3,7,7,10,11,11};
        System.out.println(singleNonDuplicate(num));
    }
    static int singleNonDuplicate(int[] nums) {
        int n=nums.length;
        if(n==1) return nums[0];
        if(nums[0]!=nums[1])return nums[0];
        if(nums[n-1]!=nums[n-2])return nums[n-1];
        int start=1,end=n-2;
        while(start<=end){
            int mid=start+(end-start)/2;
            if((nums[mid]!=nums[mid-1])&&nums[mid]!=nums[mid+1])return nums[mid];
            else if((mid%2==1&&nums[mid]==nums[mid-1])||(mid%2==0&&nums[mid]==nums[mid+1])){
                start=mid+1;
            }
            else {
                end=mid-1;
            }
        }
        return -1;
    }
}
