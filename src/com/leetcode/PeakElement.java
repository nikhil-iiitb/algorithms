package com.leetcode;

//
//  Find Peak Element
//
//  Created by Nikhil Garg on 09/02/2021.
//  Copyright © 2021 Personal. All rights reserved.
//

public class PeakElement {

    public int findPeakElement(int[] nums) {

        if(null == nums || (nums.length-1==0))
            return 0;

        int low=0, high=nums.length-1;

        while (low<high){
            int mid = low + (high-low)/2;

            if(nums[mid] < nums[mid+1]) {
                low = mid+1;
            }else {
                high = mid;
            }
        }
        return low;
    }

    public static void main(String[] args) {
        PeakElement pE = new PeakElement();
        int[] inputArray = {1,2,1,3,5,6,4};
        System.out.println(pE.findPeakElement(inputArray));
    }

}
