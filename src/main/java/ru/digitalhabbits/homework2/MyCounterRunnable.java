package ru.digitalhabbits.homework2;

import lombok.SneakyThrows;
import ru.digitalhabbits.homework2.impl.LetterCounterImpl;

import java.util.Queue;
import java.util.concurrent.ConcurrentHashMap;

public class MyCounterRunnable implements Runnable {

    private final ConcurrentHashMap<Character, Long> map;    // финальная мапа куда суммируются все мапа из листа
    private final Queue<String> queue;

    public MyCounterRunnable(ConcurrentHashMap<Character, Long> map, Queue<String> queue) {
        this.map = map;
        this.queue = queue;
    }

    @SneakyThrows
    @Override
    public void run() {
        LetterCounterImpl counter = new LetterCounterImpl();
        for (; ; ) {
            if (queue.isEmpty()) {
                Thread.sleep(10);
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

