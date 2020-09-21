package leetcode.editor.en;
//Given a string s, find the longest palindromic substring in s. You may assume 
//that the maximum length of s is 1000. 
//
// Example 1: 
//
// 
//Input: "babad"
//Output: "bab"
//Note: "aba" is also a valid answer.
// 
//
// Example 2: 
//
// 
//Input: "cbbd"
//Output: "bb"
// 
// Related Topics String Dynamic Programming 
// 👍 8006 👎 573

public class LongestPalindromicSubstring {
    public static void main(String[] args) {
        Solution solution = new LongestPalindromicSubstring().new Solution();
        System.out.println(solution.longestPalindrome("abcba"));
    }


    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String longestPalindrome(String s) {
            if (s == null) {
                return null;
            }
            int length = s.length();
            if (length < 2) {
                return s;
            }
            int start = 0;
            int end = 0;
            int maxLength = 1;
            for (int i = 0; i < length - 1; i++) {
                int len = Math.max(expendAroundCenter(s, i, i), expendAroundCenter(s, i, i + 1));
                if (len > maxLength) {
                    maxLength = len;
                    start = i - (len - 1) / 2;
                    end = i + len / 2;
                }
            }
            return s.substring(start, end + 1);
        }

        private int expendAroundCenter(String s, int l, int r) {
            while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
                l--;
                r++;
            }
            return r - l - 1;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}

