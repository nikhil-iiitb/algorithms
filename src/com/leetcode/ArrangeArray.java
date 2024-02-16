package com.leetcode;

import java.util.Arrays;

public class ArrangeArray {
	public int[] rearrangeArray(int[] nums) {
		int pIdx=0, nIdx=0, idx=0;
		int arrLen = nums.length;
		int[] nArray = new int[arrLen];
		while(idx<arrLen){
			pIdx = getIdx(nums, 0, pIdx, arrLen);
			nIdx = getIdx(nums, 1, nIdx, arrLen);

			nArray[idx++] = nums[pIdx];
			nArray[idx++] = nums[nIdx];
			pIdx++;
			nIdx++;
		}
		return nArray;
	}
	public int getIdx(int[] nums, int type, int startIdx, int endIdx){
		int retIdx=0;
		for(int i=startIdx; i<endIdx; i++) {
			if(type == 0){
				if(nums[i]>=0){
					retIdx = i;
					break;
				}
			}
			if(type == 1){
				if(nums[i]<0){
					retIdx = i;
					break;
				}
			}
		}
		return retIdx;
	}

	public static void main(String[] args) {
		ArrangeArray arrangeArray = new ArrangeArray();
		int[] testArray = {3,1,-2,-5,2,-4};
		System.out.println(Arrays.toString(arrangeArray.rearrangeArray(testArray)));
	}


	/*
	public int[] rearrangeArray(int[] nums) {
        int p = 0, n = 1;
        int[] res = new int[nums.length];

        for(int i= 0;i<res.length;i++){
            if(nums[i]>0){
                res[p] = nums[i];
                p += 2;
            }
            else{
                res[n] = nums[i];
                n += 2;
            }
        }
        return res;
    }
	* */
}
