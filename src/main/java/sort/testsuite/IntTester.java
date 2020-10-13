package sort.testsuite;

import lombok.extern.slf4j.Slf4j;

import java.util.Random;

@Slf4j
public class IntTester extends Tester<Integer> {

    @Override
    protected Integer[] generateRandom(int size) {
        Integer[] res = new Integer[size];
        Random random = new Random();
        for (int i = 0; i < size; i++) {
            res[i] = random.nextInt();
        }
        return res;
    }

    @Override
    String getTesterType() {
        return "Integer";
    }
}
