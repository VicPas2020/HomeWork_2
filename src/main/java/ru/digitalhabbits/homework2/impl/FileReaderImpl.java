package ru.digitalhabbits.homework2.impl;

import ru.digitalhabbits.homework2.FileReader;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Queue;

public class FileReaderImpl implements FileReader  {

    @Override
    public Queue<String> readLines(File file, Queue<String> queue) throws IOException {

        BufferedReader reader =
                Files.newBufferedReader(Paths.get(file.toURI()));

        String s = reader.readLine();
        while (s != null) {
            queue.add(s);
            s = reader.readLine();
        }

        queue.add("endOfQueueMarker");
        reader.close();
        return queue;
    }
}
