package com.leetcode;

//
//  Median of Two sorted arrays
//  Leetcode
//
//  Created by Nikhil Garg on 05/02/2021.
//  Copyright © 2021 Personal. All rights reserved.
//

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class IndorderTraversal {
    /**
     * Definition for a binary tree node.**/
      public class TreeNode {
          int val;
          TreeNode left;
          TreeNode right;
          TreeNode() {}
          TreeNode(int val) { this.val = val; }
          TreeNode(int val, TreeNode left, TreeNode right) {
              this.val = val;
              this.left = left;
              this.right = right;
          }
      }

    class Solution {
        public List<Integer> inorderTraversal(TreeNode root) {
            List<Integer> list = new LinkedList<>();

            if(null == root)
                return list;

            Stack<TreeNode> sStack = new Stack<>();

            TreeNode tNode = root;

            while (null!=tNode || sStack.size()>0){
                while (null != tNode){
                    sStack.push(tNode);
                    tNode = tNode.left;
                }
                tNode = sStack.pop();
                list.add(tNode.val);

                tNode = tNode.right;
            }
            return list;
        }
    }
}
