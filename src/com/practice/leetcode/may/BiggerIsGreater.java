package com.practice.leetcode.may;

import java.util.Scanner;

public class BiggerIsGreater {

    static String biggerIsGreater(String w) {
        char[] cA = w.toCharArray();
        int l = cA.length;

        boolean flag = false;
        for(int i=l-1, j=i; i>=1; i++){

            while (j>=1 && cA[j-1] > cA[i]){
                j--;
            }
            if(j-1<0){
                j = i;
                continue;
            }else{
                char ch = cA[i];
                cA[i] = cA[j];
                cA[j] = ch;
            }

        }


        return null;
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        String[] sA = new String[n];
        for(int i=0; i<n; i++){
            sA[i] = s.next();
            biggerIsGreater(sA[i]);
        }


    }

}
