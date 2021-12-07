package com.studio3104.adventofcode2021.day04;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

class Sum {
    Set<Integer> vertical = new HashSet<>();
    Set<Integer> horizontal = new HashSet<>();
}

public class Problem1 {
    static List<List<Sum>> calculateSum(Input input) {
        List<List<Sum>> sums = new ArrayList<>();
        for (int[][] board : input.boards) {
            List<Sum> s = IntStream.range(0, 5).mapToObj(n -> new Sum()).collect(Collectors.toList());
            for (int i = 0; i < 5; ++i) {
                for (int j = 0; j < 5; ++j) {
                    int n = board[i][j];
                    s.get(i).horizontal.add(n);
                    s.get(j).vertical.add(n);
                }
            }
            sums.add(s);
        }

        return sums;
    }

    static int getResult(int lastNumber, List<Sum> hitSum) {
        return lastNumber * hitSum.stream().mapToInt(s -> s.horizontal.stream().mapToInt(n -> n).sum()).sum();
    }

    static int getResult(Input input) {
        List<List<Sum>> sums = calculateSum(input);

        for (int n : input.numbers) {
            for (List<Sum> b : sums) {
                for (Sum s : b) {
                    s.vertical.remove(n);
                    s.horizontal.remove(n);
                    if (s.vertical.isEmpty() || s.horizontal.isEmpty()) {
                        return getResult(n, b);
                    }
                }
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        System.out.println(Problem1.getResult(new Input()));
    }
}
