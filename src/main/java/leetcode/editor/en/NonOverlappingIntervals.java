package leetcode.editor.en;
//Given a collection of intervals, find the minimum number of intervals you need
// to remove to make the rest of the intervals non-overlapping. 
//
// 
// 
//
// 
//
// Example 1: 
//
// 
//Input: [[1,2],[2,3],[3,4],[1,3]]
//Output: 1
//Explanation: [1,3] can be removed and the rest of intervals are non-overlappin
//g.
// 
//
// Example 2: 
//
// 
//Input: [[1,2],[1,2],[1,2]]
//Output: 2
//Explanation: You need to remove two [1,2] to make the rest of intervals non-ov
//erlapping.
// 
//
// Example 3: 
//
// 
//Input: [[1,2],[2,3]]
//Output: 0
//Explanation: You don't need to remove any of the intervals since they're alrea
//dy non-overlapping.
// 
//
// 
//
// Note: 
//
// 
// You may assume the interval's end point is always bigger than its start point
//. 
// Intervals like [1,2] and [2,3] have borders "touching" but they don't overlap
// each other. 
// 
// Related Topics Greedy 
// 👍 1653 👎 46

import java.util.Arrays;
import java.util.Comparator;

public class NonOverlappingIntervals {
    public static void main(String[] args) {
        Solution solution = new NonOverlappingIntervals().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int eraseOverlapIntervals(int[][] intervals) {
            int l = intervals.length;
            if (l == 0) {
                return 0;
            }
            // Using Lambda(Comparator.comparingInt(o -> o[1]))to build comparator makes it slower.
            Arrays.sort(intervals, new Comparator<int[]>() {
                @Override
                public int compare(int[] o1, int[] o2) {
                    return (o1[1] < o2[1]) ? -1 : (o1[1] == o2[1] ? 0 : 1);
                }
            });
            int cnt = 1;
            int end = intervals[0][1];
            for (int i = 1; i < l; i++) {
                if (intervals[i][0] < end) {
                    continue;
                }
                end = intervals[i][1];
                cnt++;
            }
            return l - cnt;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}

