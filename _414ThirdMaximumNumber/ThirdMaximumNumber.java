package Github._414ThirdMaximumNumber;
//Third Maximum Number
//https://leetcode.com/problems/third-maximum-number/description/
import java.util.Arrays;

public class ThirdMaximumNumber {
    public static void main(String[] args) {
        int[] num={1,1,2};
        System.out.println(thirdMax(num));
    }
    static int thirdMax(int[] nums) {
        Arrays.sort(nums);
        int n=nums.length;
        if(n<3){
            return nums[n-1];
        }
        int i=n-2,max=nums[n-1],c=1;
        while(i>=0){
            if(c==3){
                break;
            }
            while(i>=0&&nums[i]==max){
                i--;
            }
            if(i>=0){
                max=nums[i];
                c++;
            }
            i--;
        }
       return (c==3)?max:nums[n-1];
    }
}
