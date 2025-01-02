package Github._2559CountVowelStringsInRanges;
//2559. Count Vowel Strings in Ranges
//https://leetcode.com/problems/count-vowel-strings-in-ranges/description/?envType=daily-question&envId=2025-01-02
import java.util.Arrays;

public class CountVowelStringsInRange {
    public static void main(String[] args) {
        String[] words={"aba","bcb","ece","aa","e"};
        int[][] queries={{0,2},{1,4},{1,1}};
        System.out.println(Arrays.toString(vowelStrings(words,queries)));
    }
    static int[] vowelStrings(String[] words, int[][] queries) {
        int n=queries.length,k=0,m=words.length;
        int[] prefixSum=new int[m+1];
        for(int j=0;j<m;j++){
            if (isVowel(words[j].charAt(0)) && isVowel(words[j].charAt(words[j].length() - 1))) {
                prefixSum[j+1]=prefixSum[j]+1;
            }
            else{
                prefixSum[j+1]=prefixSum[j];
            }
        }

        int[] result=new int[n];
        for (int[] query : queries) {
            result[k++] = prefixSum[query[1]+1]-prefixSum[query[0]];
        }
        return result;
    }
    static boolean isVowel(char c){
        return c=='a'||c=='e'||c=='i'||c=='o'||c=='u';
    }
}
