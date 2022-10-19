package hw3.thread;

import hw3.HW3;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Queue;

public class CustomThread implements Runnable {

    private static final Logger logger = LoggerFactory.getLogger(HW3.class);

    Queue<Integer> queue;

    public CustomThread(Queue<Integer> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        while (queue.size() > 0) {
            int x = queue.poll();

            if (x % 2 == 0) {
                x /= 2;
            } else {
                x = x * 3 + 1;
            }

            if (x != 1) {
                queue.add(x);
            }

            logger.info(queue.toString());
        }
    }
}
