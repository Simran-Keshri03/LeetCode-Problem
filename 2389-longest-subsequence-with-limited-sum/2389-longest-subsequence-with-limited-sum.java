import java.util.*;

class Solution {
    public int[] answerQueries(int[] nums, int[] queries) {

        // Step 1: Sort nums
        Arrays.sort(nums);

        // Step 2: Prefix sum
        int n = nums.length;
        long[] prefix = new long[n];

        prefix[0] = nums[0];

        for (int i = 1; i < n; i++) {
            prefix[i] = prefix[i - 1] + nums[i];
        }

        // Step 3: Binary search for every query
        int[] ans = new int[queries.length];

        for (int i = 0; i < queries.length; i++) {
            ans[i] = upperBound(prefix, queries[i]);
        }

        return ans;
    }

    // Returns number of prefix sums <= target
    private int upperBound(long[] prefix, int target) {

        int left = 0;
        int right = prefix.length;

        while (left < right) {

            int mid = left + (right - left) / 2;

            if (prefix[mid] <= target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        return left;
    }
}