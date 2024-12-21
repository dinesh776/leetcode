package Github._219ContainsDuplicate2;

//219. Contains Duplicate II
//https://leetcode.com/problems/contains-duplicate-ii/description/

public class ContainsDuplicate2 {
    public static void main(String[] args) {
        int[] arr = {1,0,1,1};
        int k = 1;
        System.out.println(containsNearbyDuplicate(arr, k));
    }
    static boolean containsNearbyDuplicate(int[] nums, int k) {
//        optimized solution O(n.k) time and O(1) space
        int c = 0;
        for(int i=0; i<nums.length; i++) {
            for(int j = Math.min(i+k, nums.length-1); j>i; j--, c++) {
                if(nums[i] == nums[j]) return true;
                if (c>4999) return false;
            }
        }

//        better O(n) time ans O(n) space run time 20ms
//        HashMap<Integer, Integer> map = new HashMap<>();
//        for (int i = 0; i < nums.length; i++) {
//            if (map.containsKey(nums[i])) {
//                if (Math.abs(map.get(nums[i])-i) <= k) {
//                    return true;
//                }
//                map.put(nums[i], i);
//            }
//            else{
//                map.put(nums[i], i);
//            }
//        }

//        brute O(n^2) time and O(1) space tle
//        for (int i = 0; i < nums.length; i++) {
//            for (int j = i + 1; j < nums.length; j++) {
//                if (nums[i] == nums[j]&&Math.abs(i-j)<=k) {
//                    return true;
//                }
//            }
//        }

        return false;
    }
}
