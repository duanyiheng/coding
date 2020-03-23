package array;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;

import java.util.HashSet;
import java.util.Set;

public class FindingDuplicatesInArrayTest {
    @InjectMocks
    FindingDuplicatesInArray findDuplicatesInArray;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void test() {
        int[] input1 = {2, 3, 1, 0, 2, 5, 3};
        // input1 might be altered by the first algorithm.
        int[] input2 = {2, 3, 1, 0, 2, 5, 3};
        // input2 might be altered by the first algorithm.
        int[] input3 = {2, 3, 1, 0, 2, 5, 3};
        Set<Integer> expectedPossibilities = new HashSet<>();
        expectedPossibilities.add(2);
        expectedPossibilities.add(3);
        var t0 = System.nanoTime();
        int res1 = findDuplicatesInArray.findDuplicatesInArray1(input1);
        var t1 = System.nanoTime();
        int res2 = findDuplicatesInArray.findDuplicatesInArray2(input2);
        var t2 = System.nanoTime();
        int res3 = findDuplicatesInArray.findDuplicatesInArray3(input3);
        var t3 = System.nanoTime();
        System.out.println("The time for findDuplicatesInArray1 is" + (t1-t0) + "Nano seconds");
        System.out.println("The time for findDuplicatesInArray2 is" + (t2-t1) + "Nano seconds");
        System.out.println("The time for findDuplicatesInArray3 is" + (t3-t2) + "Nano seconds");
        Assert.assertTrue(expectedPossibilities.contains(res1));
        Assert.assertTrue(expectedPossibilities.contains(res2));
        Assert.assertTrue(expectedPossibilities.contains(res3));
    }

    @Test
    public void test2() {
        int[] input1 = {3, 3, 2, 1, 0};
        // input1 might be altered by the first algorithm.
        int[] input2 = {3, 3, 2, 1, 0};
        // input2 might be altered by the first algorithm.
        int[] input3 = {3, 3, 2, 1, 0};
        Set<Integer> expectedPossibilities = new HashSet<>();
        expectedPossibilities.add(3);
        var t0 = System.nanoTime();
        int res1 = findDuplicatesInArray.findDuplicatesInArray1(input1);
        var t1 = System.nanoTime();
        int res2 = findDuplicatesInArray.findDuplicatesInArray2(input2);
        var t2 = System.nanoTime();
        int res3 = findDuplicatesInArray.findDuplicatesInArray3(input3);
        var t3 = System.nanoTime();
        System.out.println("The time for findDuplicatesInArray1 is" + (t1-t0) + "Nano seconds");
        System.out.println("The time for findDuplicatesInArray2 is" + (t2-t1) + "Nano seconds");
        System.out.println("The time for findDuplicatesInArray3 is" + (t3-t2) + "Nano seconds");
        Assert.assertTrue(expectedPossibilities.contains(res1));
        Assert.assertTrue(expectedPossibilities.contains(res2));
        Assert.assertTrue(expectedPossibilities.contains(res3));
    }
}
