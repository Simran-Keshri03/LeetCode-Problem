
class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> result = new ArrayList<>();

        int i = 0;

        while (i < words.length) {
            int j = i;
            int letters = 0;

            // Find maximum words that fit in one line
            while (j < words.length &&
                   letters + words[j].length() + (j - i) <= maxWidth) {
                letters += words[j].length();
                j++;
            }

            int gaps = j - i - 1;
            StringBuilder line = new StringBuilder();

            // Last line or single word: left justified
            if (j == words.length || gaps == 0) {
                for (int k = i; k < j; k++) {
                    line.append(words[k]);

                    if (k < j - 1) {
                        line.append(" ");
                    }
                }

                while (line.length() < maxWidth) {
                    line.append(" ");
                }
            } 
            else {
                int spaces = maxWidth - letters;
                int spacePerGap = spaces / gaps;
                int extraSpaces = spaces % gaps;

                for (int k = i; k < j - 1; k++) {
                    line.append(words[k]);

                    int count = spacePerGap + (k - i < extraSpaces ? 1 : 0);

                    line.append(" ".repeat(count));
                }

                line.append(words[j - 1]);
            }

            result.add(line.toString());
            i = j;
        }

        return result;
    }
}
