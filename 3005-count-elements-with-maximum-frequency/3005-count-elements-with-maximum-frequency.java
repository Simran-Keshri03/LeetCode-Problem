class Solution {
    public int maxFrequencyElements(int[] nums) {
        // Constraints specify 1 <= nums[i] <= 100
        int[] frequencies = new int[101]; 
        int maxFrequency = 0;
        int totalMaxFrequencyElements = 0;

        for (int num : nums) {
            frequencies[num]++;
            int currentFrequency = frequencies[num];

            // Found a brand new maximum frequency
            if (currentFrequency > maxFrequency) {
                maxFrequency = currentFrequency;
                totalMaxFrequencyElements = currentFrequency; 
            } 
            // Found another element matching the current maximum frequency
            else if (currentFrequency == maxFrequency) {
                totalMaxFrequencyElements += currentFrequency;
            }
        }

        return totalMaxFrequencyElements;
    }
}
