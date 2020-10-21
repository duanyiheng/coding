package leetcode.editor.en;
//Find the kth largest element in an unsorted array. Note that it is the kth lar
//gest element in the sorted order, not the kth distinct element. 
//
// Example 1: 
//
// 
//Input: [3,2,1,5,6,4] and k = 2
//Output: 5
// 
//
// Example 2: 
//
// 
//Input: [3,2,3,1,2,4,5,5,6] and k = 4
//Output: 4 
//
// Note: 
//You may assume k is always valid, 1 ≤ k ≤ array's length. 
// Related Topics Divide and Conquer Heap 
// 👍 4414 👎 290

public class KthLargestElementInAnArray {
    public static void main(String[] args) {
        Solution solution = new KthLargestElementInAnArray().new Solution();
        int[] nums = {3, 3, 3, 3, 3, 3};
        solution.findKthLargest(nums, 1);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int findKthLargest(int[] nums, int k) {
            int length = nums.length;
            if (length == 1) {
                return nums[0];
            }
            if (isOrderedAsc(nums)) {
                return nums[length - k];
            }
            k = length - k;
            int l = 0;
            int h = length - 1;
            while (l < h) {
                int j = partition(nums, l, h);
                if (j == k) {
                    return nums[k];
                } else if (j > k) {
                    h = j - 1;
                } else {
                    l = j + 1;
                }
            }
            return nums[k];
        }

        private int partition(int[] nums, int l, int h) {
            int v = nums[l];
            int i = l;
            int j = h + 1;
            while (true) {
                while (nums[++i] < v && i != h) ;
                while (nums[--j] > v && j != l) ;
                if (i >= j) {
                    break;
                }
                swap(nums, i, j);
            }
            swap(nums, l, j);
            return j;
        }

        private void swap(int[] nums, int i, int j) {
            int t = nums[i];
            nums[i] = nums[j];
            nums[j] = t;
        }

        protected boolean isOrderedAsc(int[] nums) {
            for (int i = 0; i < nums.length - 1; i++) {
                if (nums[i] > nums[i + 1]) {
                    return false;
                }
            }
            return true;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
