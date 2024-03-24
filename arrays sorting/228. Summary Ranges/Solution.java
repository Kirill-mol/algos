import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Solution {
    public List<String> summaryRanges(int[] nums) {
        if (nums.length == 0) {
            return Collections.emptyList();
        }

        List<String> ranges = new ArrayList<>(nums.length);
        int curRangeStart = nums[0];
        int curRangeEnd = nums[0];

        for(int i = 1; i < nums.length; i++) {
            if (nums[i] == curRangeEnd + 1) {
                curRangeEnd = nums[i];
            } else {
                ranges.add(getRange(curRangeStart, curRangeEnd));
                curRangeStart = nums[i];
                curRangeEnd = nums[i];
            }
        }
        ranges.add(getRange(curRangeStart, curRangeEnd));
        return ranges;
    }

    public String getRange(int start, int end) {
        if (start == end) {
            return Integer.toString(start);
        } else {
            return "%d->%d".formatted(start, end);
        }
    }
}