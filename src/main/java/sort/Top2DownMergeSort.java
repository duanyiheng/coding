package sort;

public class Top2DownMergeSort<T extends Comparable<T>> extends MergeSort<T> {
    @Override
    public T[] sort(T[] nums) {
        aux = (T[]) new Comparable[nums.length];
        sort(nums, 0, nums.length - 1);
        return nums;
    }

    private void sort(T[] nums, int l, int h) {
        if (h <= l) {
            return;
        }
        int m = l + (h - l) / 2;
        sort(nums, l, m);
        sort(nums, m + 1, h);
        merge(nums, l, m, h);
    }

    @Override
    public String getSortMethodName() {
        return "Top2Down Merge Sort";
    }
}
