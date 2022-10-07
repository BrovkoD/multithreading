import model.FirstDTO;
import model.SecondDTO;
import thread.FirstThread;
import thread.SecondThread;
import utils.CustomTimer;

import java.util.ArrayList;
import java.util.List;

import static utils.CustomRandom.getRand;

public class Application {

    private static FirstDTO firstDTO = new FirstDTO(0);
    private static SecondDTO secondDTO = new SecondDTO(0);

    private static CustomTimer customTimer = new CustomTimer();

    private static final int MIN_N = 10;
    private static final int MAX_N = 20;

    public static void main(String[] args) {

        int N = getRand(MIN_N, MAX_N);
        int halfN = N / 2;

        System.out.printf("N: %d; N/2: %d%n%n", N, halfN);

        List<Thread> threadList = new ArrayList<>();

        for (int i = 0; i < N; i++){
            if (i < halfN){
                threadList.add(new Thread(new FirstThread(firstDTO, secondDTO)));
            } else {
                threadList.add(new Thread(new SecondThread(firstDTO, secondDTO)));
            }
        }

        customTimer.setCountDown(N);

        threadList.forEach(Thread::start);
    }
}
