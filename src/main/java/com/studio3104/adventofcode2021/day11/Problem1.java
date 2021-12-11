package com.studio3104.adventofcode2021.day11;

import com.studio3104.adventofcode2021.utilities.InputLoader;

import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Queue;
import java.util.Set;

@lombok.EqualsAndHashCode
@lombok.AllArgsConstructor
class Position {
    int i;
    int j;
}

public class Problem1 {
    static void increaseEnergy(int[][] octopuses, Position position, Set<Position> flashed, Queue<Position> toIncrease) {
        if (flashed.contains(position)) {
            return;
        }

        if (++octopuses[position.i][position.j] < 10) {
            return;
        }

        octopuses[position.i][position.j] = 0;
        flashed.add(position);

        for (int i = position.i - 1; i <= position.i + 1; ++i) {
            for (int j = position.j - 1; j <= position.j + 1; ++j) {
                if (i == position.i && j == position.j) {
                    continue;
                }
                if (i < 0 || i >= octopuses.length) {
                    continue;
                }
                if (j < 0 || j >= octopuses[0].length) {
                    continue;
                }
                toIncrease.add(new Position(i, j));
            }
        }
    }

    private static int getResult(int[][] octopuses) {
        int flashedCount = 0;

        Set<Position> flashed = new HashSet<>();
        Queue<Position> toIncrease = new ArrayDeque<>();

        for (int c = 0; c < 100; ++c) {
            for (int i = 0; i < octopuses.length; ++i) {
                for (int j = 0; j < octopuses[0].length; ++j) {
                    increaseEnergy(octopuses, new Position(i, j), flashed, toIncrease);
                }
            }

            while (!toIncrease.isEmpty()) {
                increaseEnergy(octopuses, toIncrease.poll(), flashed, toIncrease);
            }

            flashedCount += flashed.size();
            flashed.clear();
        }

        return flashedCount;
    }

    static int[][] fetchOctopuses() {
        char[][] input = InputLoader.loadCharGrid(11);
        int[][] octopuses = new int[input.length][input[0].length];
        for (int i = 0; i < input.length; ++i) {
            for (int j = 0; j < input[0].length; ++j) {
                octopuses[i][j] = input[i][j] - '0';
            }
        }
        return octopuses;
    }

    public static void main(String[] args) {
        System.out.println(getResult(fetchOctopuses()));
    }
}
