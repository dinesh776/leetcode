package Github._33SearchInRotatedSortedArray;

//33. Search in Rotated Sorted Array 1
//https://leetcode.com/problems/search-in-rotated-sorted-array/description/

public class SearchInRotatedSortedArray1 {
    public static void main(String[] args) {
        int[] nums={5,1,3};
        int target=5;
        System.out.println(search(nums,target));
    }
    static int search(int[] nums, int target) {
        int start=0,end=nums.length-1;
        while(start<=end){
            int mid=start+(end-start)/2;
            if(nums[mid]==target){
                return mid;
            }
            else if(nums[start]<=nums[mid]){
                if(target>=nums[start]&&target<=nums[mid]){
                    end=mid-1;
                }
                else{
                    start=mid+1;
                }
            }
            else{
                if(target>=nums[mid]&&target<=nums[end]){
                    start=mid+1;
                }
                else{
                    end=mid-1;
                }
            }
        }
        return -1;
    }
}
