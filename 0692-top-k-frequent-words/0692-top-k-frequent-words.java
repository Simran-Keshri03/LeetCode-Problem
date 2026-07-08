class Solution {

    public List<String> topKFrequent(String[] words, int k) {

        HashMap<String, Integer> map = new HashMap<>();

        // Step 1 : Frequency Count
        for (String word : words) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }

        // Step 2 : Bucket
        List<String>[] bucket = new ArrayList[words.length + 1];

        for (int i = 0; i <= words.length; i++) {
            bucket[i] = new ArrayList<>();
        }

        for (String word : map.keySet()) {
            int freq = map.get(word);
            bucket[freq].add(word);
        }

        // Step 3 : Result
        List<String> ans = new ArrayList<>();

        for (int i = words.length; i >= 1 && ans.size() < k; i--) {

            if (bucket[i].size() > 0) {

                Collections.sort(bucket[i]); // lexicographical order

                for (String word : bucket[i]) {

                    ans.add(word);

                    if (ans.size() == k)
                        break;
                }
            }
        }

        return ans;
    }
}