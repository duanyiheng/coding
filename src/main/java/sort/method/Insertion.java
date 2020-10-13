package sort.method;

public class Insertion<T extends Comparable<T>> extends Sort<T> {
    @Override
    public T[] sort(T[] nums) {
        for (int i = 1; i < nums.length; i++) {
            for (int j = i; j > 0; j--) {
                if (less(nums[j], nums[j - 1])) {
                    swap(nums, j, j - 1);
                } else {
                    break;
                }
            }
        }
        return nums;
    }

    @Override
    public String getSortMethodName() {
        return "Insertion sort";
    }
}
