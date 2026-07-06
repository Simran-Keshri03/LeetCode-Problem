class Solution {
    public int kthSmallest(int[][] matrix, int k) {

        PriorityQueue<Integer> maxHeap =
                new PriorityQueue<>((a, b) -> b - a);

        for (int[] row : matrix) {
            for (int num : row) {

                maxHeap.offer(num);

                if (maxHeap.size() > k) {
                    maxHeap.poll();
                }
            }
        }

        return maxHeap.peek();
    }
}