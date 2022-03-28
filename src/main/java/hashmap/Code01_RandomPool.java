package hashmap;

import java.util.HashMap;

public class Code01_RandomPool {

    public static class pool<K> {
        private HashMap<K, Integer> keyIndexMap;
        private HashMap<Integer, K> indexKeyMap;
        int size;
        pool() {
            keyIndexMap = new HashMap<>();
            indexKeyMap = new HashMap<>();
            size = 0;
        }

        public void insert(K key) {
            if (!keyIndexMap.containsKey(key)) {
                keyIndexMap.put(key, size);
                indexKeyMap.put(size++, key);
            }
        }

        public void delete(K key) {
            if (keyIndexMap.containsKey(key)) {
                int deleteIndex = keyIndexMap.get(key);
                int lastIndex = --size;
                K lastKey = indexKeyMap.get(lastIndex);
                indexKeyMap.put(deleteIndex, lastKey);
                keyIndexMap.put(lastKey, deleteIndex);
                keyIndexMap.remove(key);
                indexKeyMap.remove(lastIndex);
            }
        }

        public K getRandom() {
            if (size == 0) {
                return null;
            }
            int randomIndex = (int)(Math.random() * size);
            return indexKeyMap.get(randomIndex);
        }
    }
}
