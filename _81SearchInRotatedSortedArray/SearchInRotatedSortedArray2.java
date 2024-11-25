package Github._81SearchInRotatedSortedArray;

//81. Search in Rotated Sorted Array 2
//https://leetcode.com/problems/search-in-rotated-sorted-array-ii/description/

public class SearchInRotatedSortedArray2 {
    public static void main(String[] args) {
        int[] nums={2,5,6,0,0,1,2};
        int target=0;
        System.out.println(search(nums,target));
    }
    static boolean search(int[] nums, int target) {
        int start=0,end=nums.length-1;
        while(start<=end){
            int mid=start+(end-start)/2;
            if(nums[mid]==target){
                return true;
            }
            else if(nums[start]==nums[mid]&&nums[mid]==nums[end]){
                start=start+1;
                end=end-1;
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
        return false;
    }
}
