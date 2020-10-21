package sort.method;

public class HeapSort<T extends Comparable<T>> extends Sort<T> {
    @Override
    public T[] sort(T[] nums) {
        int end = nums.length - 1;
        // create heap
        for (int k = (end - 1) / 2; k >= 0; k--) {
            sink(nums, k, end);
        }
        // sort
        while (end > 0) {
            swap(nums, 0, end--);
            sink(nums, 0, end);
        }
        return nums;
    }

    private void sink(T[] nums, int k, int end) {
        while (2 * k + 1 <= end) {
            int j = 2 * k + 1;
            if (j < end && less(nums[j], nums[j + 1])) {
                j++;
            }
            if (!less(nums[k], nums[j])) {
                break;
            }
            swap(nums, k, j);
            k = j;
        }
    }

    @Override
    public String getSortMethodName() {
        return "HeapSort";
    }
}
