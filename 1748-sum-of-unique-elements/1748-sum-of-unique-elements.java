class Solution {
    public int sumOfUnique(int[] nums) {
        int[] freq = new int[101];
        int sum = 0;

        for (int num : nums) {
            freq[num]++;

            if (freq[num] == 1) {
                sum += num;
            } else if (freq[num] == 2) {
                sum -= num;
            }
        }

        return sum;
    }
}