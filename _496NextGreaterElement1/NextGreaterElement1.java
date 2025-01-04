package Github._496NextGreaterElement1;
//496. Next Greater Element I
//https://leetcode.com/problems/next-greater-element-i/description/
import java.util.Arrays;
import java.util.HashMap;

public class NextGreaterElement1 {
    public static void main(String[] args) {
        int[] nums1={2,4},nums2={1,2,3,4};
        System.out.println(Arrays.toString(nextGreaterElement(nums1,nums2)));
    }
    static int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int n=nums1.length,m=nums2.length;
        int[] res=new int[n];
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<m;i++){
            map.put(nums2[i],i);
        }
        for(int i=0;i<n;i++){
            int temp=-1;
            int index=map.get(nums1[i])+1;
            while(index<m){
                if(nums2[index]>nums1[i]){
                    temp=nums2[index];
                    break;
                }
                index++;
            }
            res[i]=temp;
        }
        return res;
    }
}
