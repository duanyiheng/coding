package array;

/**
 * 剑指offer第二版-第三题
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

    public int findDuplicatesInArray3(int[] input) {
        if (null == input || input.length < MINIMUM_LENGTH_REQUIRED) {
            throw new IllegalArgumentException("The input array does not exist or contains less than 2 elements.");
        }
        int length = input.length;
        int start = 0;
        int end = length - 1;

        while (start <= end) {
            if (start == end) {
                return start;
            }
            int mid = (start + end + 1) / 2;
            int hit = countNumOfHitsByRange(input, start, mid);
            if (hit > mid - start + 1) {
                end = mid;
            } else if (hit == mid - start + 1) {

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
