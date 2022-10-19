package HW2;

import HW2.model.FirstDTO;
import HW2.model.SecondDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import HW2.thread.FirstThread;
import HW2.thread.SecondThread;
import HW2.utils.CustomTimer;

import java.util.ArrayList;
import java.util.List;

import static java.lang.String.format;
import static HW2.utils.CustomRandom.getIntRand;
import static HW2.utils.CustomTimer.setCountDown;

public class HW2 {

    private static final Logger logger = LoggerFactory.getLogger(HW2.class);

    private static final CustomTimer customTimer = new CustomTimer();

    private static final FirstDTO firstDTO = new FirstDTO(0);
    private static final SecondDTO secondDTO = new SecondDTO(0);

    private static final int MIN_N = 10;
    private static final int MAX_N = 20;

    public static void start() {

        logger.info("Application started");

        final int N = getIntRand(MIN_N, MAX_N);
        final int HALF_N = N / 2;

        logger.info(format("Amount of threads N = %d; %d of them are the first HW2.thread type", N, HALF_N));

        List<Thread> threadList = new ArrayList<>();

        for (int i = 0; i < HALF_N; i++){
            threadList.add(new Thread(new FirstThread(firstDTO, secondDTO)));
        }

        for (int i = HALF_N; i < N; i++){
            threadList.add(new Thread(new SecondThread(firstDTO, secondDTO)));
        }

        setCountDown(N);

        logger.info("Starting all threads...");

        threadList.forEach(Thread::start);
    }
}
