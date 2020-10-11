package sort;

public abstract class Sort<T extends Comparable<T>> {
    public abstract T[] sort(T[] nums);

    public abstract String getSortMethodName();

    protected boolean less(T i, T j) {
        return i.compareTo(j) < 0;
    }

    protected void swap(T[] nums, int i, int j) {
        T tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
