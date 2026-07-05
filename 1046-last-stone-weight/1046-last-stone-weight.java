class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int a : stones){
            pq.offer(a);
        }
        while(pq.size()>1){
            int ft = pq.poll();
            int se = pq.poll();
            int diff = Math.abs(ft - se);
            pq.offer(diff);
        }
        return pq.poll();
    }
}