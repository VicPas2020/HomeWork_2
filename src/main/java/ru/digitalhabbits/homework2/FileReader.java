package ru.digitalhabbits.homework2;

import java.io.File;
import java.io.IOException;
import java.util.Queue;
import java.util.stream.Stream;

/**
 * Sequential file reader
 */
public interface FileReader {

    Queue<String> readLines(File file, Queue<String> queue) throws IOException;

}
