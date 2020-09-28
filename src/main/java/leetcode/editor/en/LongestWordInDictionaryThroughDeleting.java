package leetcode.editor.en;
//
//Given a string and a string dictionary, find the longest string in the diction
//ary that can be formed by deleting some characters of the given string. If there
// are more than one possible results, return the longest word with the smallest l
//exicographical order. If there is no possible result, return the empty string.
// 
// Example 1: 
// 
//Input:
//s = "abpcplea", d = ["ale","apple","monkey","plea"]
//
//Output: 
//"apple"
// 
// 
//
// 
// Example 2: 
// 
//Input:
//s = "abpcplea", d = ["a","b","c"]
//
//Output: 
//"a"
// 
// 
//
// Note: 
// 
// All the strings in the input will only contain lower-case letters. 
// The size of the dictionary won't exceed 1,000. 
// The length of all the strings in the input won't exceed 1,000. 
// 
// Related Topics Two Pointers Sort 
// 👍 627 👎 244

import java.util.List;

public class LongestWordInDictionaryThroughDeleting {
    public static void main(String[] args) {
        Solution solution = new LongestWordInDictionaryThroughDeleting().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String findLongestWord(String s, List<String> d) {
            String longestWord = "";
            for (String ele : d) {
                int l1 = longestWord.length();
                int l2 = ele.length();
                if (l1 > l2 || (l1 == l2 && longestWord.compareTo(ele) < 0)) {
                    continue;
                }
                if (isSubSeq(s.toCharArray(), ele.toCharArray())) {
                    longestWord = ele;
                }
            }
            return longestWord;

        }

        private boolean isSubSeq(char[] sArray, char[] eleArray) {
            int i = 0;
            int j = 0;
            while (i < sArray.length && j < eleArray.length) {
                if (sArray[i] == eleArray[j]) {
                    j++;
                }
                i++;
            }
            return j == eleArray.length;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}

