class Solution {

    class Node {
        int val;
        int row;
        int col;

        Node(int val, int row, int col) {
            this.val = val;
            this.row = row;
            this.col = col;
        }
    }

    public int kthSmallest(int[][] matrix, int k) {

        PriorityQueue<Node> pq = new PriorityQueue<>(
            (a, b) -> a.val - b.val
        );

        int n = matrix.length;

        // Insert first element of every row
        for (int i = 0; i < n; i++) {
            pq.offer(new Node(matrix[i][0], i, 0));
        }

        Node curr = null;

        while (k-- > 0) {

            curr = pq.poll();

            int row = curr.row;
            int col = curr.col;

            // Insert next element from same row
            if (col + 1 < n) {
                pq.offer(new Node(matrix[row][col + 1], row, col + 1));
            }
        }

        return curr.val;
    }
}