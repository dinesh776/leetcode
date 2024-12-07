package Github._1903LargestOddNumberInString;

//1903. Largest Odd Number in String
//https://leetcode.com/problems/largest-odd-number-in-string/description/

public class LargestOddNumberInString {
    public static void main(String[] args) {
        String s="239537672423884969653287101";
        System.out.println(largestOddNumber(s));
    }
    static String largestOddNumber(String num) {
        StringBuilder sb = new StringBuilder(num);
        for(int i=sb.length()-1;i>=0;i--){
            if(Integer.parseInt(String.valueOf(sb.charAt(i)))%2==1){
                return sb.toString();
            }
            else{
                sb.deleteCharAt(i);
            }
        }
        return "";
    }
}
