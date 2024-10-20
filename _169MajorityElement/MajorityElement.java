package Github._169MajorityElement;

//169. Majority Element
//https://leetcode.com/problems/majority-element/description/


public class MajorityElement {
    public static void main(String[] args) {
        int[] nums = new int[]{1 , 1 , 2 , 2 , 3 , 2};
        System.out.println(majorityElement(nums));
    }
    static int majorityElement(int[] nums) {
        int e=nums[0],c=0;
        for(int i=0;i<nums.length;i++){
            if(c==0){
                e=nums[i];
            }
            if(e==nums[i]){
                c++;
            }
            else{
                c--;
            }
        }
        int k=0;
        for(int i=0;i< nums.length;i++){
            if(nums[i]==e)
                k++;
        }
        if(k>(nums.length/2)){
            return e;
        }
        return -1;
    }
}
