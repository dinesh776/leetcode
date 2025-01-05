package Github._500KeyboardRow;
//500. Keyboard Row
//https://leetcode.com/problems/keyboard-row/description/
import java.util.Arrays;

public class KeyboardRow {
    public static void main(String[] args) {
        String[] words={"asdfghjklASDFGHJKL","qwertyuiopQWERTYUIOP","zxcvbnmZXCVBNM"};
        System.out.println(Arrays.toString(findWords(words)));
    }
    static String[] findWords(String[] words) {
        String[] res=new String[words.length];
        int k=0;
        for(String word:words){
            String temp=word;
            temp=temp.toLowerCase();
            int in=1;
            int firstCharRow=rowCheck(temp.charAt(0));
            for(int i=1;i<word.length();i++){
                int row=rowCheck(temp.charAt(i));
                if(row!=firstCharRow){
                    in=0;
                    break;
                }
            }
            if(in==1){
                res[k++]=word;
            }
        }
        return Arrays.copyOf(res,k);
    }
    static int rowCheck(char c){
        String firstRow="qwertyuiop";
        String secondRow="asdfghjkl";
        String thirdFRow="zxcvbnm";
        if(firstRow.contains(String.valueOf(c))){
            return 1;
        }
        else if(secondRow.contains(String.valueOf(c))){
            return 2;
        }
        else{
            return 3;
        }
    }
}
