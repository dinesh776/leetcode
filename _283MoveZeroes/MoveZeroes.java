package Github._283MoveZeroes;

//283. Move Zeroes
//https://leetcode.com/problems/move-zeroes/

import java.util.Arrays;

public class MoveZeroes {
    public static void main(String[] args) {
     int[] nums={0,1,0,3,12};
        moveZeroes(nums);
        System.out.println(Arrays.toString(nums));
    }
    static void moveZeroes(int[] nums) {
        int i=0,j=1,n=nums.length;
        while(i<n-1&&j<n){
            if(nums[i]==0){
                if(nums[j]!=0){
                    int temp=nums[j];
                    nums[j]=nums[i];
                    nums[i]=temp;
                    i++;
                    j++;
                }
                else{
                    j++;
                }
            }
            else{
                i++;
                j++;
            }
        }
    }
}
