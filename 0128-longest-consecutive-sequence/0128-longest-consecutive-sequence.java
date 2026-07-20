import java.util.Arrays;

class Solution {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        int longest = 0;
        for (int num : set) {
            int curr =1;
            if(set.contains(num-1))
                continue;
            if(set.contains(num+1)){
                while(set.contains(++num))
                    curr++;
            }
            longest = Math.max(longest, curr);
        }
        return longest;
    }
}