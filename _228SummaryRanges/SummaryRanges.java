package Github._228SummaryRanges;

//228. Summary Ranges
//https://leetcode.com/problems/summary-ranges/submissions/1491445826/

import java.util.ArrayList;
import java.util.List;

public class SummaryRanges {
    public static void main(String[] args) {
        int[] nums = {0, 1, 2, 4, 5, 7};
        System.out.println(summaryRanges(nums));
    }
    static List<String> summaryRanges(int[] nums) {
        if (nums.length == 0) {
            return List.of();
        }
        List<String> result = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            StringBuilder sb = new StringBuilder();
            int start = nums[i];
            while (i + 1 < nums.length && nums[i + 1] - nums[i] == 1) {
                i++;
            }
            if (start != nums[i]) {
                sb.append(start).append("->").append(nums[i]);
                result.add(sb.toString());
            } else {
                sb.append(start);
                result.add(sb.toString());
            }
        }
        return result;
    }
}
