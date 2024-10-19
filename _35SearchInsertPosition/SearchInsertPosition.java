package Github._35SearchInsertPosition;

//35. Search Insert Position
//https://leetcode.com/problems/search-insert-position/description/



public class SearchInsertPosition {
    public static void main(String[] args) {
        int[] nums = {1,3,5,6};
        int target = 0;
        System.out.println(searchInsert(nums,target));
    }
    static int searchInsert(int[] nums, int target) {
        int start=0,end=nums.length-1,mid=start+(end-start)/2;
        while(start<=end){
            mid=start+(end-start)/2;
            if(nums[mid]==target){
                return mid;
            }
            if(target>nums[mid]){
                start=mid+1;
            }
            if(target<nums[mid]){
                end=mid-1;
            }
        }
        if(target<nums[mid]){
            return mid;
        }
        return mid+1;
    }
}
