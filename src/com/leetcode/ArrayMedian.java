package com.leetcode;
//
//  Median of Two sorted arrays
//  Leetcode
//
//  Created by Nikhil Garg on 30/01/2021.
//  Copyright © 2021 Personal. All rights reserved.
//


public class ArrayMedian {

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int l1 = nums1.length; int l2 = nums2.length;

        if(l1>l2){
            return findMedianSortedArrays(nums2, nums1);
        }

        int x = nums1.length; int y = nums2.length;
        int lo = 0; int hi = x;

        while (lo<=hi){
            int pX = (lo+hi)/2;
            int pY = (x+y+1)/2 - pX;

            int maxLeftX = (pX==0)?Integer.MIN_VALUE:nums1[pX-1];
            int minRightX = (pX==x)?Integer.MAX_VALUE:nums1[pX];

            int maxLeftY = (pY==0)?Integer.MIN_VALUE:nums2[pY-1];
            int minRightY = (pY==y)?Integer.MAX_VALUE:nums2[pY];

            if(maxLeftX<=minRightY && maxLeftY<=minRightX){
                if(x+y%2 == 0){
                    return ((double)Math.max(maxLeftX, maxLeftY)+Math.min(minRightX, minRightY))/2;
                }else {
                    return (Math.max(maxLeftX, maxLeftY));
                }
            }else if(maxLeftX>=minRightY){
                hi = pX-1;
            }else{
                lo = pX+1;
            }

        }
        return 0.0;
    }

    public static void main(String[] args) {
        int[] a1 = {1, 3, 8, 9, 15};
        int[] a2 = {7, 11, 18, 19, 21, 25};

        System.out.println(findMedianSortedArrays(a1, a2));
    }

}
