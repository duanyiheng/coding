package leetcode.editor.en;
//Given a 32-bit signed integer, reverse digits of an integer. 
//
// Example 1: 
//
// 
//Input: 123
//Output: 321
// 
//
// Example 2: 
//
// 
//Input: -123
//Output: -321
// 
//
// Example 3: 
//
// 
//Input: 120
//Output: 21
// 
//
// Note: 
//Assume we are dealing with an environment which could only store integers with
//in the 32-bit signed integer range: [−231, 231 − 1]. For the purpose of this pro
//blem, assume that your function returns 0 when the reversed integer overflows. 
// Related Topics Math 
// 👍 3723 👎 5834

public class ReverseInteger {
    public static void main(String[] args) {
        Solution solution = new ReverseInteger().new Solution();
        System.out.println(solution.reverse(1));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int reverse(int x) {
            int rev = 0;
            boolean isNegative = x < 0;
            while (x != 0) {
                int pop = x % 10;
                if (isNegative) {
                    if (rev < (Integer.MIN_VALUE - pop) / 10) {
                        return 0;
                    }
                } else {
                    if (rev > (Integer.MAX_VALUE - pop) / 10) {
                        return 0;
                    }
                }
                rev = rev * 10 + pop;
                x = x / 10;
            }
            return rev;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}

