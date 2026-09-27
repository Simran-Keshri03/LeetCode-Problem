class Solution {
    public int findJudge(int n, int[][] trust) {
        int[] degree = new int[n + 1];

        for (int[] t : trust) {
            degree[t[0]]--; // person t[0] trusts someone
            degree[t[1]]++; // person t[1] is trusted
        }

        for (int i = 1; i <= n; i++) {
            if (degree[i] == n - 1) {
                return i;
            }
        }

        return -1;
    }
}