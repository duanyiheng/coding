package sort.method;

/**
 * It could be quicker than quick sort when there are many duplicated records.
 *
 * @param <T>
 */
public class ThreeWayQuickSort<T extends Comparable<T>> extends QuickSort<T> {
    @Override
    protected void sort(T[] nums, int l, int h) {
        if (h <= l) {
            return;
        }
        int lt = l;
        int i = l + 1;
        int gt = h;
        T v = nums[l];
        while (i <= gt) {
            int cmp = nums[i].compareTo(v);
            if (cmp == 0) {
                i++;
            } else if (cmp < 0) {
                swap(nums, i++, lt++);
            } else {
                swap(nums, i, gt--);
            }
        }
        sort(nums, l, lt - 1);
        sort(nums, gt + 1, h);
    }

    @Override
    public String getSortMethodName() {
        return "Three Way Quick Sort";
    }
}
