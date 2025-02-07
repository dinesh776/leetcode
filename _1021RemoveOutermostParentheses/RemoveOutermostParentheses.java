package Github._1021RemoveOutermostParentheses;

//1021. Remove Outermost Parentheses
//https://leetcode.com/problems/remove-outermost-parentheses/description/

public class RemoveOutermostParentheses {
    public static void main(String[] args) {
        String s="(()())(())";
        System.out.println(removeOuterParentheses(s));
    }
    static String removeOuterParentheses(String s) {
        int n=s.length(),opens=0,closes=0,start=0;
        StringBuilder sb=new StringBuilder(s);
        if(n==0){
            return s;
        }
        for(int i=0;i<sb.length();i++){
            if(sb.charAt(i)=='('){
                if(opens==0){
                    start=i;
                }
                opens++;
            }
            else{
                closes++;
            }
            if(opens==closes){
                sb.deleteCharAt(i);
                sb.deleteCharAt(start);
                i=i-2;
                opens=0;
                closes=0;
            }
        }
        return sb.toString();
    }
}
