package ru.digitalhabbits.homework2;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Counter characters in given string
 */
public interface LetterCounter {

    Map<Character, Long> count(String input, ConcurrentHashMap<Character, Long> map);

}
