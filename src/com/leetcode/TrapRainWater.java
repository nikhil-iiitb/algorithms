package com.leetcode;

//
//  Trapping Rain Water
//  LeetCode
//  https://leetcode.com/problems/trapping-rain-water/
//  Created by Nikhil Garg on 14/04/2021.
//  Copyright © 2021 Personal. All rights reserved.
//
public class TrapRainWater {
    public int trap(int[] height) {

        if(height.length == 0)
            return 0;

        int left=0, right=height.length-1;
        int maxLeft=height[left], maxRight=height[right];
        int result=0;

        while(left<right){

            if(maxLeft < maxRight){
                left++;
                maxLeft = Math.max(maxLeft, height[left]);
                result += maxLeft - height[left];
            }else{
                right--;
                maxRight = Math.max(maxRight, height[right]);
                result += maxRight - height[right];
            }
        }
        return result;
    }
}
