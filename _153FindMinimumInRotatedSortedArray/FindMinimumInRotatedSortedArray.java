package Github._153FindMinimumInRotatedSortedArray;

//153. Find Minimum in Rotated Sorted Array
//https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/description/


public class FindMinimumInRotatedSortedArray {
    public static void main(String[] args) {
        int[] nums={5,1,2,3,4};
        System.out.println(findMin(nums));
    }
    static int findMin(int[] nums) {
        int min=Integer.MAX_VALUE;
        int start=0,end=nums.length-1;
        while(start<=end){
            int mid=start+(end-start)/2;
            //we can further optimise this if we find that both left and right is sorted then ans is arr[start]
            if(nums[start]<=nums[end]){
                min=Math.min(min,nums[start]);
                break;
            }
//          //without above condition also it runs fine
            if(nums[start]<=nums[mid]){
                min=Math.min(min,nums[start]);
                start=mid+1;
            }
            else{
                min=Math.min(min,nums[mid]);
                end=mid-1;
            }
        }
        return min;
    }
}
