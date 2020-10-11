package sort.tester;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.StopWatch;

import java.util.concurrent.TimeUnit;
import java.util.function.UnaryOperator;

@Slf4j
public class DoubleTester {
    private static final int SIZE = 200000;
    private static final int TIMES = 10;

    private long verifyWithDoubleCore(UnaryOperator<Double[]> sort, String searchMethod) {
        Double[] target = generateRandomDouble();
        StopWatch stopWatch = StopWatch.createStarted();
        target = sort.apply(target);
        stopWatch.stop();
        long time = stopWatch.getTime(TimeUnit.MILLISECONDS);
        if (!isOrderedAscAsDouble(target)) {
            log.error("Wrong Answer happens in {} with target Array:{}", searchMethod, StringUtils.join(target, " "));
        }
        return time;
    }


    public void verifyWithDouble(UnaryOperator<Double[]> sort, String searchMethod) {
        int sum = 0;
        for (int i = 0; i < TIMES; i++) {
            sum += verifyWithDoubleCore(sort, searchMethod);
        }
        log.info("On average {} takes {} ms to sort {} double numbers with {} RUNS", searchMethod, sum / TIMES, SIZE, TIMES);
    }

    private Double[] generateRandomDouble() {
        Double[] res = new Double[SIZE];
        for (int i = 0; i < SIZE; i++) {
            res[i] = Math.random();
        }
        return res;
    }

    private boolean isOrderedAscAsDouble(Double[] nums) {
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i + 1] < nums[i]) {
                return false;
            }
        }
        return true;
    }
}
