class Solution {
    public long pickGifts(int[] gifts, int k) {

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);
        
        for (int gift : gifts) {
            maxHeap.offer(gift);
        }
        while (k-- > 0) {
            int largest = maxHeap.poll();
            int remaining = (int)Math.sqrt(largest);
            maxHeap.offer(remaining);
        }
        long sum = 0;
        while (!maxHeap.isEmpty()) {
            sum += maxHeap.poll();
        }
        return sum;
    }
}