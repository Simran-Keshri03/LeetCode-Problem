class Solution {
    public int strStr(String haystack, String needle) {
        int n = haystack.length();
        int m = needle.length();

        for (int i = 0; i <= n - m; i++) {
            int first =i;
            int second = 0;

            while (second < m ) {
                if(haystack.charAt(first) != needle.charAt(second)){
                    break;
                }else{
                    first++;
                    second++;
                }
            }

            if (second == m) {
                return i;
            }
        }

        return -1;
    }
}