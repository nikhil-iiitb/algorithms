package com.practice.leetcode.may;

public class NumberComplement {
	public int findComplement(int n) {
		int result = 0;
		int i = 0;
		int l = bitLength(n);
		while(l>0) {
			int v = 1<<i;
			if(((v & n) == 0)) {
				result = result | v;
			}
			i++;
			l--;
		}
		return result;
	}
	
	public int bitLength(int n) {
		int c = 0;		
		while(n != 0) {
			n = (n>>1);
			c++;
		}
		return c;
	}
	
	public static void main(String[] args) {
		NumberComplement nC = new NumberComplement();
		System.out.println(nC.findComplement(16));
	}
}
