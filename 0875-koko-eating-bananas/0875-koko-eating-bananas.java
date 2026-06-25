class Solution {

    public int minEatingSpeed(int[] piles, int h) {

        int max = 0;
        // Find maximum pile
        for (int pile : piles) {
            max = Math.max(max, pile);
        }
        int start = 1;      
        int end = max;   
        int ans = max;

        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (canFinish(piles, h, mid)) {
                ans = mid;
                end = mid - 1;   // try smaller speed
            } else {
                start = mid + 1; // increase speed
            }
        }
        return ans;
    }

    private boolean canFinish(int[] piles, int h, int k) {
        int totalHours = 0;
        for (int pile : piles) {
            totalHours += (pile + k - 1) / k;
            if (totalHours > h)
                return false;
        }
        return true;
    }
}