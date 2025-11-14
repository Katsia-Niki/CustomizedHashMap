package by.nikiforova.homework.first;

import java.util.LinkedList;

public class CustomizedHashMap<K, V> {
    private static final int DEFAULT_CAPACITY = 16;
    private static class Entry<K, V> {
        K key;
        V value;
        Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }
    private LinkedList<Entry<K, V>>[] buckets;

    @SuppressWarnings("unchecked")
    public CustomizedHashMap() {
        buckets = new LinkedList[DEFAULT_CAPACITY];
        for (int i = 0; i < DEFAULT_CAPACITY; i++) {
            buckets[i] = new LinkedList<>();
        }
    }

    private int getBucketIndex(K key) {
        return (key.hashCode() & 0x7FFFFFFF) % buckets.length;
    }

    public void put(K key, V value) {
        int index = getBucketIndex(key);
        for (Entry<K, V> entry : buckets[index]) {
            if (entry.key.equals(key)) {
                entry.value = value;
                return;
            }
        }
        buckets[index].add(new Entry<>(key, value));
    }

    public V get(K key) {
        int index = getBucketIndex(key);
        for (Entry<K, V> entry : buckets[index]) {
            if (entry.key.equals(key)) {
                return entry.value;
            }
        }
        return null;
    }

    public void remove(K key) {
        int index = getBucketIndex(key);
        LinkedList<Entry<K, V>> bucket = buckets[index];
        Entry<K, V> toRemove = null;
        for (Entry<K, V> entry : bucket) {
            if (entry.key.equals(key)) {
                toRemove = entry;
                break;
            }
        }
        if (toRemove != null) {
            bucket.remove(toRemove);
        }
    }

    public static void main(String[] args) {
        CustomizedHashMap<String, Integer> map = new CustomizedHashMap<>();
        map.put("cat", 1);
        map.put("dog", 2);
        map.put("parrot", 3);

        System.out.println(map.get("cat"));
        System.out.println(map.get("dog"));
        System.out.println(map.get("parrot"));
        System.out.println(map.get("fish"));

        map.remove("dog");
        System.out.println(map.get("dog"));
    }
}
