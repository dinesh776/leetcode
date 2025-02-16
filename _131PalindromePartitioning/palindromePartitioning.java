package Github._131PalindromePartitioning;
//131. Palindrome Partitioning
//https://leetcode.com/problems/palindrome-partitioning/description/
import java.util.ArrayList;
import java.util.List;

public class palindromePartitioning {
    public static void main(String[] args) {
        String s="aab";
        System.out.println(partition(s));
    }
    public static List<List<String>> partition(String s) {
        List<List<String>> res=new ArrayList<>();
        helper(s,0,new ArrayList<>(),res);
        return res;
    }
    public static void helper(String s,int index,ArrayList<String> path,List<List<String>> res){
        if(index==s.length()){
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i=index;i<s.length();i++){
            if(isPalindrome(s,index,i)){
                path.add(s.substring(index,i+1));
                helper(s,i+1,path,res);
                path.removeLast();
            }
        }
    }

    public static boolean isPalindrome(String s,int start,int end){
        while(start<=end){
            if(s.charAt(start++)!=s.charAt(end--)){
                return false;
            }
        }
        return true;
    }
}
