package com.practice.leetcode.may;

import java.util.Arrays;

/**
 * You're given strings J representing the types of stones that are jewels, and
 * S representing the stones you have. Each character in S is a type of stone
 * you have. You want to know how many of the stones you have are also jewels.
 * 
 * The letters in J are guaranteed distinct, and all characters in J and S are
 * letters. Letters are case sensitive, so "a" is considered a different type of
 * stone from "A".
 * 
 * Input: J = "aA", S = "aAAbbbb" Output: 3
 * 
 * Input: J = "z", S = "ZZ" Output: 0
 * 
 * @author nikhil-iiitb
 *
 */

public class JewelAndStones {

	// The method name can be changed as per the API in the question.
	public int numJewelsInStone(String J, String S) {
		int nJ = J.length();
		int nS = S.length();
		
		int[] lCase = new int[26];
		int[] uCase = new int[26];
		
		Arrays.fill(uCase, 0);
		Arrays.fill(lCase, 0);
		
		for (int i = 0; i < nJ; i++) {
			char c = J.charAt(i);
			if(c>='A' && c<='Z') {
				int idx = c - 'A';
				uCase[idx]++;
			}else {
				int idx = c - 'a';
				lCase[idx]++;
			}
		}
		
		int count = 0;
		for(int i = 0; i<nS; i++) {
			char c = S.charAt(i);
			if(c>='A' && c<='Z') {
				int idx = c - 'A';
				count += uCase[idx];
			}else {
				int idx = c - 'a';
				count += lCase[idx];
			}
		}
		return count;
	}
	
	/*
	 * This is the bit manipulation approach. 
	 * It doesn't need auxiliary memory.  
	 * We set the bits 
	 * 
	 */
	public int numJewelsInStones(String J, String S) {
		int lBitSet = 0;
		int uBitSet = 0;
		int nJ = J.length();
		int nS = S.length();
		for (int i = 0; i < nJ; i++) {
			char c = J.charAt(i);
			int idxBitSet = 0;
			if(c >= 'A' && c <= 'Z') {
				idxBitSet = (1 << c-'A');
				uBitSet = uBitSet | idxBitSet;
			}else {
				idxBitSet = (1 << c-'a');
				lBitSet = lBitSet | idxBitSet;
			}
		}
		int count = 0;
		for (int i = 0; i < nS; i++) {
			char c = S.charAt(i);
			int idxBitSet = 0;
			if(c >= 'A' && c <= 'Z') {
				idxBitSet = (1 << c-'A');
				if ((idxBitSet & uBitSet) == idxBitSet) {
					count++;
				}
			}else {
				idxBitSet = (1 << c-'a');
				if ((idxBitSet & lBitSet) == idxBitSet) {
					count++;
				}
			}
		}
		return count;
	}
	
	public static void main(String[] args) {
		JewelAndStones jS = new JewelAndStones();
		
		System.out.println(jS.numJewelsInStones("aAE", "aAAa"));
	}
	
}
