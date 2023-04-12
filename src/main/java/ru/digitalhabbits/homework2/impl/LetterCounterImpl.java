package ru.digitalhabbits.homework2.impl;

import ru.digitalhabbits.homework2.LetterCounter;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class LetterCounterImpl implements LetterCounter {
    @Override
    public Map<Character, Long> count(String input, ConcurrentHashMap<Character, Long> map) {

        for (char c : input.toCharArray()) {
            if (map.containsKey(c)) {
                map.put(c, map.get(c) + 1);
            } else {
                map.put(c, 1L);
            }
        }
        return map;
    }
}
