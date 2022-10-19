package HW2.thread;

import HW2.model.FirstDTO;
import HW2.model.SecondDTO;

public class FirstThread extends BaseThread {

    public FirstThread(FirstDTO firstDTO, SecondDTO secondDTO) {
        super(firstDTO, secondDTO);
    }

    @Override
    void executionSequence() {
        changeDTO(lock1, firstDTO);
        changeDTO(lock2, secondDTO);
    }
}
