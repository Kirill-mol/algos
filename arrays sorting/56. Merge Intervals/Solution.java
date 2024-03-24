import java.util.Arrays;

class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        int[][] resultIntervals = new int[intervals.length][2];
        int[] curResultInterval = intervals[0];
        int resultIndex = 0;

        for (int i = 1; i < intervals.length; i++) {
            int[] curInterval = intervals[i];
            if (curInterval[0] <= curResultInterval[1]) {
                curResultInterval[1] = Integer.max(curInterval[1], curResultInterval[1]);
            } else {
                resultIntervals[resultIndex++] = curResultInterval;
                curResultInterval = curInterval;
            }
        }
        resultIntervals[resultIndex++] = curResultInterval;

        return Arrays.copyOfRange(resultIntervals, 0, resultIndex);
    }
}