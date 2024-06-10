package com.ds.longlist.ex;

import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;

public class LFUCache {

	private int capacity;
	private int minFreq;
	private Map<Integer, Integer> keyToValMap;
	private Map<Integer, Integer> keyToFreqMap;
	private Map<Integer, LinkedHashSet<Integer>> freqToKeyMap;


	public LFUCache(int capacity) {
		this.capacity = capacity;
		keyToValMap = new HashMap<>();
		keyToFreqMap = new HashMap<>();
		freqToKeyMap = new HashMap<>();

		freqToKeyMap.put(1, new LinkedHashSet<>());
		minFreq = 0;
	}

	public static void main(String[] args) {
		LFUCache cache = new LFUCache(2);

		cache.put(1, 1);
		cache.put(2, 2);
		System.out.println(cache.get(1));
	}

	public void put(int key, int value) {
		if(capacity <= 0)
			return;

		if(keyToValMap.containsKey(key)) {
			keyToValMap.put(key, value);
			get(key);
			return;
		}

		if(keyToValMap.size() >= capacity) {
			int evict = freqToKeyMap.get(minFreq).iterator().next();
			freqToKeyMap.get(minFreq).remove(evict);
			keyToValMap.remove(evict);
			keyToFreqMap.remove(evict);
		}

		keyToValMap.put(key, value);
		keyToFreqMap.put(key, 1);
		freqToKeyMap.putIfAbsent(1, new LinkedHashSet<>());
		freqToKeyMap.get(1).add(key);
		minFreq = 1;
	}

	public int get(int key) {
		if(!keyToValMap.containsKey(key)) {
			return -1;
		}

		int freq = keyToFreqMap.get(key);
		freqToKeyMap.get(freq).remove(key);

		if(freq == minFreq && freqToKeyMap.get(freq).isEmpty()) {
			minFreq++;
		}

		keyToFreqMap.put(key, freq+1);
		freqToKeyMap.putIfAbsent(freq+1, new LinkedHashSet<>());
		freqToKeyMap.get(freq+1).add(key);

		return keyToValMap.get(key);
	}
}
