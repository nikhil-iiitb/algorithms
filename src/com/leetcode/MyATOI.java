package com.leetcode;

//
//  String to Integer (atoi)
//  Leetcode
//
//  Created by Nikhil Garg on 02/02/2021.
//  Copyright © 2021 Personal. All rights reserved.
//

public class MyATOI {

    public int myAtoi(String s) {

        if(null == s || s.length()<1)
            return 0;

        s = s.trim();
        boolean nFlag = false;

        int idx=0;

        if(s.charAt(0) == '-'){
            nFlag = true;
            idx++;
        }else if (s.charAt(0) == '+'){
            idx++;
        }

        long result=0L;

        while (idx<s.length() && s.charAt(idx)>='0' && s.charAt(idx)<='9'){
            result = result*10 + (s.charAt(idx) - '0');
            idx++;
        }

        if(nFlag)
            result = (-1)*result;

        if(result>Integer.MAX_VALUE)
            return Integer.MAX_VALUE;

        if(result<Integer.MIN_VALUE)
            return Integer.MIN_VALUE;

        return (int)result;
    }

    public static void main(String[] args) {
        String s = "          09009work is ";
        MyATOI myATOI = new MyATOI();
        System.out.println(myATOI.myAtoi(s));
    }

}
