class Solution {
    public int[] kthSmallestPrimeFraction(int[] arr, int k) {
        int n = arr.length;
        double low = 0.0, high = 1.0;

        while (true) {
            double mid = (low + high) / 2.0;

            int count = 0;
            int num = 0, den = 1;
            int j = 1;

            for (int i = 0; i < n - 1; i++) {
                while (j < n && arr[i] > mid * arr[j]) {
                    j++;
                }

                if (j == n) break;

                count += (n - j);

                if ((long) arr[i] * den > (long) num * arr[j]) {
                    num = arr[i];
                    den = arr[j];
                }
            }

            if (count == k) {
                return new int[]{num, den};
            } else if (count < k) {
                low = mid;
            } else {
                high = mid;
            }
        }
    }
}