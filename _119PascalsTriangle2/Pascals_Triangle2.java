package Github._119PascalsTriangle2;
//119. Pascal's Triangle II
//https://leetcode.com/problems/pascals-triangle-ii/description/
import java.util.ArrayList;
import java.util.List;

public class Pascals_Triangle2 {
    public static void main(String[] args) {
        int rowIndex = 3;
        System.out.println(getRow(rowIndex));
    }
    static List<Integer> getRow(int rowIndex) {
//        optimised
        List<Integer> row = new ArrayList<>();

        row.add(1);

        for(int j =1;j<=rowIndex;j++){
            int val = (int) ((long) row.get(j - 1) * (rowIndex - j + 1) / j);

            row.add(val);
        }

        return row;

//        brute
//        List<List<Integer>> s=new ArrayList<>();
//        for(int i=0;i<=rowIndex;i++){
//            ArrayList<Integer> temp=new ArrayList<>();
//            for(int j=0;j<=i;j++){
//                if(j==0||i==j){
//                    temp.add(1);
//                }
//                else{
//                    int first=s.get(i-1).get(j);
//                    int second=s.get(i-1).get(j-1);
//                    temp.add(first+second);
//                }
//            }
//            s.add(temp);
//        }
//        return s.get(rowIndex);
    }
}
