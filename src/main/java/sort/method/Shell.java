package sort.method;

public class Shell<T extends Comparable<T>> extends Sort<T> {

    @Override
    public T[] sort(T[] nums) {
        int length = nums.length;
        int h = 1;
        while (h < length / 3) {
            h = h * 3 + 1;
        }
        while (h >= 1) {
            for (int i = h; i < length; i++) {
                for (int j = i; j >= h && less(nums[j], nums[j - h]); j -= h) {
                    swap(nums, j, j - h);
                }
            }
            h /= 3;
        }
        return nums;
    }

    @Override
    public String getSortMethodName() {
        return "Shell Sort";
    }
}
