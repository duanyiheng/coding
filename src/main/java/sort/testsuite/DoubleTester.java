package sort.testsuite;

import java.util.Random;

public class DoubleTester extends Tester<Double> {

    @Override
    protected Double[] generateRandom(int size) {
        Double[] res = new Double[size];
        Random random = new Random();
        for (int i = 0; i < size; i++) {
            res[i] = random.nextDouble();
        }
        return res;
    }

    @Override
    String getTesterType() {
        return "Double";
    }
}
