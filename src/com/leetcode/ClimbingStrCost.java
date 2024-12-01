package com.leetcode;

public class ClimbingStrCost {

    public int minCostClimbingStairs(int[] cost) {
        int prevStep = 0, nextStep = 0;
        for (int i = 2; i <= cost.length; i++) {
            int currentStep = Math.min(cost[i-1]+nextStep, cost[i-2]+prevStep);
            prevStep = nextStep;
            nextStep = currentStep;
        }
        return nextStep;
    }

    public static void main(String[] args) {
        int[] cost = {10, 15, 20};
        //int[] cost = {1, 100, 1, 1, 1, 100, 1, 1, 100, 1};
        ClimbingStrCost c = new ClimbingStrCost();
        System.out.println(c.minCostClimbingStairs(cost));
    }
}
