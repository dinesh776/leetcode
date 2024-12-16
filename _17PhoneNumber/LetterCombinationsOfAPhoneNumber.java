package Github._17PhoneNumber;

//17. Letter Combinations of a Phone Number
//https://leetcode.com/problems/letter-combinations-of-a-phone-number/description/

import java.util.ArrayList;
import java.util.List;

public class LetterCombinationsOfAPhoneNumber {
    public static void main(String[] args) {
        System.out.println(letterCombinations("23"));
    }
//    run time 5ms
    static List<String> letterCombinations(String digits) {
        if(digits.isEmpty()){
            return new ArrayList<>();
        }
        String[] mappings = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        ArrayList<String> list = new ArrayList<>();
        Permutations(list,"",digits,0,mappings);
        return list;
    }

    static void Permutations(ArrayList<String> list,String p, String up, int index, String[] mappings) {
        if(index == up.length()){
            list.add(p);
            return;
        }
        int digit=up.charAt(index)-'0';
        String letters=mappings[digit];
        for(char ch:letters.toCharArray()){
            Permutations(list,p+ch,up,index+1,mappings);
        }
    }
}
