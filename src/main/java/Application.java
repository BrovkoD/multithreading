import model.FirstDTO;
import model.SecondDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import thread.FirstThread;
import thread.SecondThread;
import utils.CustomTimer;

import java.util.ArrayList;
import java.util.List;

import static java.lang.String.format;
import static utils.CustomRandom.getIntRand;
import static utils.CustomTimer.setCountDown;

public class Application {

    private static final Logger logger = LoggerFactory.getLogger(Application.class);

    private static final CustomTimer customTimer = new CustomTimer();

    private static final FirstDTO firstDTO = new FirstDTO(0);
    private static final SecondDTO secondDTO = new SecondDTO(0);

    private static final int MIN_N = 10;
    private static final int MAX_N = 20;

    public static void main(String[] args) {

        logger.info("Application started");

        final int N = getIntRand(MIN_N, MAX_N);
        final int HALF_N = N / 2;

        logger.info(format("N: %d; N/2: %d", N, HALF_N));

        List<Thread> threadList = new ArrayList<>();
        for (int i = 0; i < N; i++){
            if (i < HALF_N){
                threadList.add(new Thread(new FirstThread(firstDTO, secondDTO)));
            } else {
                threadList.add(new Thread(new SecondThread(firstDTO, secondDTO)));
            }
        }

        setCountDown(N);

        logger.info("Starting all threads...");

        threadList.forEach(Thread::start);
    }
}
