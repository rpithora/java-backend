package com.shaurya._13backtracking;

public class _05NQueensProblem {
    public static void main(String[] args) {
        int[][] board = {{0, 0, 0, 0},
                {0, 0, 0, 0},
                {0, 0, 0, 0},
                {0, 0, 0, 0}};

        _05NQueensProblem queens = new _05NQueensProblem();
        System.out.println(queens.solve(0, new boolean[board[0].length], new boolean[10],
                new boolean[10], board.length, board));
    }

    private boolean solve(int i, boolean[] col, boolean[] diag,
                          boolean[] antiDiag, int n, int[][] board) {
        if (i == n) {
            System.out.println("here");
            return true;
        }

        for (int j = 0; j < n; j++) {
            if (!col[j]
                    || !diag[n + i - j]
                    || !antiDiag[i + j]) {
                continue;
            }

            board[i][j] = 1;
            col[j] = false;
            diag[n + i - j] = false;
            antiDiag[i + j] = false;
            solve(i + 1, col, diag, antiDiag, n, board);
            board[i][j] = 0;
            col[j] = true;
            diag[n + i - j] = true;
            antiDiag[i + j] = true;
        }
        return false;
    }
}