package Github._1408StringMatchingInAnArray;
//1408. String Matching in an Array
//https://leetcode.com/problems/string-matching-in-an-array/description/?envType=daily-question&envId=2025-01-07

import java.util.ArrayList;
import java.util.List;

public class StringMatchingInAnArray {
    public static void main(String[] args) {
        String[] words = {"blue", "green", "bu"};
        System.out.println(stringMatching(words));
    }

    static List<String> stringMatching(String[] words) {
        List<String> list = new ArrayList<>();
        int n = words.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i != j && words[j].contains(words[i])) {
                    list.add(words[i]);
                    break;
                }
            }
        }
        return list;
    }
}
