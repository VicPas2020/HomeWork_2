package ru.digitalhabbits.homework2;

import lombok.SneakyThrows;
import ru.digitalhabbits.homework2.impl.FileReaderImpl;

import java.io.File;
import java.util.Queue;

public class FileToQueueReader {

    private final Queue<String> queue ; // очередь в которую кладутся прочитанный из файла строки
    private final File input;


    public FileToQueueReader(Queue<String> queue, File input) {
        this.queue = queue;
        this.input = input;
    }

    @SneakyThrows
    public void download() {
        FileReader fileReader = new FileReaderImpl();
        fileReader.readLines(input, queue);
    }
}
