package sort.method;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class QuickSort<T extends Comparable<T>> extends Sort<T> {
    @Override
    public T[] sort(T[] nums) {
        shuffle(nums);
        sort(nums, 0, nums.length - 1);
        return nums;
    }

    protected void sort(T[] nums, int l, int h) {
        if (l >= h) {
            return;
        }
        int j = partition(nums, l, h);
        sort(nums, l, j - 1);
        sort(nums, j + 1, h);

    }

    private int partition(T[] nums, int l, int h) {
        int i = l + 1;
        int j = h;
        T v = nums[l];
        while (true) {
            while (less(nums[i], v) && i != h) {
                i++;
            }
            while (less(v, nums[j]) && j != l) {
                j--;
            }
            if (i >= j) {
                break;
            }
            swap(nums, i, j);
        }
        swap(nums, l, j);
        return j;
    }

    private void shuffle(T[] nums) {
        List<Comparable> list = Arrays.asList(nums);
        Collections.shuffle(list);
        list.toArray(nums);
    }

    @Override
    public String getSortMethodName() {
        return "Quick Sort";
    }

    /**
     * Find Kth element in linear time with partition method.
     *
     * @param nums
     * @param k
     * @return
     */
    public T select(T[] nums, int k) {
        int l = 0;
        int h = nums.length - 1;
        while (l < h) {
            int j = partition(nums, l, h);
            if (j == k) {
                return nums[j];
            } else if (k < j) {
                h = j - 1;
            } else {
                l = k + 1;
            }
        }
        return nums[k];
    }
}
