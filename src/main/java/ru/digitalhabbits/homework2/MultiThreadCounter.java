package ru.digitalhabbits.homework2;

import lombok.SneakyThrows;
import ru.digitalhabbits.homework2.impl.LetterCounterImpl;

import java.util.Map;
import java.util.Queue;

public class MultiThreadCounter implements Runnable {

    private final Map<Character, Long> map;    // финальная мапа куда суммируются все мапа из листа
    private final Queue<String> queue;
    private final LetterCounter counter = new LetterCounterImpl();

    public MultiThreadCounter(Map<Character, Long> map, Queue<String> queue) {
        this.map = map;
        this.queue = queue;
    }

    @SneakyThrows
    @Override
    public void run() {
        for (;;) {
            if (queue.isEmpty()) {
                //Thread.sleep(10);
            } else {
                String nextString = queue.remove();
                if (nextString.equals("endOfQueueMarker")) {
                    break;
                }
                counter.count(nextString, map);
            }
        }
    }
}

