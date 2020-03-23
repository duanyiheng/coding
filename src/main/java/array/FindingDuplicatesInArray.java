package array;

/**
 * 面试题3（一）：找出数组中重复的数字
 * 题目：在一个长度为n的数组里的所有数字都在0到n-1的范围内。数组中某些数字是重复的，但不知道有几个数字重复了，
 * 也不知道每个数字重复了几次。请找出数组中任意一个重复的数字。例如，如果输入长度为7的数组{2, 3, 1, 0, 2, 5, 3}，
 * 那么对应的输出是重复的数字2或者3。
 *
 * @author duanyiheng
 */
public class FindingDuplicatesInArray {

    public static final int MINIMUM_LENGTH_REQUIRED = 2;

    public int findDuplicatesInArray1(int[] input) {
        if (null == input || input.length < MINIMUM_LENGTH_REQUIRED) {
            throw new IllegalArgumentException("The input array does not exist or contains less than 2 elements.");
        }
        int length = input.length;
        for (int i = 0; i < length; i++) {
            input[input[i] % length] += length;
            if (input[i] >= 2 * length) {
                return i;
            }
        }
        for (int i = 0; i < length; i++) {
            if (input[i] >= 2 * length) {
                return i;
            }
        }
        throw new IllegalArgumentException("The input array does contain even one pair of duplicate.");
    }

    public int findDuplicatesInArray2(int[] input) {
        if (null == input || input.length < MINIMUM_LENGTH_REQUIRED) {
            throw new IllegalArgumentException("The input array does not exist or contains less than 2 elements.");
        }
        int length = input.length;
        for (int i = 0; i < length; i++) {
            while (input[i] != i) {
                if (input[i] == input[input[i]]) {
                    return input[i];
                } else {
                    int tmp = input[i];
                    input[i] = input[tmp];
                    input[tmp] = tmp;
                }
            }
        }
        throw new IllegalArgumentException("The input array does contain even one pair of duplicate.");
    }

    // 面试题3（二）：不修改数组找出重复的数字
    // 题目：在一个长度为n+1的数组里的所有数字都在1到n的范围内，所以数组中至
    // 少有一个数字是重复的。请找出数组中任意一个重复的数字，但不能修改输入的
    // 数组。例如，如果输入长度为8的数组{2, 3, 5, 4, 3, 2, 6, 7}，那么对应的
    // 输出是重复的数字2或者3。
    public int findDuplicatesInArrayWithNoEdit(int[] input) {
        if (null == input || input.length < MINIMUM_LENGTH_REQUIRED) {
            throw new IllegalArgumentException("The input array does not exist or contains less than 2 elements.");
        }
        int length = input.length;
        int start = 1;
        int end = length - 1;

        while (start <= end) {
            if (start == end) {
                return start;
            }
            int mid = (start + end + 1) / 2;
            int hit = countNumOfHitsByRange(input, start, mid);
            if (hit > mid - start + 1) {
                end = mid;
            } else {
                start = mid + 1;
            }
        }

        throw new IllegalArgumentException("The input array does contain even one pair of duplicate.");
    }

    private int countNumOfHitsByRange(int[] input, int start, int end) {
        int res = 0;
        for (var value : input) {
            if (value >= start && value <= end) {
                res++;
            }
        }
        return res;
    }
}
