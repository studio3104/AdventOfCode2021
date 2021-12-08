package com.studio3104.adventofcode2021.day08;

import com.studio3104.adventofcode2021.utilities.InputLoader;

import java.util.Arrays;

public class Problem1 {
    private static int getResult(String[] input) {
        int count = 0;
        for (String line : input) {
            count += Arrays.stream(line.split(" \\| ")[1].trim().split(" +"))
                    .filter(o -> o.length() >= 2 && o.length() <= 4 || o.length() == 7)
                    .count();
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(getResult(InputLoader.loadStringInput(8)));
    }
}
