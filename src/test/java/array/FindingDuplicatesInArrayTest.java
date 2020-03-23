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
    public void testFor1And2_1() {
        int[] input1 = {2, 3, 1, 0, 2, 5, 3};
        // input1 might be altered by the first algorithm.
        int[] input2 = {2, 3, 1, 0, 2, 5, 3};
        Set<Integer> expectedPossibilities = new HashSet<>();
        expectedPossibilities.add(2);
        expectedPossibilities.add(3);
        var t0 = System.nanoTime();
        int res1 = findDuplicatesInArray.findDuplicatesInArray1(input1);
        var t1 = System.nanoTime();
        int res2 = findDuplicatesInArray.findDuplicatesInArray2(input2);
        var t2 = System.nanoTime();
        System.out.println("The time for findDuplicatesInArray1 is" + (t1 - t0) + " Nano seconds");
        System.out.println("The time for findDuplicatesInArray2 is" + (t2 - t1) + " Nano seconds");
        Assert.assertTrue(expectedPossibilities.contains(res1));
        Assert.assertTrue(expectedPossibilities.contains(res2));
    }

    @Test
    public void testFor1And2_2() {
        int[] input1 = {3, 3, 2, 1, 0};
        // input1 might be altered by the first algorithm.
        int[] input2 = {3, 3, 2, 1, 0};
        Set<Integer> expectedPossibilities = new HashSet<>();
        expectedPossibilities.add(3);
        var t0 = System.nanoTime();
        int res1 = findDuplicatesInArray.findDuplicatesInArray1(input1);
        var t1 = System.nanoTime();
        int res2 = findDuplicatesInArray.findDuplicatesInArray2(input2);
        var t2 = System.nanoTime();
        System.out.println("The time for findDuplicatesInArray1 is" + (t1 - t0) + " Nano seconds");
        System.out.println("The time for findDuplicatesInArray2 is" + (t2 - t1) + " Nano seconds");
        Assert.assertTrue(expectedPossibilities.contains(res1));
        Assert.assertTrue(expectedPossibilities.contains(res2));
    }

    @Test
    public void testFor3_1() {
        int[] input = {2, 3, 5, 4, 3, 2, 6, 7};
        Set<Integer> expectedPossibilities = new HashSet<>();
        expectedPossibilities.add(2);
        expectedPossibilities.add(3);
        var t0 = System.nanoTime();
        int res = findDuplicatesInArray.findDuplicatesInArrayWithNoEdit(input);
        var t1 = System.nanoTime();
        System.out.println("The time for findDuplicatesInArrayWithNoEdit is" + (t1 - t0) + " Nano seconds");
        Assert.assertTrue(expectedPossibilities.contains(res));
    }


}
