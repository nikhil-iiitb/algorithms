package com.leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

//
//  Time based Key-Value Store
//
//  Created by Nikhil Garg on 28/02/2023.
//  Copyright © 2021 Personal. All rights reserved.
//

public class TimeMap {

    public Map<String, TreeMap<Integer, String>> tsStore;

    public TimeMap() {
        tsStore = new HashMap<>();
    }

    public void set(String key, String value, int timestamp){
        if(!tsStore.containsKey(key)) {
            tsStore.put(key, new TreeMap<>());
        }
        tsStore.get(key).put(timestamp, value);
    }

    public String get(String key, int timestamp) {
        TreeMap<Integer, String> tS = tsStore.get(key);

        if(null == tS) {
            return "";
        }

        Integer v = tS.floorKey(timestamp);
        if(null == v) {
            return "";
        }
        return tS.get(v);
    }

}
