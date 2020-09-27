package leetcode.editor.en;
//Given an array of integers that is already sorted in ascending order, find two
// numbers such that they add up to a specific target number. 
//
// The function twoSum should return indices of the two numbers such that they a
//dd up to the target, where index1 must be less than index2. 
//
// Note: 
//
// 
// Your returned answers (both index1 and index2) are not zero-based. 
// You may assume that each input would have exactly one solution and you may no
//t use the same element twice. 
// 
//
// 
// Example 1: 
//
// 
//Input: numbers = [2,7,11,15], target = 9
//Output: [1,2]
//Explanation: The sum of 2 and 7 is 9. Therefore index1 = 1, index2 = 2.
// 
//
// Example 2: 
//
// 
//Input: numbers = [2,3,4], target = 6
//Output: [1,3]
// 
//
// Example 3: 
//
// 
//Input: numbers = [-1,0], target = -1
//Output: [1,2]
// 
//
// 
// Constraints: 
//
// 
// 2 <= nums.length <= 3 * 104 
// -1000 <= nums[i] <= 1000 
// nums is sorted in increasing order. 
// -1000 <= target <= 1000 
// 
// Related Topics Array Two Pointers Binary Search 
// 👍 1900 👎 646

public class TwoSumIiInputArrayIsSorted {
    public static void main(String[] args) {
        Solution solution = new TwoSumIiInputArrayIsSorted().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] twoSum(int[] numbers, int target) {
            // as we assume that each input would have exactly one solution
            int n = numbers.length;
            if (n == 2) {
                return new int[]{1, 2};
            } else {
                int i = 0;
                int j = n - 1;
                int sum;
                while (i < j) {
                    sum = numbers[i] + numbers[j];
                    if (sum == target) {
                        return new int[]{i + 1, j + 1};
                    } else if (sum > target) {
                        j--;
                    } else {
                        i++;
                    }
                }
            }
            throw new RuntimeException("illegal input that breaks the assumption.");
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}

