package Github._1838FrequencyOfTheMostFrequentElement;
//1838. Frequency of the Most Frequent Element
//https://leetcode.com/problems/frequency-of-the-most-frequent-element/description/
import java.util.Arrays;

public class FrequencyOfTheMostFrequentElement {
    public static void main(String[] args) {
        int[] nums={1,2,4};
        int k=5;
        System.out.println(maxFrequency(nums,k));
    }
    public static int maxFrequency(int[] nums, int k) {
        Arrays.sort(nums);
        int left = 0;
        long total = 0;
        int result = 0;

        for (int right = 0; right < nums.length; right++) {
            total += nums[right];

            // Check if the current window is valid
            while ((long)nums[right] * (right - left + 1) > total + k) {
                total -= nums[left];
                left++;
            }

            // Update the result with the maximum window size
            result = Math.max(result, right - left + 1);
        }

        return result;
    }
}
