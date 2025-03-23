package MyHashMap;

import java.util.LinkedList;
import java.util.Objects;

public class MyHashMap<K, V> {
    private static final int DEFAULT_CAPACITY = 16;
    private int size;
    private LinkedList<MyNode<K, V>>[] myTable;

    public MyHashMap() {
        myTable = new LinkedList[DEFAULT_CAPACITY];
        size = 0;
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int getLength() {
        return myTable.length;
    }

    public void put(K key, V value) {
        int index = getIndex(key);

        if (myTable[index] == null) {
            myTable[index] = new LinkedList<>();
        }

        for (MyNode<K, V> node : myTable[index]) {
            if (Objects.equals(node.key, key)) {
                node.value = value;
                return;
            }
        }

        myTable[index].add(new MyNode<>(key, value));
        size++;
    }

    public V get(K key) {
        int index = getIndex(key);

        if (myTable[index] != null) {
            for (MyNode<K, V> node : myTable[index]) {
                if (Objects.equals(node.key, key)) {
                    return node.value;
                }
            }
        }
        return null;
    }

    private int getIndex(K key) {
        if (key == null) {
            return 0;
        }
        return key.hashCode() % myTable.length;
    }

    static class MyNode<K, V> {
        K key;
        V value;

        MyNode(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    public static void main(String[] args) {
        MyHashMap<String, Integer> myHashMap = new MyHashMap<String, Integer>();
        myHashMap.put("one", 1);
        myHashMap.put("two", 2);
        myHashMap.put("three", 55);
        System.out.println(myHashMap.size);
        System.out.println(myHashMap.get("two"));
        System.out.println(myHashMap.getIndex("three"));
        System.out.println(myHashMap.get("one"));
    }

}
