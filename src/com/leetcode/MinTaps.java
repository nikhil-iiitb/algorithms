package com.leetcode;


//
//  Minimum-number-of-taps-to-open-to-water-a-garden
//  LeetCode
//  https://leetcode.com/problems/minimum-number-of-taps-to-open-to-water-a-garden/
//  Created by Nikhil Garg on 14/04/2021.
//  Copyright © 2021 Personal. All rights reserved.
//

import java.util.Arrays;

public class MinTaps {

    class Range{
        int left; int right;
        public Range(int left, int right) {
            this.left = left; this.right = right;
        }
    }

   public int minTaps(int n, int[] ranges) {
        int[] rangeArray = new int[n+1];
        Arrays.fill(rangeArray, 0);
       for(int i=0; i<=n; i++){
            int u = Math.max(i-ranges[i], 0);
            int v = Math.min(i+ranges[i], n);
            rangeArray[u] = Math.max(rangeArray[u], v);
        }
        return getCount(n, rangeArray);
    }

    private int getCount(int l, int[] rArray) {
        int count=0, back_up=-1;
        int curr=0;

        for(int i=0; i<=l; i++) {
            if (i > curr) return -1;

            back_up = Math.max(back_up, rArray[i]);
            if (curr == i && i != l) {
                count++;
                curr = back_up;
                back_up = -1;
            }
        }
        if(curr<l) return -1;
        return count;
            /*while (i<=curr){
                next = Math.max(next, rArray[i]);
                i++;
            }
            if(curr==next)
                return -1;
            curr = next;
            count++;
        }
        return count;*/
    }

    /*public int minTaps(int n, int[] ranges) {
        int min =0;
        int max =0;
        int open =0;
        int pos =0;
        while(max<n){
            for(int i=0; i<ranges.length; i++){
                if(ranges[i] !=0 && (i - ranges[i])<=min && (i+ranges[i])>max){
                    max = i+ranges[i];
                    pos = i;
                }
            }
            if(min==max) return -1;
            open++;
            min = max;
            ranges[pos]=0;
        }
        return open;
    }*/

    public static void main(String[] args) {
        int[] a = {3,4,1,1,0,0};
        MinTaps minTaps = new MinTaps();
        System.out.println(minTaps.minTaps(5, a));
    }


}
