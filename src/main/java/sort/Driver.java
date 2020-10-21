package sort;

import sort.method.Down2TopMergeSort;
import sort.method.HeapSort;
import sort.method.QuickSort;
import sort.method.Shell;
import sort.method.ThreeWayQuickSort;
import sort.method.Top2DownMergeSort;
import sort.testsuite.DoubleTester;

public class Driver {
    public static void main(String[] args) {
        DoubleTester doubleTester = new DoubleTester();
        Shell<Double> shell = new Shell<>();
        Top2DownMergeSort<Double> top2DownMergeSort = new Top2DownMergeSort<>();
        Down2TopMergeSort<Double> down2TopMergeSort = new Down2TopMergeSort<>();
        QuickSort<Double> quickSort = new QuickSort<>();
        ThreeWayQuickSort<Double> threeWayQuickSort = new ThreeWayQuickSort<>();
        HeapSort<Double> heapSort = new HeapSort<>();
        doubleTester.verify(shell::sort, shell.getSortMethodName());
        doubleTester.verify(top2DownMergeSort::sort, top2DownMergeSort.getSortMethodName());
        doubleTester.verify(down2TopMergeSort::sort, down2TopMergeSort.getSortMethodName());
        doubleTester.verify(quickSort::sort, quickSort.getSortMethodName());
        doubleTester.verify(threeWayQuickSort::sort, threeWayQuickSort.getSortMethodName());
        doubleTester.verify(heapSort::sort, heapSort.getSortMethodName());
    }
}
