package com.studio3104.adventofcode2021.day02;

import com.studio3104.adventofcode2021.utilities.InputLoader;

public class Problem2 {
    public static void main(String[] args) {
        Position result = Problem1.getResult(InputLoader.loadStringInput(2));
        System.out.println(result.position * result.depth);
    }
}
