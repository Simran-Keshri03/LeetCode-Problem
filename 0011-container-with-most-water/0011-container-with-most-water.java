class Solution {
    public int maxArea(int[] height) {

        int n = height.length;
        int i = 0;
        int j = n - 1;
        int maxArea = 0;

        while (i < j) {
            int width = j - i;
            int h = Math.min(height[i], height[j]);
            maxArea = Math.max(maxArea, width * h);

            if (height[i] < height[j]) i++;
            else j--;
        }
        return maxArea;
    }
}