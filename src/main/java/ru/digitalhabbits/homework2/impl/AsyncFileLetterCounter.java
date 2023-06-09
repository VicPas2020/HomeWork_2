package ru.digitalhabbits.homework2.impl;

import java.io.File;
import java.io.IOException;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.LinkedBlockingQueue;

import ru.digitalhabbits.homework2.DataForMultiThreadingUse;
import ru.digitalhabbits.homework2.FileLetterCounter;
import ru.digitalhabbits.homework2.MultiThreadCounter;

//todo Это копия MAIN класса для тестов
public class AsyncFileLetterCounter implements FileLetterCounter {
    @Override
    public Map<Character, Long> count(File input) {

        Queue<String> queue      = new LinkedBlockingQueue<>();  // очередь в которую кладутся прочитанные из файла строки
        Map<Character, Long> map = new ConcurrentHashMap<>();    // финальная мапа куда суммируются все символы
        File file                = new File("src/test/resources/test.txt");


        DataForMultiThreadingUse data = new DataForMultiThreadingUse(queue, map, file);


        FileReaderImpl fileReader = new FileReaderImpl();
        try {
            fileReader.readLines(data);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        MultiThreadCounter counting = new MultiThreadCounter(data);

        Thread threadCounting = new Thread(counting);
        threadCounting.start();

        try {
            threadCounting.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return map;
    }
}
