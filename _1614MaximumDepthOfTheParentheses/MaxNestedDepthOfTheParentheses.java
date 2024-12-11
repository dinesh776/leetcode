package Github._1614MaximumDepthOfTheParentheses;

//1614. Maximum Nesting Depth of the Parentheses
//https://leetcode.com/problems/maximum-nesting-depth-of-the-parentheses/description/

public class MaxNestedDepthOfTheParentheses {
    public static void main(String[] args) {
        String s="()";
        System.out.println(maxDepth(s));
    }
    static int maxDepth(String s) {
        int ct=0,max=0;
        for(int i=0;i<s.length();i++){
            char c=s.charAt(i);
            if(c=='('){
                ct++;
                max=Math.max(max,ct);
            }
            else if(c==')'){
                ct--;
            }
        }
        return max;
    }
}
