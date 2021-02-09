package com.leetcode;

//
//  Best Time to Buy and Sell Stock 2
//
//  Created by Nikhil Garg on 09/02/2021.
//  Copyright © 2021 Personal. All rights reserved.
//

public class BuySellStock2 {
    public int maxProfit(int[] prices) {
        int l = prices.length;
        int maxProfit = 0;

        for(int i=1; i<l; i++){
            if(prices[i]>prices[i-1]){
                maxProfit += (prices[i]-prices[i-1]);
            }
        }
        return maxProfit;
    }

    public static void main(String[] args) {
        int[] sPrices = {7, 1, 5, 3 ,6, 4};
        //int[] sPrices = {7,6,4,3,1};
        BuySellStock2 once = new BuySellStock2();
        System.out.println(once.maxProfit(sPrices));
    }
}
