package Github._1358NumberOfSubstringsContainingAllThreeCharacters;

//1358. Number of Substrings Containing All Three Characters
//https://leetcode.com/problems/number-of-substrings-containing-all-three-characters/description/


public class NumberOfSubstringsContaingAllThreeCharacters {
    public static void main(String[] args) {
        String s="abcabc";
        System.out.println(numberOfSubstrings(s));
    }
    static int numberOfSubstrings(String s) {
        int ct=0;
        int[] lastSeen={-1,-1,-1};
        for(int i=0;i<s.length();i++){
            lastSeen[s.charAt(i)-'a']=i;
//            if(lastSeen[0]!=-1&&lastSeen[1]!=-1&&lastSeen[2]!=-1){
                ct=ct+(1+Math.min(lastSeen[0],Math.min(lastSeen[1],lastSeen[2])));
//            }

        }
        return ct;
    }
}
