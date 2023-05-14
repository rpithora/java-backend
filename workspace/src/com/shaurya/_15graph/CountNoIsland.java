package com.shaurya._15graph;

import javafx.util.Pair;
import java.util.LinkedList;
import java.util.Queue;

public class CountNoIsland {
    public static void main(String[] args) {
        /*[["1","1","0","0","0"],
         ["1","1","0","0","0"],
         ["0","0","1","0","0"],
         ["0","0","0","1","1"]]*/

        char [][]grid = {{'1','1','0','0','0'},
                         {'1','1','0','0','0'},
                         {'0','0','1','0','0'},
                         {'0','0','0','1','1'}};
        CountNoIsland island = new CountNoIsland();
        System.out.println(island.numIslands(grid));
    }

    public int noLand(char [][]grid){

        int n = grid.length;
        int m = grid[0].length;
        int [][]visit = new int[n][m];
        int count = 0;
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(visit[i][j] == 0 && grid[i][j] == 1){
                    count++;
                    bfs(i,j,grid, visit, n, m);
                }
            }
        }
        return count;
    }





    public int numIslands(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int[][] visited = new int[n][m];
        int count = 0;
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(visited[i][j] == 0 && grid[i][j] == '1'){
                    count++;
                    bfs(i, j, grid, visited, n, m);
                }
            }
        }
        return count;
    }

    private void bfs(int i, int j, char[][] grid, int[][] visited, int n, int m) {
        visited[i][j] = 1;
        Queue<Pair<Integer,Integer>> q = new LinkedList<>();
        q.offer(new Pair<>(i,j));

        //      8 directions

        //      i-1,j-1 (-1,-1)     i-1,j (-1,0)      i-1,j+1 (-1,+1)

        //      i,j-1 (0,-1)       i,j               i,j+1 (0,+1)

        //      i+1,j-1 (+1,-1)    i+1,j (+1,0)       i+1,j+1 (+1,+1)

        int delRow[] = {-1, 0, +1, 0};
        int delCol[] = {0, +1, 0, -1};
        while (!q.isEmpty()){
            Pair p = q.poll();
            int row = (int) p.getKey();
            int col = (int) p.getValue();
            //4 directions
            for(int k=0; k<4; k++){
                int nRow = row + delRow[k];
                int nCol = col + delCol[k];
                if(nRow >= 0 && nRow < n && nCol >= 0 && nCol < m
                        && grid[nRow][nCol] == '1' && visited[nRow][nCol] == 0){
                    visited[nRow][nCol] = 1;
                    q.offer(new Pair<>(nRow, nCol));
                }
            }
        }
    }
}
