package Github._58.LengthofLastWord;

//https://leetcode.com/problems/length-of-last-word/description/
//_58.LengthofLastWord

public class LengthOfLastWord {
    public static void main(String[] args) {
        String s="luffy is still joyboy";
        System.out.println(lengthOfLastWord(s));
    }
    static int lengthOfLastWord(String s) {
        String[] arr=s.split(" ");
        return arr[arr.length-1].length();
    }
}
