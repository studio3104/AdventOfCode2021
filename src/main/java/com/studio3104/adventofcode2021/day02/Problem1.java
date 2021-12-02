package com.studio3104.adventofcode2021.day02;

import com.studio3104.adventofcode2021.utilities.InputLoader;

public class Problem1 {
    private static long getResult(String[] input) {
        long position = 0;
        long depth = 0;

        for (String s: input) {
            String[] command = s.split(" ");
            long units = Long.parseLong(command[1]);

            switch (command[0]) {
                case "forward":
                    position += units;
                    break;
                case "down":
                    depth += units;
                    break;
                case "up":
                    depth -= units;
                    break;
                default:
                    throw new RuntimeException();
            }
        }

        return position * depth;
    }

    public static void main(String[] args) {
        System.out.println(Problem1.getResult(InputLoader.loadStringInput(2)));
    }
}
