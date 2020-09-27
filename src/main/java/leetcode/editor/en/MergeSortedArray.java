package leetcode.editor.en;
//Given two sorted integer arrays nums1 and nums2, merge nums2 into nums1 as one
// sorted array. 
//
// Note: 
//
// 
// The number of elements initialized in nums1 and nums2 are m and n respectivel
//y. 
// You may assume that nums1 has enough space (size that is equal to m + n) to h
//old additional elements from nums2. 
// 
//
// Example: 
//
// 
//Input:
//nums1 = [1,2,3,0,0,0], m = 3
//nums2 = [2,5,6],       n = 3
//
//Output: [1,2,2,3,5,6]
// 
//
// 
// Constraints: 
//
// 
// -10^9 <= nums1[i], nums2[i] <= 10^9 
// nums1.length == m + n 
// nums2.length == n 
// 
// Related Topics Array Two Pointers 
// 👍 2612 👎 4446

public class MergeSortedArray {
    public static void main(String[] args) {
        Solution solution = new MergeSortedArray().new Solution();
        int[] nums1 = new int[]{1, 2, 3, 0, 0, 0};
        solution.merge(nums1, 3, new int[]{2, 5, 6}, 3);
        for (int i : nums1) {
            System.out.println(i);
        }

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public void merge(int[] nums1, int m, int[] nums2, int n) {
            int idx1 = m - 1;
            int idx2 = n - 1;
            int idxMerge = m + n - 1;
            while (idx1 >= 0 || idx2 >= 0) {
                if (idx1 < 0) {
                    nums1[idxMerge--] = nums2[idx2--];
                } else if (idx2 < 0) {
                    break;
                } else if (nums1[idx1] > nums2[idx2]) {
                    nums1[idxMerge--] = nums1[idx1--];
                } else {
                    nums1[idxMerge--] = nums2[idx2--];
                }
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}

