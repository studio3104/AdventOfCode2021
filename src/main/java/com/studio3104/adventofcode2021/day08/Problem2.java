package com.studio3104.adventofcode2021.day08;

import com.studio3104.adventofcode2021.utilities.InputLoader;

import java.util.*;

public class Problem2 {
    private static Set<Character> toCharSet(String signal) {
        Set<Character> s = new HashSet<>();
        for (char c : signal.toCharArray()) {
            s.add(c);
        }
        return s;
    }

    private static Character findChar(Set<Character> larger, Set<Character> smaller) {
        for (char c : larger) {
            if (!smaller.contains(c)) {
                return c;
            }
        }
        throw new RuntimeException();
    }

    private static Set<Character> findSeg(Set<Character> seg, List<Set<Character>> candidates) {
        for (Set<Character> candidate : candidates) {
            boolean containsAll = true;
            for (char s : seg) {
                if (!candidate.contains(s)) {
                    containsAll = false;
                    break;
                }
            }
            if (containsAll) {
                return candidate;
            }
        }
        throw new RuntimeException();
    }

    private static Map<Set<Character>, Integer> analyzeSignal(String[] wires) {
        /*
         aaa
        b   c
         ddd
        e   f
         ggg

        2: 1
        3: 7
        4: 4
        5: 2, 3, 5
        6: 0, 6, 9
        7: 8
        */

        Map<Integer, Set<Character>> reverse = new HashMap<>();
        List<Set<Character>> fiveSegments = new ArrayList<>();
        List<Set<Character>> sixSegments = new ArrayList<>();

        for (String w : wires) {
            Set<Character> wire = toCharSet(w);
            switch (wire.size()) {
                case 2:
                    reverse.put(1, wire);
                    break;
                case 3:
                    reverse.put(7, wire);
                    break;
                case 4:
                    reverse.put(4, wire);
                    break;
                case 5:
                    fiveSegments.add(wire);
                    break;
                case 6:
                    sixSegments.add(wire);
                    break;
                case 7:
                    reverse.put(8, wire);
                    break;
                default:
                    throw new RuntimeException();
            }
        }

        reverse.put(3, findSeg(reverse.get(1), fiveSegments));
        fiveSegments.remove(reverse.get(3));

        reverse.put(9, findSeg(reverse.get(3), sixSegments));
        sixSegments.remove(reverse.get(9));

        char e = findChar(reverse.get(8), reverse.get(9));

        for (Set<Character> seg : fiveSegments) {
            if (seg.contains(e)) {
                reverse.put(2, seg);
            } else {
                reverse.put(5, seg);
            }
        }

        for (Character c : reverse.get(1)) {
            if (reverse.get(2).contains(c)) {
                for (Set<Character> seg : sixSegments) {
                    if (seg.contains(c)) {
                        reverse.put(0, seg);
                    } else {
                        reverse.put(6, seg);
                    }
                }
                break;
            }
        }

        Map<Set<Character>, Integer> mapping = new HashMap<>();
        for (Map.Entry<Integer, Set<Character>> entry : reverse.entrySet()) {
            mapping.put(entry.getValue(), entry.getKey());
        }
        return mapping;
    }

    private static long getResult(String[] input) {
        long total = 0;

        for (String line : input) {
            String[] wiresSegments = line.split(" \\| ");
            Map<Set<Character>, Integer> signal = analyzeSignal(wiresSegments[0].split(" +"));

            int k = 1_000;
            for (String digit : wiresSegments[1].split(" +")) {
                total += signal.get(toCharSet(digit)) * k;
                k /= 10;
            }
        }

        return total;
    }

    public static void main(String[] args) {
        System.out.println(getResult(InputLoader.loadStringInput(8)));
    }
}
