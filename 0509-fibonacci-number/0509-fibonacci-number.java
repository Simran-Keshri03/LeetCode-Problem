class Solution {
    public int fib(int n) {
        if (n == 0) return 0;
        if (n == 1) return 1;

        int f = 0, s = 1, sum = 0;
        for (int i = 2; i <=n; i++) {
            int next = f + s;
            f = s;
            s = next;
        }

        return s;
    }
}
