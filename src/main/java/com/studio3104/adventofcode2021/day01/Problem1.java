package com.studio3104.adventofcode2021.day01;

import com.studio3104.adventofcode2021.utilities.InputLoader;

public class Problem1 {
    private static int getResult(int[] nums) {
        int countIncreased = 0;
        for (int i = 1; i < nums.length; ++i) {
            if (nums[i] > nums[i - 1]) {
                ++countIncreased;
            }
        }

        return countIncreased;
    }

    public static void main(String[] args) {
        System.out.println(Problem1.getResult(InputLoader.loadIntegerInput(1)));
    }
}
