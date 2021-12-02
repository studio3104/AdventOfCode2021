package com.studio3104.adventofcode2021.day02;

import com.studio3104.adventofcode2021.utilities.InputLoader;

public class Problem2 {
    private static long getResult(String[] input) {
        long aim = 0;
        long position = 0;
        long depth = 0;

        for (String s: input) {
            String[] command = s.split(" ");
            long units = Long.parseLong(command[1]);

            switch (command[0]) {
                case "forward":
                    position += units;
                    depth += aim * units;
                    break;
                case "down":
                    aim += units;
                    break;
                case "up":
                    aim -= units;
                    break;
                default:
                    throw new RuntimeException();
            }
        }

        return position * depth;
    }

    public static void main(String[] args) {
        System.out.println(Problem2.getResult(InputLoader.loadStringInput(2)));
    }
}
