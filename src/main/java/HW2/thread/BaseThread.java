package HW2.thread;

import HW2.model.BaseDTO;
import HW2.model.FirstDTO;
import HW2.model.SecondDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import HW2.utils.CustomTimer;

import java.util.concurrent.locks.ReentrantLock;

import static java.lang.String.format;
import static HW2.utils.CustomRandom.getDoubleRand;
import static HW2.utils.CustomRandom.getIntRand;

public abstract class BaseThread extends CustomTimer implements Runnable {

    private static final Logger logger = LoggerFactory.getLogger(BaseThread.class);

    private static final int MIN_I = 10000;
    private static final int MAX_I = 20000;

    private static final int MIN_ADD = 0;
    private static final int MAX_ADD = 10;

    static final ReentrantLock lock1 = new ReentrantLock();
    static final ReentrantLock lock2 = new ReentrantLock();

    FirstDTO firstDTO;
    SecondDTO secondDTO;

    public BaseThread(FirstDTO firstDTO, SecondDTO secondDTO) {
        this.firstDTO = firstDTO;
        this.secondDTO = secondDTO;
    }

    @Override
    public void run() {
        executionSequence();
        endCheck();
    }

    abstract void executionSequence();

    <T extends BaseDTO> void changeDTO(ReentrantLock lock, T DTO) {
        lock.lock();
        try {
            for (int i = 0; i < getIntRand(MIN_I, MAX_I); i++) {
                DTO.setNumber(DTO.getNumber() + getDoubleRand(MIN_ADD, MAX_ADD));
            }
        } catch (Exception e) {
            logger.warn("Error while executing changeDTO method", e);
        } finally {
            if (getCountDown() == 1) {
                logger.info(format("Results: %s\t\t%s", firstDTO.toString(), secondDTO.toString()));
            }
            lock.unlock();
        }
    }

//    <T extends BaseDTO> void changeDTO(ReentrantLock lock, T DTO) {
//        lock.lock();
//        try {
//            for (int i = 0; i < 100; i++) {
//                DTO.setNumber(DTO.getNumber() + 1);
//            }
//        } catch (Exception e) {
//            logger.warn("Error while executing changeDTO method", e);
//        } finally {
//            if (getCountDown() == 1) {
//                logger.info(format("Results: %s\t\t%s", firstDTO.toString(), secondDTO.toString()));
//            }
//            lock.unlock();
//        }
//    }
}
