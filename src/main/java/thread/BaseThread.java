package thread;

import model.BaseDTO;
import model.FirstDTO;
import model.SecondDTO;
import utils.CustomTimer;

import java.util.concurrent.locks.ReentrantLock;

import static utils.CustomRandom.getRand;

public abstract class BaseThread extends CustomTimer implements Runnable {

    private static final int MIN_I = 10000;
    private static final int MAX_I = 20000;

    ReentrantLock lock1 = new ReentrantLock();
    ReentrantLock lock2 = new ReentrantLock();

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
            for (int i = 0; i < getRand(MIN_I, MAX_I); i++) {
                DTO.setNumber(DTO.getNumber() + 1);
            }
        } finally {
            System.out.println(Thread.currentThread().getName() + ": " + DTO.toString());
            lock.unlock();
        }
    }

//    <T extends BaseDTO> void changeDTO(ReentrantLock lock, T DTO) {
//        lock.lock();
//        try {
//            for (int i = 0; i < 100; i++) {
//                DTO.setNumber(DTO.getNumber() + 1);
//            }
//        } finally {
//            System.out.println(Thread.currentThread().getName() + ": " + DTO.toString());
//            lock.unlock();
//        }
//    }
}
