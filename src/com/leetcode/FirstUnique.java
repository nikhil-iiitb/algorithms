package com.leetcode;

public class FirstUnique {
	/*
	Given a string s, find the first non-repeating character in it and return its index. If it does not exist, return -1.
	* */
	public int firstUniqChar(String s) {
		int[] cCountArr = new int[26];
		for(int i=0; i<s.length();i++){
			cCountArr[s.charAt(i) - 'a'] +=1;
		}
		for(int i=0; i<s.length();i++){
			if(cCountArr[s.charAt(i) - 'a']==1) {
				return i;
			}
		}
		return -1;
	}

	public static void main(String[] args) {
		FirstUnique fU = new FirstUnique();
		System.out.println(fU.firstUniqChar("leetcode"));
		System.out.println(fU.firstUniqChar("loveleetcode"));
		System.out.println(fU.firstUniqChar("aabb"));
	}
}
