package com.github.vramanchyk.bs;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * Created by Vitali Ramanchyk on 11/18/20.
 */
public class BS793_HistoricalMap {

    private final Map<Integer, TreeMap<Integer, Integer>> map = new HashMap<>();

    public BS793_HistoricalMap() {

    }

    public int get(int key, int timestamp) {
        TreeMap<Integer, Integer> sub = map.get(key);
        if (sub == null) {
            return -1;
        }
        Map.Entry<Integer, Integer> en = sub.floorEntry(timestamp);
        return en == null ? -1 : en.getValue();
    }

    public void set(int key, int val, int timestamp) {
        map.computeIfAbsent(key, v -> new TreeMap<>()).put(timestamp, val);
    }
}
