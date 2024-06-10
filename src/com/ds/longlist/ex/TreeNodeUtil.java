package com.ds.longlist.ex;

public class TreeNodeUtil {
	/*
	This is the recursive approach for finding the Tree Height.
	* */
	public int height(TreeNode tN) {
		if(null == tN){
			return 0;
		}
		return 1 + Math.max(height(tN.lNode), height(tN.rNode));
	}

	public int itrHeight(TreeNode tN) {
		if(null == tN){
			return 0;
		}
		return 0;

	}
}
