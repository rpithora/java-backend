package com.shaurya._13backtracking;

import java.util.Arrays;

public class _04RatMaze {
    public static void main(String[] args) {
        _04RatMaze rat = new _04RatMaze();
        int maze[][] = { { 1, 0, 0, 0 },
                         { 1, 1, 0, 1 },
                         { 0, 1, 0, 0 },
                         { 1, 1, 1, 1 } };
        int n = maze.length;
        int m = maze[0].length;
        System.out.println(rat.solveMaze(0, 0, maze, n, m));
        for(int a[] : maze){
            Arrays.stream(a).forEach(s -> System.out.print(s + " "));
            System.out.println();
        }
    }

    private boolean solveMaze(int i, int j, int[][] maze, int n, int m) {
        if(i == n-1 && j == m-1)
            return true;

        if(i < 0 || i >= n || j < 0 || j >= m)
            return false;

        if(maze[i][j] == 1 || maze[i][j] == 2)
            return false;

        maze[i][j] = 2;

        return solveMaze(i, j-1, maze, n, m)
            || solveMaze(i, j+1, maze, n, m)
            || solveMaze(i-1, j, maze, n, m)
            || solveMaze(i+1, j, maze, n, m);
    }
}
