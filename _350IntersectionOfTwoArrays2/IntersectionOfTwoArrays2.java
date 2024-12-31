package Github._350IntersectionOfTwoArrays2;

//350. Intersection of Two Arrays II
//https://leetcode.com/problems/intersection-of-two-arrays-ii/description/

import java.util.Arrays;

public class IntersectionOfTwoArrays2 {
    public static void main(String[] args) {
        int[] nums={1,2,2,1};
        int[] nums2 = {2,2};
        System.out.println(Arrays.toString(intersect(nums,nums2)));
    }
    static int[] intersect(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int n=nums1.length,m=nums2.length;
        int[] result=new int[n+m];
        int i=0,j=0,k=0;
        while(i<n&&j<m){
            if(nums1[i]==nums2[j]){
                result[k++]=nums1[i];
                i++;
                j++;
            }
            else if(nums1[i]<nums2[j]){
                i++;
            }
            else{
                j++;
            }
        }
        return Arrays.copyOf(result,k);
    }
}
