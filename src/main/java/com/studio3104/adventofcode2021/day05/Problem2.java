package com.studio3104.adventofcode2021.day05;

import com.studio3104.adventofcode2021.utilities.InputLoader;

public class Problem2 {
    public static void main(String[] args) {
        String[] input = InputLoader.loadStringInput(5);
        int[][] diagram = Problem1.createDiagram(
                input,
                v -> v.a.x == v.b.x || v.a.y == v.b.y || Math.abs(v.a.x - v.b.x) == Math.abs(v.a.y - v.b.y)
        );
        System.out.println(Problem1.getResult(diagram));
    }
}
