import java.util.Arrays;

class Solution {
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) return "";

        StringBuilder res = new StringBuilder();
        Arrays.sort(strs);

        char[] ft = strs[0].toCharArray();
        char[] lt = strs[strs.length - 1].toCharArray();

        for (int i = 0; i < ft.length; i++) {
            if (i >= lt.length || ft[i] != lt[i]) {
                break;
            }
            res.append(ft[i]);
        }
        return res.toString();
    }
}