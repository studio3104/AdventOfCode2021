package com.studio3104.adventofcode2021.day04;

import com.studio3104.adventofcode2021.utilities.InputLoader;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Input {
    int[] numbers;
    List<int[][]> boards;

    Input() {
        String[] input = InputLoader.loadStringInput(4);

        numbers = Arrays.stream(input[0].split(",")).mapToInt(Integer::parseInt).toArray();

        boards = new ArrayList<>();
        int[][] board = new int[5][5];
        int bi = 0;
        for (int i = 2; i < input.length; ++i) {
            String line = input[i];
            if (line.isBlank()) {
                boards.add(board);
                board = new int[5][5];
                bi = 0;
                continue;
            }
            board[bi++] = Arrays.stream(line.trim().split(" +")).mapToInt(Integer::parseInt).toArray();
        }
        boards.add(board);
    }
}
