package Github._3LongestSubstringWithNoRepeatingCharacter;

//3. Longest Substring Without Repeating Characters
//https://leetcode.com/problems/longest-substring-without-repeating-characters/submissions/1433162504/

import java.util.Arrays;

public class LongestSubstringWithNoRepeatingCharacter {
    public static void main(String[] args) {
    String s = "pwwkew";
    System.out.println(maxLen(s));
    }
    static int maxLen(String s){
        int[] hash=new int[256];
        Arrays.fill(hash,-1);
        int l=0,r=0,max_length=0,n=s.length();
        while(r<n){
            if(hash[s.charAt(r)]!=-1){
                if(hash[s.charAt(r)]>=l){
                    l=hash[s.charAt(r)]+1;
                }
            }
            max_length=Math.max(max_length,(r-l+1));
            hash[s.charAt(r)]=r;
            r++;
        }
        return max_length;
    }

}
