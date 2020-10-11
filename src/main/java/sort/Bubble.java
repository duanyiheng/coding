package sort;

public class Bubble<T extends Comparable<T>> extends Sort<T> {
    @Override
    public T[] sort(T[] nums) {
        boolean isSorted = false;
        for (int i = nums.length - 1; i > 0 && !isSorted; i--) {
            isSorted = true;
            for (int j = 0; j < i; j++) {
                if (less(nums[j + 1], nums[j])) {
                    swap(nums, j, j + 1);
                    isSorted = false;
                }
            }
        }
        return nums;
    }

    @Override
    public String getSortMethodName() {
        return "Bubble Sort";
    }
}
