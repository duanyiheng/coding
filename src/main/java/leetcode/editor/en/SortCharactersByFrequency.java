package leetcode.editor.en;
//Given a string, sort it in decreasing order based on the frequency of characte
//rs. 
//
// Example 1:
// 
//Input:
//"tree"
//
//Output:
//"eert"
//
//Explanation:
//'e' appears twice while 'r' and 't' both appear once.
//So 'e' must appear before both 'r' and 't'. Therefore "eetr" is also a valid a
//nswer.
// 
// 
//
// Example 2:
// 
//Input:
//"cccaaa"
//
//Output:
//"cccaaa"
//
//Explanation:
//Both 'c' and 'a' appear three times, so "aaaccc" is also a valid answer.
//Note that "cacaca" is incorrect, as the same characters must be together.
// 
// 
//
// Example 3:
// 
//Input:
//"Aabb"
//
//Output:
//"bbAa"
//
//Explanation:
//"bbaA" is also a valid answer, but "Aabb" is incorrect.
//Note that 'A' and 'a' are treated as two different characters.
// 
// Related Topics Hash Table Heap 
// 👍 1915 👎 135

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SortCharactersByFrequency {
    public static void main(String[] args) {
        Solution solution = new SortCharactersByFrequency().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String frequencySort(String s) {
            Map<Character, Integer> char2FrequencyMap = new HashMap<>();
            for (char c : s.toCharArray()) {
                char2FrequencyMap.put(c, char2FrequencyMap.getOrDefault(c, 0) + 1);
            }
            List<Character>[] bucket = new ArrayList[s.length() + 1];
            for (char key : char2FrequencyMap.keySet()) {
                int frequency = char2FrequencyMap.get(key);
                if (bucket[frequency] == null) {
                    bucket[frequency] = new ArrayList<>();
                }
                bucket[frequency].add(key);
            }
            StringBuilder sb = new StringBuilder();
            for (int i = bucket.length - 1; i >= 0; i--) {
                if (bucket[i] == null) {
                    continue;
                }
                for (char c : bucket[i]) {
                    sb.append(String.valueOf(c).repeat(i));
                }
            }
            return sb.toString();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}

