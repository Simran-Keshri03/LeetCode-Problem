import java.util.*;

class Solution {

    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        List<Integer>[] bucket = new ArrayList[nums.length + 1];
        for (int freq = 0; freq <= nums.length; freq++) {
            bucket[freq] = new ArrayList<>();
        }
        for (int key : map.keySet()) {   //putting into the buckets with high frequency 
            int freq = map.get(key);
            bucket[freq].add(key);
        }
        int[] ans = new int[k];   //high frequency buckets
        int idx = 0;
        for (int i = nums.length; i >= 0 && idx < k; i--) {
            for (int num : bucket[i]) {
                ans[idx++] = num;
                if (idx == k)
                    break;
            }
        }
        return ans;
    }
}