package ru.digitalhabbits.homework2;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Counter characters in given string
 */
public interface LetterCounter {

    void count(String input, ConcurrentHashMap<Character, Long> map);

}
