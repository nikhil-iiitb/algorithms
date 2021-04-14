package com.leetcode;

//
//  SetMatricesZero
//  Leetcode
//  https://leetcode.com/problems/set-matrix-zeroes/
//  Created by Nikhil Garg on 14/04/2021.
//  Copyright © 2021 Personal. All rights reserved.
//

public class ZeroMatrix {

    public void setZeroes(int[][] matrix) {
        boolean rowFlag=false, columnFlag=false;
        int M = matrix.length, N = matrix[0].length;

        for(int i=0; i<N; i++){
            if(matrix[0][i]==0) {
                rowFlag = true;
                break;
            }
        }

        for(int i=0; i<M; i++){
            if(matrix[i][0]==0) {
                columnFlag = true;
                break;
            }
        }

        for(int i=1; i<M; i++){
            for(int j=1; j<N; j++){
                if(matrix[i][j] == 0){
                    matrix[i][0] = matrix[0][j] = 0;
                }
            }
        }

        for(int i=1; i<M; i++) {
            for (int j = 1; j < N; j++) {
                if(matrix[i][0]==0 || matrix[0][j]==0){
                    matrix[i][j] = 0;
                }
            }
        }

        if(rowFlag){
            for(int i=0; i<N; i++)
                matrix[0][i]=0;
        }

        if(columnFlag){
            for(int i=0; i<M; i++)
                matrix[i][0]=0;
        }
    }


}
