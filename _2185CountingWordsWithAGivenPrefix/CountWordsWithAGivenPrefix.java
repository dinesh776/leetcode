package Github._2185CountingWordsWithAGivenPrefix;

//2185. Counting Words With a Given Prefix
//https://leetcode.com/problems/counting-words-with-a-given-prefix/description/?envType=daily-question&envId=2025-01-09

public class CountWordsWithAGivenPrefix {
    public static void main(String[] args) {
        String pref="at";
        String[] words={"pay","attention","practice","attend"};
        System.out.println(prefixCount(words,pref));
    }
    static int prefixCount(String[] words, String pref) {
        int c=0;
        for(String word:words){
            if(word.startsWith(pref)){
                c++;
            }
        }
        return c;
    }
}
