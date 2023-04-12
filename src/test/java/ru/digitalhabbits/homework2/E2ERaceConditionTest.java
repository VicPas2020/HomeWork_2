package ru.digitalhabbits.homework2;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ru.digitalhabbits.homework2.impl.AsyncFileLetterCounter;

import java.io.File;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import static com.google.common.io.Resources.getResource;
import static org.assertj.core.api.Assertions.assertThat;

public class E2ERaceConditionTest {

    @Test
    @DisplayName("race condition")
    void async_file_letter_counting_should_return_predicted_count() {
        Set<Map<Character, Long>> racedMap = new HashSet<>();
        int numberOfCycles = 10_000;

        for (int i = 0; i < numberOfCycles; i++) {
            var file = getFile("test.txt");
            var counter = new AsyncFileLetterCounter();
            Map<Character, Long> count = counter.count(file);
            racedMap.add(count);
        }

        assertThat(racedMap).isNotNull();
        assertThat(racedMap.size() == 1).isTrue();
    }

    private File getFile(String name) {
        return new File(getResource(name).getPath());
    }
}
