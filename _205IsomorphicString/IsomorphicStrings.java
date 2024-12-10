package Github._205IsomorphicString;

//205. Isomorphic Strings
//https://leetcode.com/problems/isomorphic-strings/description/

public class IsomorphicStrings {
    public static void main(String[] args) {
        String s="foo",t="bar";
        System.out.println(isIsomorphic(s,t));
    }
    static boolean isIsomorphic(String s, String t) {
        if(s.length()!=t.length()){
            return false;
        }
        int[] sChar=new int[256];
        int[] tChar=new int[256];
        for(int i=0;i<s.length();i++){
            if(sChar[s.charAt(i)]!=tChar[t.charAt(i)]){
                return false;
            }
            sChar[s.charAt(i)]=i+1;
            tChar[t.charAt(i)]=i+1;
        }
        return true;
    }
}
