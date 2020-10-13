package sort.tester;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.StopWatch;

import java.util.concurrent.TimeUnit;
import java.util.function.UnaryOperator;

/**
 * @author duan_y
 */
@Slf4j
public abstract class Tester<T extends Comparable<T>> {
    protected static final int SIZE = 200000;
    protected static final int TIMES = 10;

    /**
     * Generate random T type data with the amount from size
     *
     * @param size
     * @return
     */
    abstract T[] generateRandom(int size);

    /**
     * Some literal info for child tester
     *
     * @return
     */
    abstract String getTesterType();

    protected long verifyCore(UnaryOperator<T[]> sort, String searchMethod) {
        T[] target = generateRandom(SIZE);
        StopWatch stopWatch = StopWatch.createStarted();
        target = sort.apply(target);
        stopWatch.stop();
        long time = stopWatch.getTime(TimeUnit.MILLISECONDS);
        if (!isOrderedAsc(target)) {
            log.error("Wrong Answer happens in {} with target Array:{}", searchMethod, StringUtils.join(target, " "));
        }
        return time;
    }

    public void verify(UnaryOperator<T[]> sort, String searchMethod) {
        int sum = 0;
        for (int i = 0; i < TIMES; i++) {
            sum += verifyCore(sort, searchMethod);
        }
        log.info("On average {} takes {} ms to sort {} {} with {} RUNS", searchMethod, sum / TIMES, SIZE, getTesterType(), TIMES);
    }

    protected boolean isOrderedAsc(T[] nums) {
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i].compareTo(nums[i + 1]) > 0) {
                return false;
            }
        }
        return true;
    }


}
