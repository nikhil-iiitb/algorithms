package com.leetcode;

//
//  Two Sum
//  Leetcode
//
//  Created by Nikhil Garg on 24/01/2021.
//  Copyright © 2021 Personal. All rights reserved.
//

import java.util.HashMap;
import java.util.Map;


public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        int[] ans = new int[2];

        Map<Integer, Integer> numMap = new HashMap<>();
        for(int i=0; i<nums.length; i++){
            if(null == numMap.get(target - nums[i])) {
                numMap.put(nums[i], i);
                continue;
            }
            else{
                int idx1 = i;
                int idx2 = numMap.get(target - nums[i]);
                if(idx1>idx2) {
                    ans[0] = idx2;
                    ans[1] = idx1;
                }else{
                    ans[0] = idx1;
                    ans[1] = idx2;
                }
                break;
            }
        }
        return ans;
    }

}
