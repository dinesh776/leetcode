package Github._349IntersectionOfTwoArrays;
//349. Intersection of Two Arrays
//https://leetcode.com/problems/intersection-of-two-arrays/description/
import java.util.Arrays;

public class IntersectionOfTwoArrays {
    public static void main(String[] args) {
        int[] arr1 = {4,9,5};
        int[] arr2 = {9,4,9,8,4};

        int[] result = intersection(arr1, arr2);
        System.out.println(Arrays.toString(result));
    }
    static int[] intersection(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);

        int i = 0, j = 0, k = 0;
        int[] result = new int[nums1.length];

        while(i < nums1.length && j < nums2.length) {
            if(nums1[i] == nums2[j]) {
                if(k == 0 || result[k-1] != nums1[i]) {
                    result[k++] = nums1[i];
                }
                i++;
                j++;
            } else if(nums1[i] < nums2[j]) {
                i++;
            } else {
                j++;
            }
        }
        return Arrays.copyOf(result, k);
    }
}
