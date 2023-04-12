package ru.digitalhabbits.homework2.impl;

import org.junit.jupiter.api.Test;

import java.util.Map;
import java.util.Objects;
import java.util.Queue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.LinkedBlockingQueue;

import static org.assertj.core.api.Assertions.assertThat;

class LetterCounterImplTest {

    @Test
    void count() {

        //given
        Queue<String> queue  = new LinkedBlockingQueue<>();
        queue.add("aabbcdefg");

        Map<Character, Long> map = new ConcurrentHashMap<>();

        //then
        LetterCounterImpl counter = new LetterCounterImpl();
        counter.count(Objects.requireNonNull(queue.poll()), map);

        //when
        assertThat(map).isNotNull();

        assertThat(map).containsEntry('a',2L);
        assertThat(map).containsEntry('b',2L);
        assertThat(map).containsEntry('c',1L);
        assertThat(map).containsEntry('d',1L);
        assertThat(map).containsEntry('e',1L);
        assertThat(map).containsEntry('f',1L);
        assertThat(map).containsEntry('g',1L);

        assertThat(map).doesNotContainEntry('a', 1L);
        assertThat(map).doesNotContainEntry('b', 1L);
        assertThat(map).doesNotContainEntry('c', 2L);
        assertThat(map).doesNotContainEntry('d', 2L);
        assertThat(map).doesNotContainEntry('e', 2L);
        assertThat(map).doesNotContainEntry('f', 2L);
        assertThat(map).doesNotContainEntry('g', 2L);
        assertThat(map).doesNotContainEntry('x', 1L);
    }
}