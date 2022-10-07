package utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Duration;
import java.time.Instant;
import java.util.concurrent.locks.ReentrantLock;

import static java.lang.String.format;

public class CustomTimer {

    private static final Logger logger = LoggerFactory.getLogger(CustomTimer.class);

    private static final ReentrantLock lock = new ReentrantLock();

    private static int countDown = 0;
    private static Instant start;

    public CustomTimer() {
        start = Instant.now();
    }

    public static int getCountDown() {
        return countDown;
    }

    public static void setCountDown(Integer countDown) {
        CustomTimer.countDown = countDown;
    }

    public static void endCheck() {
        lock.lock();
        try {
            countDown--;
            if (countDown == 0) {
                logger.info(format("Execution of the threads is finished. Duration: %dms",
                        Duration.between(start, Instant.now()).toMillis()));

            } else {
//                logger.info(format("%d thread(s) left", countDown));
            }
        } catch (Exception e) {
            logger.warn("Error while executing endCheck method", e);
        } finally {
            lock.unlock();
        }
    }
}
