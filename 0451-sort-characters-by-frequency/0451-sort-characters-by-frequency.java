class Solution {
    public String frequencySort(String s) {
        int[] freq = new int[128];

        for (char c : s.toCharArray()) {
            freq[c]++;
        }

        List<Character>[] bucket = new List[s.length() + 1];

        for (int i = 0; i < 128; i++) {
            if (freq[i] > 0) {
                if (bucket[freq[i]] == null) {
                    bucket[freq[i]] = new ArrayList<>();
                }
                bucket[freq[i]].add((char) i);
            }
        }

        StringBuilder sb = new StringBuilder();

        for (int i = bucket.length - 1; i > 0; i--) {
            if (bucket[i] != null) {
                for (char c : bucket[i]) {
                    for (int j = 0; j < i; j++) {
                        sb.append(c);
                    }
                }
            }
        }

        return sb.toString();
    }
}