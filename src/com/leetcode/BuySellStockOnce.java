package com.leetcode;

//
//  Best Time to Buy and Sell Stock
//
//  Created by Nikhil Garg on 09/02/2021.
//  Copyright © 2021 Personal. All rights reserved.
//

public class BuySellStockOnce {

    public int maxProfit(int[] prices) {
        int maxProfit=0, l=prices.length;
        int minStock = prices[0];
        if(l<2)
            return 0;
        for(int i=0; i<l; i++){
            maxProfit = Math.max(maxProfit, prices[i]-minStock);
            minStock = Math.min(minStock, prices[i]);
        }
        return maxProfit;
    }

    public static void main(String[] args) {
        int[] sPrices = {7, 1, 5, 3 ,6, 4};
        //int[] sPrices = {7,6,4,3,1};
        BuySellStockOnce once = new BuySellStockOnce();
        System.out.println(once.maxProfit(sPrices));
    }

}
