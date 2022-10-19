package hw2.utils;

import java.util.concurrent.ThreadLocalRandom;

public class CustomRandom {

    public static int getIntRand(int min, int max) {
        return ThreadLocalRandom.current().nextInt(min, ++max);
    }

    public static double getDoubleRand(int min, int max) {
        return ThreadLocalRandom.current().nextDouble(min, ++max);
    }
}
