package ru.digitalhabbits.homework2;

import java.io.File;
import java.util.Queue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.LinkedBlockingQueue;

public class Main {
    public static void main(String[] args) throws Exception {

        Queue<String> queue                    = new LinkedBlockingQueue<>();  // очередь в которую кладутся прочитанные из файла строки
        ConcurrentHashMap<Character, Long> map = new ConcurrentHashMap<>();    // финальная мапа куда суммируются все символы
        File file                              = new File("src/test/resources/test.txt");

        FileToQueueReader reader = new FileToQueueReader(queue, file);
        reader.download();

        MultiThreadCounter counter = new MultiThreadCounter(map, queue);

        // Запускаем подсчет в отдельном потоке
        Thread threadCounting = new Thread(counter);
        threadCounting.start();

        // дожидаемся конци подсчета
        threadCounting.join();

        System.out.println(map);
    }
}
