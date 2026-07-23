class Solution {
    public void sortColors(int[] arr) {
        int s = 0, mid = 0, e = arr.length - 1;
        while (mid <= e) {
            if (arr[mid] == 0) {
                int t = arr[s];
                arr[s] = arr[mid];
                arr[mid] = t;
                s++;
                mid++;
            } else if (arr[mid] == 1) {
                mid++;
            } else {
                int p = arr[mid];
                arr[mid] = arr[e];
                arr[e] = p;
                e--;
            }
        }
    }
}