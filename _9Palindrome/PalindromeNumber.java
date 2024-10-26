package Github._9Palindrome;

//9. Palindrome Number
//https://leetcode.com/problems/palindrome-number/description/


public class PalindromeNumber {
    public static void main(String[] args) {
        int x=121;
        System.out.println(isPalindrome(x));
    }
    static boolean isPalindrome(int x) {
        int t=x,rev=0;
        if(x<0){
            return false;
        }
        if(x==0)
            return true;
        while(x>0){
            rev=(rev*10)+(x%10);
            x/=10;
        }
        if(rev==t)
            return true;

        return false;
    }
}
