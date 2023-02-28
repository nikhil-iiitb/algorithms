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

/*
Best Soln
class TimeValue{
    String val;
    int timestamp;

    public TimeValue(String val, int time){
        this.val = val;
        this.timestamp = time;
    }
}


class TimeMap {
    Map<String, List<TimeValue>> map;
    public TimeMap() {
        map = new HashMap<>();
    }

    public void set(String key, String value, int timestamp) {
        map.computeIfAbsent(key, k -> new ArrayList<>()).add(new TimeValue(value, timestamp));
    }

    public String get(String key, int timestamp) {
        List<TimeValue> list = map.getOrDefault(key, null);
        if(list == null){
            return "";
        }
        int start = 0, end = list.size() - 1;

        if(list.get(start).timestamp > timestamp) return  "";
        if(list.get(end).timestamp <= timestamp) return list.get(end).val;

        while(start <= end){
            int mid = (start + end ) /2;
            if(list.get(mid).timestamp == timestamp) return list.get(mid).val;
            if(list.get(mid).timestamp < timestamp) start = mid + 1;
            else end = mid - 1;
        }
        return list.get(start - 1).val;
    }
}


 */
