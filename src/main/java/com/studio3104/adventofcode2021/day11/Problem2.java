package com.studio3104.adventofcode2021.day11;

import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Queue;
import java.util.Set;

public class Problem2 {
    private static int getResult(int[][] octopuses) {
        int step = 0;
        int numOctopuses = octopuses.length * octopuses[0].length;

        Set<Position> flashed = new HashSet<>();
        Queue<Position> toIncrease = new ArrayDeque<>();

        while (flashed.size() != numOctopuses) {
            ++step;
            flashed.clear();

            for (int i = 0; i < octopuses.length; ++i) {
                for (int j = 0; j < octopuses[0].length; ++j) {
                    Problem1.increaseEnergy(octopuses, new Position(i, j), flashed, toIncrease);
                }
            }

            while (!toIncrease.isEmpty()) {
                Problem1.increaseEnergy(octopuses, toIncrease.poll(), flashed, toIncrease);
            }
        }

        return step;
    }

    public static void main(String[] args) {
        System.out.println(getResult(Problem1.fetchOctopuses()));
    }
}
