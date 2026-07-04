class Solution {

    class Pair {
        int score;
        int index;

        Pair(int score, int index) {
            this.score = score;
            this.index = index;
        }
    }

    public String[] findRelativeRanks(int[] score) {

        int n = score.length;

        PriorityQueue<Pair> pq = new PriorityQueue<>(
            (a, b) -> b.score - a.score
        );

        for (int i = 0; i < n; i++) {
            pq.offer(new Pair(score[i], i));
        }

        String[] ans = new String[n];

        int rank = 1;

        while (!pq.isEmpty()) {

            Pair curr = pq.poll();

            if (rank == 1)
                ans[curr.index] = "Gold Medal";
            else if (rank == 2)
                ans[curr.index] = "Silver Medal";
            else if (rank == 3)
                ans[curr.index] = "Bronze Medal";
            else
                ans[curr.index] = String.valueOf(rank);

            rank++;
        }

        return ans;
    }
}