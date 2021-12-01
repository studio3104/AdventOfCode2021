package com.studio3104.adventofcode2021.day01;

import com.studio3104.adventofcode2021.utilities.InputLoader;

public class Problem2 {
    private static final int WINDOW_SIZE = 3;

    private static int getResult(int[] nums) {
        int countIncreased = 0;
        for (int i = WINDOW_SIZE; i < nums.length; ++i) {
            if (nums[i] > nums[i - WINDOW_SIZE]) {
                ++countIncreased;
            }
        }

        return countIncreased;
    }

    public static void main(String[] args) {
        System.out.println(Problem2.getResult(InputLoader.loadIntegerInput(1)));
    }
}
