package com.leetcode;

public class RemoveDuplicatesSecond {
    public int removeDuplicates(int[] nums) {
        int result = nums.length;
        int i = 0;
        while (i < result - 2) {
            if (nums[i] == nums[i + 1] && nums[i] == nums[i + 2]) {
                shiftLeft(nums, i, nums.length);
                result--;
            } else {
                i++;
            }
        }
        return result;
    }

    private void shiftLeft(int[] arr, int i, int n) {
        for (int j = i; j < n - 1; j++) {
            arr[j] = arr[j + 1];
        }
    }

    public static void main(String[] args) {
        RemoveDuplicatesSecond removeDuplicatesSecond = new RemoveDuplicatesSecond();
        int[] nums = {0, 0, 0, 1, 1, 1, 1, 1, 2, 3, 3, 3};
        System.out.println(removeDuplicatesSecond.removeDuplicates(nums));
    }
}
