class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int n = cardPoints.length;
        int lsum = 0, rsum = 0, msum = 0;
        for (int i = 0; i <= k-1 ; i++) {
            lsum += cardPoints[i];
        }
        msum = lsum;
        int j = n - 1;
        for (int i = k - 1; i >= 0; i--) {
            lsum -= cardPoints[i];
            rsum += cardPoints[j];
            j--;
            msum = Math.max(msum, lsum + rsum);
        }
        return msum;
    }
}