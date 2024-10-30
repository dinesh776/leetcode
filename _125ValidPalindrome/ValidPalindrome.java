package Github._125ValidPalindrome;

//125. Valid Palindrome
//https://leetcode.com/problems/valid-palindrome/description/


public class ValidPalindrome {
    public static void main(String[] args) {
        String s = "0P";
        System.out.println(isPalindrome(s));
    }
    static boolean isPalindrome(String s) {
        s=s.toLowerCase();
        int r=s.length()-1,i=0;
        while(i<=r){
            char s1=s.charAt(i),s2=s.charAt(r);
            if(!(s1>='a'&&s1<='z')&&!(s1>='0'&&s1<='9')){
                i++;
            }
            else if(!(s2>='a'&& s2<='z')&&!(s2>='0'&& s2<='9')){
                r--;
            }
            else {
                if(s1==s2){
                    i++;
                    r--;
                }
                else{
                    return false;
                }
            }
        }
        return true;
    }
}
