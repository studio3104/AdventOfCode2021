package com.studio3104.adventofcode2021.day04;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Problem2 {
    static int getResult(Input input) {
        List<List<Sum>> sums = Problem1.calculateSum(input);
        int lastNum = -1;
        List<Sum> lastSum = new ArrayList<>();

        Set<Integer> hasWonIndexes = new HashSet<>();

        for (int n : input.numbers) {
            for (int i = 0; i < sums.size(); ++i) {
                if (hasWonIndexes.contains(i)) {
                    continue;
                }
                List<Sum> b = sums.get(i);
                for (Sum s : b) {
                    s.vertical.remove(n);
                    s.horizontal.remove(n);
                    if (s.vertical.isEmpty() || s.horizontal.isEmpty()) {
                        lastNum = n;
                        lastSum = b;
                        hasWonIndexes.add(i);
                    }
                }
            }
        }

        if (lastNum == -1 || lastSum.isEmpty()) {
            throw new RuntimeException();
        }
        return Problem1.getResult(lastNum, lastSum);
    }

    public static void main(String[] args) {
        System.out.println(Problem2.getResult(new Input()));
    }
}
