package leetcode.editor.en;
//Given a non-negative integer c, decide whether there're two integers a and b s
//uch that a2 + b2 = c. 
//
// 
// Example 1: 
//
// 
//Input: c = 5
//Output: true
//Explanation: 1 * 1 + 2 * 2 = 5
// 
//
// Example 2: 
//
// 
//Input: c = 3
//Output: false
// 
//
// Example 3: 
//
// 
//Input: c = 4
//Output: true
// 
//
// Example 4: 
//
// 
//Input: c = 2
//Output: true
// 
//
// Example 5: 
//
// 
//Input: c = 1
//Output: true
// 
//
// 
// Constraints: 
//
// 
// 0 <= c <= 231 - 1 
// 
// Related Topics Math 
// 👍 585 👎 352

public class SumOfSquareNumbers {
    public static void main(String[] args) {
        Solution solution = new SumOfSquareNumbers().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean judgeSquareSum(int c) {
            if (c == 0 || c == 1 || c == 2) {
                return true;
            }
            int i = 0;
            int j = (int) Math.sqrt(c);
            int pow;
            while (i <= j) {
                pow = i * i + j * j;
                if (pow == c) {
                    return true;
                } else if (pow > c) {
                    j--;
                } else {
                    i++;
                }
            }
            return false;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}

