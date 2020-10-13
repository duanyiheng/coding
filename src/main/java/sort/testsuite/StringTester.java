package sort.testsuite;

import org.apache.commons.lang3.RandomStringUtils;

public class StringTester extends Tester<String> {
    @Override
    protected String[] generateRandom(int size) {
        String[] res = new String[size];
        for (int i = 0; i < size; i++) {
            res[i] = RandomStringUtils.randomAlphabetic(20);
        }
        return res;
    }

    @Override
    String getTesterType() {
        return "String";
    }
}
