package com.leetcode;

public class SortedSquares {

    public int[] sortedSquares(int[] nums) {
        int[] nArray = new int[nums.length];
        int l=0; int r=nums.length-1; int idx=nums.length-1;

        while (l<=r){
            int lS = nums[l]*nums[l];
            int rS = nums[r]*nums[r];

            if(lS>rS){
                nArray[idx--] = lS;
                l++;
            }else {
                nArray[idx--] = rS;
                r--;
            }
        }
        return nArray;
    }

    public static void main(String[] args) {
        int[] input = {-9, -7, -5, 0, 1, 8, 10};
        SortedSquares sS = new SortedSquares();

        input = sS.sortedSquares(input);
        for(Integer i : input){
            System.out.print(" " + i);
        }

    }

}
