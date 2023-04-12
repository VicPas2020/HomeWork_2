package ru.digitalhabbits.homework2;

import lombok.SneakyThrows;
import ru.digitalhabbits.homework2.impl.FileReaderImpl;

public class FileToQueueReader {

    private final DataForMultiThreadingUse data;

    public FileToQueueReader(DataForMultiThreadingUse data) {
        this.data = data;
    }

    @SneakyThrows
    public void download() {
        FileReader fileReader = new FileReaderImpl();
        fileReader.readLines(data);
    }
}
