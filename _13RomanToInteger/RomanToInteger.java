package Github._13RomanToInteger;

//13. Roman to Integer
//https://leetcode.com/problems/roman-to-integer/description/

public class RomanToInteger {
    public static void main(String[] args) {
        String s="MCMXCIV";
        System.out.println(romanToInt(s));
    }
    static int romanToInt(String s) {
        int sum=0;
        for(int i=s.length()-1;i>=0;i--){
            char second=s.charAt(i);
            char first=(i>0)?s.charAt(i-1):second;
            int sVal=roman(second);
            int fVal=roman(first);
            int temp;
            if(sVal>fVal){
                temp=sVal-fVal;
                if(i>0){
                    i--;
                }
            }
            else{
                temp=sVal;
            }
            sum+=temp;
        }
        return sum;
    }
    static int roman(char c){
        return switch (c) {
            case 'I' -> 1;
            case 'V' -> 5;
            case 'X' -> 10;
            case 'L' -> 50;
            case 'C' -> 100;
            case 'D' -> 500;
            case 'M' -> 1000;
            default -> 0;
        };
    }
}
