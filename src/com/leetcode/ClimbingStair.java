package com.leetcode;

public class ClimbingStair {

    public int climbStairs(int n) {
        if(n<=2)
            return n;

        int[] stCnt = new int[n+1];
        stCnt[1] = 1;
        stCnt[2] = 2;
        for(int i=3;i<=n;i++){
            stCnt[i] = stCnt[i-1]+stCnt[i-2];
        }
        return stCnt[n];
    }

    public static void main(String[] args) {
        ClimbingStair cs = new ClimbingStair();
        System.out.println(cs.climbStairs(10));
    }
}
