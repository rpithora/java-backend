package com.shaurya._13backtracking;

import java.util.Arrays;

public class _04RatMaze {
    private boolean success = false;

    public static void main(String[] args) {
        _04RatMaze rat = new _04RatMaze();
        int[][] maze = {{1, 0, 0, 0},
                {1, 1, 0, 1},
                {0, 1, 0, 0},
                {1, 1, 1, 1}};
        int n = maze.length;
        int m = maze[0].length;
        System.out.println(rat.solveMaze(0, 0, maze, n, m));
        for (int[] a : maze) {
            Arrays.stream(a).forEach(s -> System.out.print(s + " "));
            System.out.println();
        }
    }

    private boolean isValid(int row, int col, int n, int m, int[][] maze) {
        return row >= 0 && col >= 0 && row < n && col < m && maze[row][col] == 1;
    }

    private boolean isSolved(int row, int col, int n, int m) {
        return row == n - 1 && col == m - 1;
    }

    private boolean solveMaze(int i, int j, int[][] maze, int n, int m) {
        if (isSolved(i, j, n, m))
            return true;

        int[] idx = {0, 1, 0, -1};
        int[] idy = {1, 0, -1, 0};

        for (int k = 0; k < 4; k++) {
            int nX = i + idx[k];
            int nY = j + idy[k];

            if (isValid(nX, nY, n, m, maze)) {
                maze[nX][nY] = 0;
                success = solveMaze(nX, nY, maze, n, m);
                maze[nX][nY] = 1;
            }
        }
        return success;
    }
}
