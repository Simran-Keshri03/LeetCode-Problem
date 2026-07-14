class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        int[] freq1 = new int[26]; // Frequency of p
        int[] freq2 = new int[26]; // Frequency of current window

        List<Integer> res = new ArrayList<>();

        // Store frequency of p
        for (char ch : p.toCharArray()) {
            freq1[ch - 'a']++;
        }

        int k = p.length();

        for (int i = 0; i < s.length(); i++) {

            // Add current character into window
            freq2[s.charAt(i) - 'a']++;

            // Remove character which is out of window
            if (i >= k) {
                freq2[s.charAt(i - k) - 'a']--;
            }

            // Compare both frequency arrays
            if (Arrays.equals(freq1, freq2)) {
                res.add(i - k + 1);
            }
        }

        return res;
    }
}