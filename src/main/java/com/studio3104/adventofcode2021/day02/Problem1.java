package com.studio3104.adventofcode2021.day02;

import com.studio3104.adventofcode2021.utilities.InputLoader;

class Position {
    long position = 0;
    long depth = 0;
    long aim = 0;
}

public class Problem1 {
    static Position getResult(String[] input) {
        Position p = new Position();

        for (String s: input) {
            String[] command = s.split(" ");
            long units = Long.parseLong(command[1]);

            switch (command[0]) {
                case "forward":
                    p.position += units;
                    p.depth += p.aim * units;
                    break;
                case "down":
                    p.aim += units;
                    break;
                case "up":
                    p.aim -= units;
                    break;
                default:
                    throw new RuntimeException();
            }
        }

        return p;
    }

    public static void main(String[] args) {
        Position result = Problem1.getResult(InputLoader.loadStringInput(2));
        System.out.println(result.position * result.aim);
    }
}
