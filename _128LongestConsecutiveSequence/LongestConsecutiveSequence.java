package Github._128LongestConsecutiveSequence;

//128. Longest Consecutive Sequence
//https://leetcode.com/problems/longest-consecutive-sequence/description/



import java.util.HashSet;

public class LongestConsecutiveSequence {
    public static void main(String[] args) {
        int[] nums = {100,4,200,1,3,2};
        System.out.println(longestConsecutive(nums));
    }
    static int longestConsecutive(int[] nums) {
        int n=nums.length,longest=1;
        if(n==0)
            return 0;
        HashSet<Integer> set=new HashSet<>();
        for(int i:nums){
            set.add(i);
        }

        for(int it:set){
            if(!set.contains(it-1)){
                int ct=1;
                int x=it;
                while(set.contains(x+1)){
                    ct=ct+1;
                    x=x+1;
                }
                longest=Math.max(ct,longest);
            }
        }
        return longest;
    }
}
