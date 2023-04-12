package ru.digitalhabbits.homework2.impl;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

import static com.google.common.io.Resources.getResource;
import static org.assertj.core.api.Assertions.assertThat;

class FileReaderImplTest {

    @Test
    void readLines() throws IOException {

        //given
        var file = getFile("readingTest.txt");
        Queue<String> queue  = new LinkedBlockingQueue<>();  // очередь в которую кладутся прочитанные из файла строки

        //then
        FileReaderImpl fileReader = new FileReaderImpl();
        Queue<String> strings = fileReader.readLines(file, queue);

        //when
        var poll = strings.poll();
        assertThat(strings).containsOnlyOnce("endOfQueueMarker");
        assertThat(poll).isEqualTo("abcdefgh");
        assertThat(poll).isNotNull();
        assertThat(!poll.isEmpty());
        assertThat(!poll.isBlank());
    }

    private File getFile(String name) {
        return new File(getResource(name).getPath());
    }
}