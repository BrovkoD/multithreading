package hw2.thread;

import hw2.model.FirstDTO;
import hw2.model.SecondDTO;

public class SecondThread extends BaseThread {

    public SecondThread(FirstDTO firstDTO, SecondDTO secondDTO) {
        super(firstDTO, secondDTO);
    }

    @Override
    void executionSequence() {
        changeDTO(lock2, secondDTO);
        changeDTO(lock1, firstDTO);
    }
}
