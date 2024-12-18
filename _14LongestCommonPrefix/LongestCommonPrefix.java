package Github._14LongestCommonPrefix;

//14. Longest Common Prefix
//https://leetcode.com/problems/longest-common-prefix/description/

public class LongestCommonPrefix {
    public static void main(String[] args) {
        String[] s={"cir","car"};
        System.out.println(longestCommonPrefix(s));
    }
    static String longestCommonPrefix(String[] strs) {
        String ans="";
        int len=strs.length;
        for(int i=0;i<strs[0].length();i++){
            int ct=0;
            for(int j=1;j<len;j++){
                if(i<strs[j].length()&&strs[j].charAt(i)==strs[0].charAt(i)){
                    ct++;
                }
                else{
                    break;
                }
            }
            if(ct==len-1){
                ans+=strs[0].charAt(i);
            }else{
                break;
            }
        }
        return ans;
    }
}
