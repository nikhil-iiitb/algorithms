package com.leetcode;

import java.util.LinkedList;
import java.util.Queue;

//
//  Even Odd Tree
//
//  Created by Nikhil Garg on 12/02/2021.
//  Copyright © 2021 Personal. All rights reserved.
//

public class EvenOddTree {
    public boolean isEvenOddTree(IndorderTraversal.TreeNode root) {
        if(null == root)
            return false;

        boolean isEven = true; // root node @ level 0 - Even
        Queue<IndorderTraversal.TreeNode> tList = new LinkedList<>();
        tList.add(root);

        while(!tList.isEmpty()){
            Queue<IndorderTraversal.TreeNode> levelList = new LinkedList<>();
            int prev = isEven?0:1000001;
            while(!tList.isEmpty()){
                IndorderTraversal.TreeNode node = tList.remove();
                if(null != node.left){
                    levelList.add(node.left);
                }
                if(null != node.right){
                    levelList.add(node.right);
                }

                if(isEven){
                    if(node.val%2 == 0)
                        return false;

                    if(prev<node.val){
                        prev = node.val;
                    }else{
                        return false;
                    }
                }
                else{
                    if(node.val%2 != 0)
                        return false;

                    if(prev>node.val){
                        prev = node.val;
                    }else{
                        return false;
                    }
                }
            }
            tList = levelList;
            isEven = !isEven;
        }
        return true;
    }
}
