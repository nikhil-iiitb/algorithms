package com.practice.leetcode.may;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class RansomNote {

	// The method name can be changed as per the API in the question.
	boolean canConstruct(String ransomNote, String magazine) {
		int nR = ransomNote.length();
		int nM = magazine.length();

		Map<Character, Integer> mMap = new HashMap<Character, Integer>();
		for(int i = 0; i < nM; i++) {
			if(mMap.containsKey(magazine.charAt(i))){
				mMap.put(magazine.charAt(i), mMap.get(magazine.charAt(i))+1);
			}else {
				mMap.put(magazine.charAt(i), 1);
			}
		}
		
		boolean returnFlag = true;
		for(int i = 0; i < nR; i++) {
			char c = ransomNote.charAt(i);
			if(mMap.get(c) == null) {
				returnFlag = false;
				break;
			}else {
				if(mMap.get(c)-1 < 0) {
					returnFlag = false;
					break;
				}
				mMap.put(c, mMap.get(c)-1);
			}
		}
		return returnFlag;
	}

	public static void main(String[] args) {
		RansomNote rNote = new RansomNote();
		System.out.println(rNote.canConstruct("aac", "aab"));
	}
}
