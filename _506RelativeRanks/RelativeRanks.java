package Github._506RelativeRanks;
//506. Relative Ranks
//https://leetcode.com/problems/relative-ranks/description/
import java.util.Arrays;

public class RelativeRanks {
    public static void main(String[] args) {
        int[] scores={10,3,8,9,4};
        System.out.println(Arrays.toString(findRelativeRanks(scores)));
    }
//    2ms
    static String[] findRelativeRanks(int[] score) {
        int n=score.length;
        String[] res=new String[n];
        int maxScore=0;
        for (int j : score) {
            maxScore = Math.max(maxScore, j);
        }
        int[] map=new int[maxScore+1];
        for(int i=0;i<n;i++){
            map[score[i]]=i+1;
        }
        int place=1;
        for(int i=maxScore;i>=0;i--){
            if(map[i]==0){
                continue;
            }
            int index=map[i]-1;
            String val = switch (place) {
                case 1 -> "Gold Medal";
                case 2 -> "Silver Medal";
                case 3 -> "Bronze Medal";
                default -> String.valueOf(place);
            };
            res[index]=val;
            place++;
        }

        return res;
    }

//    9ms
//    static String[] findRelativeRanks(int[] score) {
//        int n=score.length;
//        String[] res=new String[n];
//        HashMap<Integer,Integer> map=new HashMap<>();
//        for(int i=0;i<n;i++){
//            map.put(score[i],i);
//        }
//        Arrays.sort(score);
//
//        for (int i=n-1;i>=0;i--){
//            int index=map.get(score[i]);
//            String val=String.valueOf(n-i);
//            val = switch (val) {
//                case "1" -> "Gold Medal";
//                case "2" -> "Silver Medal";
//                case "3" -> "Bronze Medal";
//                default -> val;
//            };
//            res[index]=val;
//        }
//        return res;
//    }
}
