
//https://leetcode.com/problems/pascals-triangle/description/
//_118.Pascal'sTriangle
package Github._118PascalsTriangle;

import java.util.ArrayList;
import java.util.List;

public class Pascals_Triangle {
    public static void main(String[] args) {
        int n=5;
        System.out.println(generate(n));
    }
    static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> s=new ArrayList<>();
        for(int i=0;i<numRows;i++){
            ArrayList<Integer> temp=new ArrayList<>();
            for(int j=0;j<=i;j++){
                if(j==0||i==j){
                    temp.add(1);
                }
                else{
                    int first=s.get(i-1).get(j);
                    int second=s.get(i-1).get(j-1);
                    temp.add(first+second);
                }
            }
            s.add(temp);
        }
        return s;
    }
}
