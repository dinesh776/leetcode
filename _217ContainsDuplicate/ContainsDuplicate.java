package Github._217ContainsDuplicate;

//217. Contains Duplicate
//https://leetcode.com/problems/contains-duplicate/description/

public class ContainsDuplicate {
    public static void main(String[] args) {
        int[] nums={1,1,1,3,3,4,3,2,4,2};
        System.out.println(containsDuplicate(nums));
    }
    static boolean containsDuplicate(int[] nums) {
        for(int i = 1; i < nums.length; i++){
            if(nums[i - 1] == nums[i])
                return true;
            else if (nums[i] < nums[i - 1]){
                int temp = nums[i - 1];
                for(int j = i - 2; j >= 0; j--){
                    if(nums[i] == nums[j])
                        return true;
                }
                nums[i - 1] = nums[i];
                nums[i] = temp;
            }
        }
        return false;


//        using Hashing
//        Hashtable<Integer, Integer> hashtable = new Hashtable<>();
//        for(int x:nums) {
//            hashtable.put(x, hashtable.containsKey(x) ? (hashtable.get(x) + 1) : 1);
//        }
////            if(hashtable.isEmpty()){
////                hashtable.put(x,1);
////            }
////            else{
////                if(!hashtable.containsKey(x)){
////                    hashtable.put(x,1);
////                }
////                else{
////                    int c=hashtable.get(x);
////                    hashtable.put(x,++c);
////                }
////            }
//            for(int x:nums){
//                if(hashtable.get(x)>1){
//                    return true;
//                }
//            }

//        return false;
    }
}
