package sort.tester;

import sort.*;

public class Entry {
    public static void main(String[] args) {
        DoubleTester doubleTester = new DoubleTester();
        Selection<Double> selection = new Selection<>();
        Insertion<Double> insertion = new Insertion<>();
        Bubble<Double> bubble = new Bubble<>();
        Shell<Double> shell = new Shell<>();
        Top2DownMergeSort<Double> top2DownMergeSort = new Top2DownMergeSort<>();
        Down2TopMergeSort<Double> down2TopMergeSort = new Down2TopMergeSort<>();
        QuickSort<Double> quickSort = new QuickSort<>();
        ThreeWayQuickSort<Double> threeWayQuickSort = new ThreeWayQuickSort<>();
/*        doubleTester.verifyWithDouble(selection::sort, selection.getSortMethodName());
        doubleTester.verifyWithDouble(insertion::sort, insertion.getSortMethodName());
        doubleTester.verifyWithDouble(bubble::sort, bubble.getSortMethodName());*/
        doubleTester.verifyWithDouble(shell::sort, shell.getSortMethodName());
        doubleTester.verifyWithDouble(top2DownMergeSort::sort, top2DownMergeSort.getSortMethodName());
        doubleTester.verifyWithDouble(down2TopMergeSort::sort, down2TopMergeSort.getSortMethodName());
        doubleTester.verifyWithDouble(quickSort::sort, quickSort.getSortMethodName());
        doubleTester.verifyWithDouble(threeWayQuickSort::sort, threeWayQuickSort.getSortMethodName());
    }
}
