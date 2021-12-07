package com.studio3104.adventofcode2021.day06;

import com.studio3104.adventofcode2021.utilities.InputLoader;

import java.util.Arrays;

public class Problem2 {
    public static void main(String[] args) {
        String[] input = InputLoader.loadStringInput(6);
        int[] init = Arrays.stream(input[0].split(",")).mapToInt(Integer::parseInt).toArray();
        System.out.println(Problem1.getResult(init, 256));
    }
}
