package org.example;

public class MyHashTable<K, V> {
    private HashNode<K, V>[] chainArray;
    private int size;
    private int M = 11;

    public static class HashNode<K, V> {
        K key;
        V value;
        HashNode<K, V> next;

        public HashNode(K key, V value, HashNode<K, V> next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }

        @Override
        public String toString() {
            return "{" + key + " " + value + "}";
        }
    }

    public MyHashTable() {
        this.chainArray = new HashNode[M];
        this.size = 0;
    }

    public MyHashTable(int M) {
        this.chainArray = new HashNode[M];
        this.M = M;
    }

    private int hash(K key) {
        return (key.hashCode()) % M;
    }

    public void put(K key, V value) {
        int index = hash(key);
        HashNode<K, V> node = chainArray[index];
        while (node != null) {
            if (node.key.equals(key)) {
                node.value = value; // Обновляем значение, если ключ уже существует
                return;
            }
            node = node.next;
        }
        // Если ключ не найден, добавляем новый элемент в начало цепочки
        chainArray[index] = new HashNode<>(key, value, chainArray[index]);
        size++;
    }


    public V get(K key) {
        int index = hash(key);
        HashNode<K, V> node = chainArray[index];
        while (node != null) {
            if (node.key.equals(key)) {
                return node.value;
            }
            node = node.next;
        }
        return null;
    }

    public V remove(K key) {
        int index = hash(key);
        HashNode<K, V> node = chainArray[index];
        HashNode<K, V> previous = null;
        while (node != null) {
            if (node.key.equals(key)) {
                if (previous == null) {
                    chainArray[index] = node.next;
                } else {
                    previous.next = node.next;
                }
                size--;
                return node.value;
            }
            previous = node;
            node = node.next;
        }
        return null;
    }

    public boolean containsValue(V value) {
        for (HashNode<K, V> node : chainArray) {
            while (node != null) {
                if (node.value.equals(value)) {
                    return true;
                }
                node = node.next;
            }
        }
        return false;
    }

    public K getKey(V value) {
        for (HashNode<K, V> node : chainArray) {
            while (node != null) {
                if (node.value.equals(value)) {
                    return node.key;
                }
                node = node.next;
            }
        }
        return null;
    }

    public HashNode<K, V>[] getChainArray() {
        return chainArray;
    }
}
