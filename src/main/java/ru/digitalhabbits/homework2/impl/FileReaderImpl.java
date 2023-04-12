package ru.digitalhabbits.homework2.impl;

import ru.digitalhabbits.homework2.DataForMultiThreadingUse;
import ru.digitalhabbits.homework2.FileReader;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Queue;

public class FileReaderImpl implements FileReader  {

    @Override
    public Queue<String> readLines(DataForMultiThreadingUse data) throws IOException {

        BufferedReader reader =
                Files.newBufferedReader(Paths.get(data.getFile().toURI()));

        String s = reader.readLine();
        while (s != null) {
            data.getQueue().add(s);
            s = reader.readLine();
        }

        data.getQueue().add("endOfQueueMarker");
        reader.close();
        return data.getQueue();
    }
}
