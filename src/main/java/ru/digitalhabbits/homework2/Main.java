package ru.digitalhabbits.homework2;

import java.io.File;
import java.util.Queue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.LinkedBlockingQueue;

public class Main {

    //    static Queue<String> queue = new LinkedBlockingQueue<>();  // очередь в которую кладутся прочитанный из файла строки
//    static ConcurrentHashMap<Character, Long> map = new ConcurrentHashMap<>();    // финальная мапа куда суммируются все мапа из листа
//    static File file = new File("src/test/resources/test.txt");

    public static void main(String[] args) throws Exception {


        Queue<String> queue                    = new LinkedBlockingQueue<>();  // очередь в которую кладутся прочитанные из файла строки
        ConcurrentHashMap<Character, Long> map = new ConcurrentHashMap<>();    // финальная мапа куда суммируются все символы
        File file                              = new File("src/test/resources/test.txt");

        MyDownloader downloader = new MyDownloader(queue, file);
        downloader.download();

        MyCounterRunnable counting = new MyCounterRunnable(map, queue);

        // Запускаем подсчет в отдельном потоке
        Thread threadCounting = new Thread(counting);
        threadCounting.start();

        threadCounting.join();

        System.out.println(map);
    }
}
