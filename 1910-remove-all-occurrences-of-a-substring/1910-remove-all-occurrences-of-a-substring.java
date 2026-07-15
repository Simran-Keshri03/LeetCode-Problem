class Solution {
    public String removeOccurrences(String s, String part) {

        StringBuilder sb = new StringBuilder();
        int m = part.length();

        for (char ch : s.toCharArray()) {

            sb.append(ch);

            if (sb.length() >= m &&
                sb.substring(sb.length() - m).equals(part)) {

                sb.setLength(sb.length() - m);
            }
        }

        return sb.toString();
    }
}