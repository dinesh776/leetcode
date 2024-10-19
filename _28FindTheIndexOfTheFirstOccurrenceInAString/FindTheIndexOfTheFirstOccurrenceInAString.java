package Github._28FindTheIndexOfTheFirstOccurrenceInAString;

//28. Find the Index of the First Occurrence in a String
//https://leetcode.com/problems/find-the-index-of-the-first-occurrence-in-a-string/description/


public class FindTheIndexOfTheFirstOccurrenceInAString {
    public static void main(String[] args) {
        String haystack = "leetcode", needle = "code";
        System.out.println(strStr(haystack,needle));
    }
    static int strStr(String haystack, String needle) {
        return haystack.indexOf(needle);
    }
}


//        Brute Force
//        int n=needle.length(),i,j;
//        for(i=0;i<=haystack.length()-n;i++){
//            for(j=0;j<n;j++){
//                if(haystack.charAt(i+j)!=needle.charAt(j)){
//                    break;
//                }
//            }
//            if(j==n){
//                return i;
//            }
//        }
//        return -1;

//        KMP Algo
//        int[] Lps= new int[needle.length()];
////        Arrays.fill(Lps,0);
//        int i=1,prev=0;
//        while (i<needle.length()){
//            if(needle.charAt(i)==needle.charAt(prev)){
//                Lps[i]=prev+1;
//                i++;
//                prev++;
//            }
//            else if(prev==0){
//                Lps[i]=0;
//                i++;
//            }
//            else{
//                prev=Lps[prev-1];
//            }
//        }
//
//        int k=0,j=0;
//        while(k<haystack.length()){
//            if(haystack.charAt(k)==needle.charAt(j)){
//                k++;
//                j++;
//            }
//            else{
//                if(j==0){
//                    k++;
//                }
//                else{
//                    j=Lps[j-1];
//                }
//            }
//            if(j==needle.length()){
//                return k-needle.length();
//            }
//        }
//        return -1;