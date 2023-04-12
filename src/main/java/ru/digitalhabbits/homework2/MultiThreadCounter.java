package ru.digitalhabbits.homework2;

import lombok.SneakyThrows;
import ru.digitalhabbits.homework2.impl.LetterCounterImpl;

public class MultiThreadCounter implements Runnable {


    private final DataForMultiThreadingUse data;


    private final LetterCounter counter = new LetterCounterImpl();

    public MultiThreadCounter(DataForMultiThreadingUse data ) {

        this.data = data;
    }

    @SneakyThrows
    @Override
    public void run() {
        for (;;) {
            if (data.getQueue().isEmpty()) {
                //Thread.sleep(10);
            } else {
                String nextString = data.getQueue().remove();
                if (nextString.equals("endOfQueueMarker")) {
                    break;
                }
                counter.count(nextString, data.getMap());
            }
        }
    }
}

