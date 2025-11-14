package by.nikiforova.homework.first;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CustomizedHashMapTest {
    private CustomizedHashMap<String, Integer> map;

    @BeforeEach
    public void setUp() {
        map = new CustomizedHashMap<>();
    }

    @Test
    public void put() {
        map.put("cat", 1);
        map.put("dog", 2);
        map.put("parrot", 3);

        Assertions.assertEquals(1, map.get("cat"));
        Assertions.assertEquals(2, map.get("dog"));
        Assertions.assertEquals(3, map.get("parrot"));

        assertNull(map.get("fish"));
    }

    @Test
    public void get() {
        map.put("cat", 1);
        map.put("dog", 2);
        map.put("parrot", 3);

        Assertions.assertEquals(1, map.get("cat"));
        Assertions.assertEquals(2, map.get("dog"));
        Assertions.assertEquals(3, map.get("parrot"));

        assertNull(map.get("fish"));
    }

    @Test
    public void remove() {
        map.put("cat", 1);
        map.put("dog", 2);
        map.put("parrot", 3);

        map.remove("cat");

        Assertions.assertEquals(2, map.get("dog"));
        Assertions.assertEquals(3, map.get("parrot"));

        assertNull(map.get("cat"));
    }
}