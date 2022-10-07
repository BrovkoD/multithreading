package utils;

import java.time.Duration;
import java.time.Instant;
import java.util.concurrent.locks.ReentrantLock;

public class CustomTimer {

    private static ReentrantLock lock = new ReentrantLock();

    private static Instant start;
    private static Integer countDown = 0;

    public CustomTimer() {
        start = Instant.now();
    }

    public void setCountDown(Integer countDown) {
        CustomTimer.countDown = countDown;
    }

    protected static void endCheck() {
        lock.lock();
        try {
            countDown--;
            if (countDown == 0) {
                System.out.println("Duration: " + Duration.between(start, Instant.now()).toMillis());
            } else {
                System.out.println(Thread.currentThread().getName() + ": " + countDown + " thread(s) left");
            }
        } finally {
            lock.unlock();
        }
    }
}
