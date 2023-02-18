package ru.study.geekbrains;

import java.util.HashMap;
import java.util.HashSet;

public class Main {
    public static void main(String[] args) {

        MyHashSet mhs = new MyHashSet();
        mhs.add(5);
        mhs.add(15);
        mhs.add(98);

        System.out.println(mhs);

    }
}

class MyHashSet {
    private HashMap<Integer, Object> map = new HashMap<>();
    private final Object object = new Object();

    @Override
    public String toString() {
        return map.keySet().toString();
    }
    public boolean add(Integer value) {
        return map.put(value, object) != null ? true : false;
    }
    public Integer size() {
        return map.keySet().size();
    }
    public Integer get(Integer index) {
        return (Integer) map.keySet().toArray()[index];
    }
}