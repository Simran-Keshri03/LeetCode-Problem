class Solution {
    public String removeDuplicateLetters(String s) {
        if (s.length() == 0)
            return "";
            int freq[] = new int[26];
        for (int i = 0; i < s.length(); i++) {
            freq[s.charAt(i) - 'a']++;
        }

        int pos = 0;

        // Find smallest lexicographical character
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) < s.charAt(pos)) {
                pos = i;
            }

            freq[s.charAt(i) - 'a']--;

            if (freq[s.charAt(i) - 'a'] == 0) {
                break;
            }
        }

        char ch = s.charAt(pos);

        // Remove duplicates of chosen character
        String remaining = s.substring(pos + 1).replaceAll("" + ch, "");

        return ch + removeDuplicateLetters(remaining);
    
    }
}