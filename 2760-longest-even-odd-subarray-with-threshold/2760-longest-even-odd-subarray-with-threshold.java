
class Solution {
    public int longestAlternatingSubarray(int[] nums, int threshold) {

        int ans = 0;
        int count = 0;

        for (int i = 0; i < nums.length; i++) {

            if (nums[i] > threshold) {
                count = 0;
            }
            else if (count > 0 &&
                     nums[i] % 2 != nums[i - 1] % 2) {
                count++;
            }
            else {
                count = (nums[i] % 2 == 0) ? 1 : 0;
            }

            ans = Math.max(ans, count);
        }

        return ans;
    }
}
