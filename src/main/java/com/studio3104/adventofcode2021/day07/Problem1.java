package com.studio3104.adventofcode2021.day07;

import com.studio3104.adventofcode2021.utilities.InputLoader;

import java.util.Arrays;

public class Problem1 {
    private static int getResult(int[] input) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int n : input) {
            min = Math.min(min, n);
            max = Math.max(max, n);
        }

        int minFuel = Integer.MAX_VALUE;
        for (int n = min; n <= max; ++n) {
            int fuel = 0;
            for (int m : input) {
                fuel += Math.abs(n - m);
            }
            minFuel = Math.min(minFuel, fuel);
        }

        return minFuel;
    }

    public static void main(String[] args) {
        int[] input = Arrays.stream(InputLoader.loadStringInput(7)[0].split(",")).mapToInt(Integer::parseInt).toArray();
        System.out.println(getResult(input));
    }
}
