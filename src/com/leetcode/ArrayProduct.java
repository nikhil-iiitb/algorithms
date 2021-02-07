package com.leetcode;

//
//  Product of Array Except Self
//
//  Created by Nikhil Garg on 07/02/2021.
//  Copyright © 2021 Personal. All rights reserved.
//

public class ArrayProduct {

    public int[] productExceptSelf(int[] nums) {
        if(null == nums)
            return null;
        int l = nums.length;
        int[] result = new int[l];

        result[l-1] = 1;
        for(int i=l-2; i>=0; i--){
            result[i] = result[i+1] * nums[i+1];
        }

        int lIdx = 1;
        for(int i=0; i<l; i++){
            result[i] = result[i] * lIdx;
            lIdx = nums[i] * lIdx;
        }
         return result;
    }

    public static void main(String[] args) {
        ArrayProduct aP = new ArrayProduct();
        int[] input = {1, 2, 3, 4};

        int[] ans = aP.productExceptSelf(input);
        for(Integer i : ans){
            System.out.println(i + " ");
        }
    }

}
