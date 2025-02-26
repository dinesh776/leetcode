package Github._503NextGreaterElement2;
//503. Next Greater Element II
//https://leetcode.com/problems/next-greater-element-ii/description/
import java.util.Arrays;
import java.util.Stack;

public class nextGreaterelement2 {
    public static void main(String[] args) {
        int[] nums={1,2,1};
        System.out.println(Arrays.toString(nextGreaterElements(nums)));
    }
    public static int[] nextGreaterElements(int[] nums) {
        int n=nums.length;
        int[] res=new int[n];
        Stack<Integer> st=new Stack<>();
        for(int i=2*n-1;i>=0;i--){
            while(!st.isEmpty()&&st.peek()<=nums[i%n]){
                st.pop();
            }
            if(i<n){
                res[i]=st.isEmpty()?-1:st.peek();
            }
            st.push(nums[i%n]);
        }
        return res;
    }
}
