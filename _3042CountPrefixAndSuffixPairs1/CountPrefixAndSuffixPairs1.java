package Github._3042CountPrefixAndSuffixPairs1;
//3042. Count Prefix and Suffix Pairs I
//https://leetcode.com/problems/count-prefix-and-suffix-pairs-i/description/?envType=daily-question&envId=2025-01-08
public class CountPrefixAndSuffixPairs1 {
    public static void main(String[] args) {
        String[] words = {"abab","ab"};
        System.out.println(countPrefixSuffixPairs(words));
    }
    static int countPrefixSuffixPairs(String[] words) {
        int c=0;
        int n= words.length;
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                if(isPrefixAndSuffix(words[i],words[j])){
                    c++;
                }
            }
        }
        return c;
    }
    static boolean isPrefixAndSuffix(String word,String target){
        return target.startsWith(word) && target.endsWith(word);
    }
}
