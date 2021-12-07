package com.studio3104.adventofcode2021.day05;

import com.studio3104.adventofcode2021.utilities.InputLoader;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

class Position {
    final int x;
    final int y;

    Position(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

class Vents {
    final Position a;
    final Position b;

    Vents(Position a, Position b) {
        this.a = a;
        this.b = b;
    }
}

public class Problem1 {
    private static int[][] createDiagram(String[] input) {
        int maxX = Integer.MIN_VALUE;
        int maxY = Integer.MIN_VALUE;

        List<Vents> ventsList = new ArrayList<>();
        for (String line : input) {
            List<Position> positions = Arrays.stream(line.split(" -> "))
                    .map(s -> {
                                String[] p = s.split(",");
                                return new Position(Integer.parseInt(p[0]), Integer.parseInt(p[1]));
                            }
                    ).collect(Collectors.toList());

            Vents vents = new Vents(positions.get(0), positions.get(1));
            maxX = Math.max(maxX, Math.max(vents.a.x, vents.b.x));
            maxY = Math.max(maxY, Math.max(vents.a.y, vents.b.y));
            if (vents.a.x == vents.b.x || vents.a.y == vents.b.y) {
                ventsList.add(vents);
            }
        }

        int[][] diagram = new int[maxX + 1][maxY + 1];
        for (Vents v : ventsList) {
            for (int x = Math.min(v.a.x, v.b.x); x <= Math.max(v.a.x, v.b.x); ++x) {
                for (int y = Math.min(v.a.y, v.b.y); y <= Math.max(v.a.y, v.b.y); ++y) {
                    ++diagram[x][y];
                }
            }
        }

        return diagram;
    }

    private static int getResult(String[] input) {
        int[][] diagram = createDiagram(input);
        int numOverlap = 0;
        for (int[] line : diagram) {
            for (int cell : line) {
                if (cell >= 2) {
                    ++numOverlap;
                }
            }
        }

        return numOverlap;
    }

    public static void main(String[] args) {
        System.out.println(Problem1.getResult(InputLoader.loadStringInput(5)));
    }
}
