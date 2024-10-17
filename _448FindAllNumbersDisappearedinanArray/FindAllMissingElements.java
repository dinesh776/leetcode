package Github._448FindAllNumbersDisappearedinanArray;

//https://leetcode.com/problems/find-all-numbers-disappeared-in-an-array/
//448. Find All Numbers Disappeared in an Array
import java.util.*;

class FindAllMissingElements {

    public static void main(String[] args) {
        int[] nums = {4,3,2,7,8,2,3,1};
        System.out.println(findDisappearedNumbers(nums));
    }

    static List<Integer> findDisappearedNumbers(int[] nums) {
        cycle_sort(nums);
        List<Integer> list=new ArrayList<Integer>();
        for(int i=0;i<nums.length;i++){
            if(nums[i]!=(i+1)){
                list.add(i+1);
            }
        }
        return list;
    }
    
    static void cycle_sort(int[] nums){
        int i=0;
        while(i<nums.length){
            int correctIndex=nums[i]-1;
            if(nums[i]!=nums[correctIndex]){
                swap(nums,i,correctIndex);
            }else{
                i++;
            }
        }
    }

    static void swap(int[] nums,int first,int second){
        int temp=nums[first];
        nums[first]=nums[second];
        nums[second]=temp;
    }
}