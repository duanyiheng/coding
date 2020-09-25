package leetcode.editor.en;
//Given an array nums of n integers and an integer target, are there elements a,
// b, c, and d in nums such that a + b + c + d = target? Find all unique quadruple
//ts in the array which gives the sum of target. 
//
// Note: 
//
// The solution set must not contain duplicate quadruplets. 
//
// Example: 
//
// 
//Given array nums = [1, 0, -1, 0, -2, 2], and target = 0.
//
//A solution set is:
//[
//  [-1,  0, 0, 1],
//  [-2, -1, 1, 2],
//  [-2,  0, 0, 2]
//]
// 
// Related Topics Array Hash Table Two Pointers 
// 👍 2343 👎 349

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FourSum {
    public static void main(String[] args) {
        Solution solution = new FourSum().new Solution();
        solution.fourSum(new int[]{1, 0, -1, 0, -2, 2},0);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<Integer>> fourSum(int[] nums, int target) {
            List<List<Integer>> res = new ArrayList<>();
            if (nums == null || nums.length < 4) {
                return res;
            }
            int n = nums.length;
            Arrays.sort(nums);
            for (int i = 0; i < n - 3; i++) {
                if (i > 0 && nums[i] == nums[i - 1]) {
                    continue;
                }
                if (nums[i] + nums[i + 1] + nums[i + 2] + nums[i + 3] > target) {
                    break;
                }
                if (nums[i] + nums[n - 3] + nums[n - 2] + nums[n - 1] < target) {
                    continue;
                }
                for (int j = i + 1; j < n - 2; j++) {
                    if (j > i + 1 && nums[j] == nums[j - 1]) {
                        continue;
                    }
                    int k = j + 1;
                    int h = n - 1;
                    if (nums[i] + nums[j] + nums[j + 1] + nums[j + 2] > target) {
                        break;
                    }
                    if (nums[i] + nums[j] + nums[n - 2] + nums[n - 1] < target) {
                        continue;
                    }
                    while (k < h) {
                        int sum = nums[i] + nums[j] + nums[k] + nums[h];
                        if (sum == target) {
                            res.add(Arrays.asList(nums[i], nums[j], nums[k], nums[h]));
                            k++;
                            while (k < h && nums[k] == nums[k - 1]) {
                                k++;
                            }
                            h--;
                            while (k < h && nums[h] == nums[h + 1]) {
                                h--;
                            }
                        } else if (sum > target) {
                            h--;
                        } else {
                            k++;
                        }
                    }

                }

            }
            return res;

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}

