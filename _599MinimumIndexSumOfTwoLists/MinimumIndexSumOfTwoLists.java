package Github._599MinimumIndexSumOfTwoLists;
//599. Minimum Index Sum of Two Lists
//https://leetcode.com/problems/minimum-index-sum-of-two-lists/description/
import java.util.*;

public class MinimumIndexSumOfTwoLists {
    public static void main(String[] args) {
        String[] list1={"happy","sad","good"};
        String[] list2={"sad","happy","good"};
        System.out.println(Arrays.toString(findRestaurant(list1,list2)));
    }
    static String[] findRestaurant(String[] list1, String[] list2) {
        Map<String, Integer> indexMap = new HashMap<>();
        for (int i = 0; i < list1.length; i++) {
            indexMap.put(list1[i], i);
        }

        List<String> result = new ArrayList<>();
        int minIndexSum = Integer.MAX_VALUE;

        for (int j = 0; j < list2.length; j++) {
            String restaurant = list2[j];
            if (indexMap.containsKey(restaurant)) {
                int indexSum = j + indexMap.get(restaurant);

                if (indexSum < minIndexSum) {
                    // Found a smaller index sum, clear and update result
                    result.clear();
                    result.add(restaurant);
                    minIndexSum = indexSum;
                } else if (indexSum == minIndexSum) {
                    // Found another restaurant with the same minimum index sum
                    result.add(restaurant);
                }
            }
        }

        // Convert result list to array
        return result.toArray(new String[0]);
    }
}
