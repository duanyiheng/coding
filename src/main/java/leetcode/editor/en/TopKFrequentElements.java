package leetcode.editor.en;
//Given a non-empty array of integers, return the k most frequent elements. 
//
// Example 1: 
//
// 
//Input: nums = [1,1,1,2,2,3], k = 2
//Output: [1,2]
// 
//
// 
// Example 2: 
//
// 
//Input: nums = [1], k = 1
//Output: [1] 
// 
//
// Note: 
//
// 
// You may assume k is always valid, 1 ≤ k ≤ number of unique elements. 
// Your algorithm's time complexity must be better than O(n log n), where n is t
//he array's size. 
// It's guaranteed that the answer is unique, in other words the set of the top 
//k frequent elements is unique. 
// You can return the answer in any order. 
// 
// Related Topics Hash Table Heap 
// 👍 3887 👎 235

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TopKFrequentElements {
    public static void main(String[] args) {
        Solution solution = new TopKFrequentElements().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] topKFrequent(int[] nums, int k) {
            Map<Integer, Integer> num2Frequency = new HashMap<>();
            for (int num : nums) {
                num2Frequency.put(num, num2Frequency.getOrDefault(num, 0) + 1);
            }
            List<Integer>[] buckets = new ArrayList[nums.length + 1];
            for (int key : num2Frequency.keySet()) {
                int value = num2Frequency.get(key);
                if (buckets[value] == null) {
                    buckets[value] = new ArrayList<>();
                }
                buckets[value].add(key);
            }
            int[] topK = new int[k];
            int count = 0;
            int i = buckets.length - 1;
            while (count < k) {
                if (buckets[i] == null) {
                    i--;
                    continue;
                }
                if (buckets[i].size() <= (k - count)) {
                    for (Integer integer : buckets[i]) {
                        topK[count++] = integer;
                    }
                } else {
                    for (Integer integer : buckets[i].subList(0, k - count)) {
                        topK[count++] = integer;
                    }
                }
                i--;
            }
            return topK;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}

