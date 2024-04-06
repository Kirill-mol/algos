import java.util.*;

class Solution {
    public int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> prefixSumByValue = new HashMap<>(nums.length);
        prefixSumByValue.put(0, 1);
        int curSum = 0;
        int count = 0;

        for(int i = 0; i < nums.length; i++) {
            curSum += nums[i];

            if (prefixSumByValue.containsKey(curSum - k)) {
                count += prefixSumByValue.get(curSum - k);
            }
            
            prefixSumByValue.put(curSum, prefixSumByValue.getOrDefault(curSum, 0) + 1);
        }

        return count;
    }
}