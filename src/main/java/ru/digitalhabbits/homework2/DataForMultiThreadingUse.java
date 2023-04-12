package ru.digitalhabbits.homework2;

import java.io.File;
import java.util.Map;
import java.util.Queue;

public final class DataForMultiThreadingUse {

    private final Queue<String> queue;
    private final Map<Character, Long> map;
    private final File file;

    public DataForMultiThreadingUse(Queue<String> queue, Map<Character, Long> map, File file) {
        this.queue = queue;
        this.map = map;
        this.file = file;
    }

    public Queue<String> getQueue() {
        return queue;
    }

    public Map<Character, Long> getMap() {
        return map;
    }

    public File getFile() {
        return file;
    }
}
