package sort.method;

public class Selection<T extends Comparable<T>> extends Sort<T> {
    @Override
    public T[] sort(T[] nums) {
        int length = nums.length;
        for (int i = 0; i < length - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < length; j++) {
                if (less(nums[j], nums[minIndex])) {
                    minIndex = j;
                }
            }
            swap(nums, i, minIndex);
        }
        return nums;
    }

    @Override
    public String getSortMethodName() {
        return "Selection Sort";
    }
}
