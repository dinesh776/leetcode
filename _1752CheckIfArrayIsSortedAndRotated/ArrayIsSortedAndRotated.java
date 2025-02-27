package Github._1752CheckIfArrayIsSortedAndRotated;
//1752. Check if Array Is Sorted and Rotated
//https://leetcode.com/problems/check-if-array-is-sorted-and-rotated/description/
public class ArrayIsSortedAndRotated {
    public static void main(String[] args) {
        int[] nums={1,2,3};
        System.out.println(check(nums));
    }
    public static boolean check(int[] nums) {
        int x=-1,n=nums.length;
       for(int i=1;i<n;i++){
           if(nums[i]<nums[i-1]){
               x=i;
               break;
           }
       }
        if(x==-1){
            return true;
        }
        int[] b=new int[n];
        for(int i=0;i<n;i++){
            b[i]=nums[(i+x)%n];
        }
        for(int i=1;i<n;i++){
            if(b[i]<b[i-1]){
                return false;
            }
        }
        return true;
    }
}
