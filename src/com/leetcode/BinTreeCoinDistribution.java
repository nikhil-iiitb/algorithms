package com.leetcode;

//
//  Distribute Coins in Binary Tree
//
//  Created by Nikhil Garg on 12/02/2021.
//  Copyright © 2021 Personal. All rights reserved.
//


public class BinTreeCoinDistribution {
    int moves;
    public int distributeCoins(IndorderTraversal.TreeNode root) {
        moves = 0;
        getMoves(root);
        return moves;
    }

    public int getMoves(IndorderTraversal.TreeNode root){
        if(null==root){
            return 0;
        }

        int lCoins = getMoves(root.left);
        moves += Math.abs(lCoins);
        int rCoins = getMoves(root.right);
        moves += Math.abs(rCoins);

        return (root.val + lCoins + rCoins - 1);
    }
}
