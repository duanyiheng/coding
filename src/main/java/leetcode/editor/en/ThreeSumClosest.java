package leetcode.editor.en;
//Given an array nums of n integers and an integer target, find three integers i
//n nums such that the sum is closest to target. Return the sum of the three integ
//ers. You may assume that each input would have exactly one solution. 
//
// 
// Example 1: 
//
// 
//Input: nums = [-1,2,1,-4], target = 1
//Output: 2
//Explanation: The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
// 
//
// 
// Constraints: 
//
// 
// 3 <= nums.length <= 10^3 
// -10^3 <= nums[i] <= 10^3 
// -10^4 <= target <= 10^4 
// 
// Related Topics Array Two Pointers 
// 👍 2422 👎 155

import java.util.Arrays;

public class ThreeSumClosest {
    public static void main(String[] args) {
        Solution solution = new ThreeSumClosest().new Solution();
        System.out.println(solution.threeSumClosest(new int[]{1, 1, 1, 0}, 100));
    }

/*    public int threeSumClosest(int[] nums, int target) {
        int n = nums.length;
        if (n == 3) {
            return nums[0] + nums[1] + nums[2];
        } else {
            Arrays.sort(nums);
            int lastIthValue = 0;
            int gap = nums[0] + nums[1] + nums[n - 1] - target;
            int preDiff = nums[0] + nums[1] + nums[n - 1] - target;
            int diff = 0;
            for (int i = 0; i < n - 2; i++) {
                if (i > 0 && nums[i] == lastIthValue) {
                    continue;
                }
                int j = i + 1;
                int k = n - 1;
                while (j < k) {
                    if (diff != 0) {
                        preDiff = diff;
                    }
                    diff = nums[i] + nums[j] + nums[k] - target;
                    if (j == i + 1 && k == n - 1) {
                        gap = updateGap(gap, diff, preDiff);
                    }
                    if (diff == 0) {
                        return target;
                    } else if (diff > 0) {
                        if (preDiff > 0) {
                            k--;
                        }
                        if (preDiff <= 0) {
                            gap = updateGap(gap, diff, preDiff);
                        }
                    } else {
                        if (preDiff >= 0) {
                            gap = updateGap(gap, diff, preDiff);
                        }
                        if (preDiff < 0) {
                            j++;
                        }
                    }
                }
                lastIthValue = nums[i];
            }
            return target + gap;
        }
    }*/

/*    private int updateGap(int gap, int diff, int preDiff) {
        int smallerDiff = Math.abs(diff) < Math.abs(preDiff) ? diff : preDiff;
        return Math.abs(smallerDiff) < Math.abs(gap) ? smallerDiff : gap;
    }*/

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int threeSumClosest(int[] nums, int target) {
            int n = nums.length;
            if (n == 3) {
                return nums[0] + nums[1] + nums[2];
            } else {
                Arrays.sort(nums);
                int lastIthValue = 0;
                int gap = nums[0] + nums[1] + nums[n - 1] - target;
                int diff;
                for (int i = 0; i < n - 2; i++) {
                    if (i > 0 && nums[i] == lastIthValue) {
                        continue;
                    }
                    int j = i + 1;
                    int k = n - 1;
                    while (j < k) {
                        diff = nums[i] + nums[j] + nums[k] - target;
                        gap = Math.abs(diff) < Math.abs(gap) ? diff : gap;
                        if (diff == 0) {
                            return target;
                        } else if (diff > 0) {
                            k--;
                        } else {
                            j++;
                        }
                    }
                    lastIthValue = nums[i];
                }
                return target + gap;
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}

