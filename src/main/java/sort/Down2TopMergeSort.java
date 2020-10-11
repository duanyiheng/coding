package sort;

public class Down2TopMergeSort<T extends Comparable<T>> extends MergeSort<T> {
    @Override
    public T[] sort(T[] nums) {
        int n = nums.length;
        aux = (T[]) new Comparable[n];
        for (int arraySize = 1; arraySize < n; arraySize = arraySize * 2) {
            for (int l = 0; l < n - arraySize; l += arraySize * 2) {
                merge(nums, l, l + arraySize - 1, Math.min(l + arraySize * 2 - 1, n - 1));
            }
        }
        return nums;
    }

    @Override
    public String getSortMethodName() {
        return "Down2Top Merge Sort";
    }
}
