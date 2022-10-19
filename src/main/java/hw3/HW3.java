package hw3;

import hw3.thread.CustomThread;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import static utils.CustomRandom.getIntRand;

public class HW3 {

    private static final Logger logger = LoggerFactory.getLogger(HW3.class);

    private static final int MAX_THREADS = Runtime.getRuntime().availableProcessors();
    private static final int MIN_NUM = 1;
    private static final int MAX_NUM = 100;

    public static void start() {

        logger.info("HW3 started");

        int numAmount = getIntRand(MIN_NUM, MAX_NUM);
        int numsPerThread = (int) Math.ceil((double) numAmount/MAX_THREADS);

        logger.info("Amount of numbers: {}, places for new threads: {}, numbers per thread: {}", numAmount, MAX_THREADS, numsPerThread);

        List<Thread> threadList = new ArrayList<>();
        int addedNums = 0;
        for (int i = 0; i < MAX_THREADS; i++){

            Queue<Integer> queue = new LinkedList<>();
            for (int x = 0; x < numsPerThread; x++) {

                queue.add(getIntRand(MIN_NUM, MAX_NUM));
                addedNums++;

//                limit nums in the last used thread
                if (addedNums == numAmount) {
                    break;
                }
            }

            threadList.add(new Thread(new CustomThread(queue)));

//            limit threads
            if (addedNums == numAmount) {
                break;
            }
        }

        logger.info("Starting all threads...");
        threadList.forEach(Thread::start);
    }
}
