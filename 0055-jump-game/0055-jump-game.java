class Solution {
    public boolean canJump(int[] nums) {
        int n = nums.length;
        int finPos = n - 1;
        for (int i = n - 2; i >= 0; i--) {
            if (i + nums[i] >= finPos) {
                finPos = i;
            }
        }
        return finPos == 0;
    }
}