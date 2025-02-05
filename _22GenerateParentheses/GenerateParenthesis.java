package Github._22GenerateParentheses;
//22. Generate Parentheses
//https://leetcode.com/problems/generate-parentheses/description/
import java.util.ArrayList;
import java.util.List;

public class GenerateParenthesis {
    public static void main(String[] args) {
        int n=3;
        System.out.println(generateParenthesis(n));
    }
    public static List<String> generateParenthesis(int n) {
        ArrayList<String> list=new ArrayList<>();
        helper(n,n,list,new StringBuilder());
        return list;
    }
    public static void helper(int l,int r,List<String> list,StringBuilder s){
        if(l==0&&r==0){
            list.add(s.toString());
            return;
        }
        if(l>0){
            helper(l-1,r,list,new StringBuilder(s).append("("));
        }
        if(r>l){
            helper(l,r-1,list,new StringBuilder(s).append(")"));
        }
    }
}
