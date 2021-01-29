package com.leetcode;

public class TitleToNum {
    public static int titleToNumber(String s) {
        int l = s.length();
        int retVal = 0;
        for(int i=l-1, j=0; i>=0; i--){
            int v = (int)Math.pow(26, j);
            retVal +=  (int)v*(Character.valueOf(s.charAt(i))-'A'+1);
            j++;
        }
        return retVal;
    }

    public static void main(String[] args) {
        String s = "FXSHRXW";
        System.out.println(titleToNumber(s));
    }
}
