package com.studio3104.adventofcode2021.day06;

import com.studio3104.adventofcode2021.utilities.InputLoader;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Problem1 {
    static long getResult(int[] init, int days) {
        Map<Integer, Long> counter = new HashMap<>();
        for (int n : init) {
            counter.putIfAbsent(n, (long) 0);
            counter.put(n, counter.get(n) + 1);
        }

        for (int i = 0; i < days; ++i) {
            Map<Integer, Long> newCounter = new HashMap<>();
            for (Map.Entry<Integer, Long> entry : counter.entrySet()) {
                newCounter.put(entry.getKey() - 1, entry.getValue());
            }
            if (newCounter.containsKey(-1)) {
                long c = newCounter.remove(-1);
                for (int n : new int[]{6, 8}) {
                    newCounter.putIfAbsent(n, (long) 0);
                    newCounter.put(n, newCounter.get(n) + c);
                }
            }
            counter = newCounter;
        }

        return counter.values().stream().mapToLong(n -> n).sum();
    }

    public static void main(String[] args) {
        String[] input = InputLoader.loadStringInput(6);
        int[] init = Arrays.stream(input[0].split(",")).mapToInt(Integer::parseInt).toArray();
        System.out.println(getResult(init, 80));
    }
}
