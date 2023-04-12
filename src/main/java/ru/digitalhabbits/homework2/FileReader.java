package ru.digitalhabbits.homework2;

import java.io.IOException;
import java.util.Queue;

/**
 * Sequential file reader
 */
public interface FileReader {

    Queue<String> readLines(DataForMultiThreadingUse data) throws IOException;

}
