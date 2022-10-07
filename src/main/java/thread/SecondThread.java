package thread;

import model.FirstDTO;
import model.SecondDTO;

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
