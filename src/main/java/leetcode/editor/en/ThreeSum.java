package leetcode.editor.en;
//Given an array nums of n integers, are there elements a, b, c in nums such tha
//t a + b + c = 0? Find all unique triplets in the array which gives the sum of ze
//ro. 
//
// Notice that the solution set must not contain duplicate triplets. 
//
// 
// Example 1: 
// Input: nums = [-1,0,1,2,-1,-4]
//Output: [[-1,-1,2],[-1,0,1]]
// Example 2: 
// Input: nums = []
//Output: []
// Example 3: 
// Input: nums = [0]
//Output: []
// 
// 
// Constraints: 
//
// 
// 0 <= nums.length <= 3000 
// -105 <= nums[i] <= 105 
// 
// Related Topics Array Two Pointers 
// 👍 8015 👎 877

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {
    public static void main(String[] args) {
        Solution solution = new ThreeSum().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<Integer>> threeSum(int[] nums) {
            List<List<Integer>> res = new ArrayList<>();
            if (nums != null && nums.length > 2) {
                Arrays.sort(nums);
                int n = nums.length;
                for (int i = 0; i < n - 2; i++) {
                    if (i > 0 && nums[i - 1] == nums[i]) {
                        continue;
                    }
                    if (nums[i] + nums[i + 1] + nums[i + 2] > 0) {
                        break;
                    }
                    if (nums[i] + nums[n - 2] + nums[n - 1] < 0) {
                        continue;
                    }
                    int j = i + 1;
                    int k = n - 1;
                    while (j < k) {
                        int sum = nums[i] + nums[j] + nums[k];
                        if (sum > 0) {
                            k--;
                        } else if (sum < 0) {
                            j++;
                        } else {
                            res.add(Arrays.asList(nums[i], nums[j], nums[k]));
                            while (j < k && nums[j] == nums[j + 1]) {
                                j++;
                            }
                            while (j < k && nums[k] == nums[k - 1]) {
                                k--;
                            }
                            j++;
                            k--;
                        }
                    }
                }
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
