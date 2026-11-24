
class Solution {
    public int maxLength(int[] nums) {
        int n = nums.length;
        int ans = 0;

        int maxLCM = 1;
        int maxVal = 1;

        // Calculate maximum possible LCM of entire array
        for (int x : nums) {
            maxLCM = lcm(maxLCM, x);
            maxVal = Math.max(maxVal, x);
        }

        int limit = maxLCM * maxVal;

        for (int i = 0; i < n; i++) {
            int product = 1;
            int gcd = 0;
            int lcm = 1;

            for (int j = i; j < n; j++) {
                product *= nums[j];

                gcd = gcd(gcd, nums[j]);
                lcm = lcm(lcm, nums[j]);

                if (product == gcd * lcm) {
                    ans = Math.max(ans, j - i + 1);
                }

                // Product can only increase
                if (product > limit) {
                    break;
                }
            }
        }

        return ans;
    }

    private int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    private int lcm(int a, int b) {
        return (a / gcd(a, b)) * b;
    }
}
