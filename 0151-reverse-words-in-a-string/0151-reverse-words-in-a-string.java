class Solution {

    public String reverseWords(String s) {
        char[] arr = s.toCharArray();
        int n = arr.length;

        reverse(arr, 0, n - 1);

        reverseEachWord(arr, n);

        return cleanSpaces(arr, n);
    }

    private void reverse(char[] arr, int left, int right) {
        while (left < right) {
            char temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;

            left++;
            right--;
        }
    }

    private void reverseEachWord(char[] arr, int n) {
        int start = 0;
        int end = 0;

        while (start < n) {

            while (start < end || start < n && arr[start] == ' ')
                start++;

            while (end < start || end < n && arr[end] != ' ')
                end++;

            reverse(arr, start, end - 1);
        }
    }

    private String cleanSpaces(char[] arr, int n) {
        int i = 0;
        int j = 0;

        while (j < n) {

            while (j < n && arr[j] == ' ')
                j++;

            while (j < n && arr[j] != ' ')
                arr[i++] = arr[j++];

            while (j < n && arr[j] == ' ')
                j++;

            if (j < n)
                arr[i++] = ' ';
        }

        return new String(arr, 0, i);
    }
}