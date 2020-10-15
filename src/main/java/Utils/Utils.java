package Utils;

import java.util.concurrent.ThreadLocalRandom;

public class Utils {
    public static long time() {
        return System.currentTimeMillis();
    }

    public static int randomNumber(int min, int max) {
        return ThreadLocalRandom.current().nextInt(min, max + 1);
    }
}
