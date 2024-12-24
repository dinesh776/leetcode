package Github._424LongestRepeatingCharacterReplacement;

//424. Longest Repeating Character Replacement
//https://leetcode.com/problems/longest-repeating-character-replacement/description/

public class longestRepeatingCharacter {
    public static void main(String[] args) {
        String s = "ABBB";
        int k=2;
        System.out.println(characterReplacement(s, k));
    }
    static int characterReplacement(String s, int k) {
        int maxFreq=0,maxLen=0;
        int i=0,j=0;
        int[] hash=new int[26];
        while(j<s.length()){
            hash[s.charAt(j)-'A']++;
            maxFreq=Math.max(maxFreq,hash[s.charAt(j)-'A']);
            while((j-i+1-maxFreq)>k){
                hash[s.charAt(i)-'A']--;
                i++;
            }
            if((j-i+1-maxFreq)<=k){
                maxLen=Math.max(maxLen,(j-i+1));
            }
            j++;
        }
        return maxLen;
    }
}
