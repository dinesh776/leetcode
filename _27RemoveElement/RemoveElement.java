package Github._27RemoveElement;

//27. Remove Element
//https://leetcode.com/problems/remove-element/description/


import java.util.Arrays;

public class RemoveElement {
    public static void main(String[] args) {
        int[] arr=new int[]{0,1,2,2,3,0,4,2};
        int val=2;
        System.out.println(Arrays.toString(arr));
        System.out.println(removeElement(arr,val));
        System.out.println(Arrays.toString(arr));
    }
    static int removeElement(int[] nums, int val) {
        int r= nums.length-1,i=0,c=0;
        while(i<=r){
            if(nums[i]==val){
                c++;
                if(nums[r]==val){
                    r--;
                }
                else{
                    int temp=nums[i];
                    nums[i]=nums[r];
                    nums[r]= temp;
                    r--;
                }
            }
            else {
                i++;
            }
        }
        return nums.length-c;
    }
}
