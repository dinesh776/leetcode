package Github._151ReverseWordsInAString;

//151. Reverse Words in a String
//https://leetcode.com/problems/reverse-words-in-a-string/description/

public class ReverseWordsInAString {
    public static void main(String[] args) {
        String s="a good   example";
        System.out.println(reverseWords(s));
    }
    static String reverseWords(String s) {
       s= s.trim();
       String[] words = s.split(" ");
       StringBuilder res=new StringBuilder();
       for(int i= words.length-1;i>=0;i--){
           if(!words[i].equals("")){
               words[i]=words[i].trim();
               if(i!=0){
                   res.append(words[i]);
                   res.append(" ");
               }
               else{
                   res.append(words[i]);
               }
           }
       }
       return res.toString();
    }
}
