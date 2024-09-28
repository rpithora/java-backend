package com.shaurya._15graph;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

//BFS
public class RottenOranges {

    public static void main(String[] args) {
        int [][]grid = {{2,1,1}, {1,1,0},{0,1,1}};
        RottenOranges rottenOranges = new RottenOranges();
        int totalTime = rottenOranges.orangesRotting(grid);
        System.out.println(totalTime);
    }

    class Pair{
        int row;
        int col;
        public Pair(int row, int col){
            this.row = row;
            this.col = col;
        }
    }
    public int orangesRotting(int[][] grid) {
        if(grid == null || grid.length == 0) return 0;
        int n = grid.length;
        int m = grid[0].length;
        int counter = 0;

        // find the rotten oranges

        Queue<Pair> q = new LinkedList<>();

        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(grid[i][j] == 2){
                    q.offer(new Pair(i,j));
                }
            }
        }

        while(!q.isEmpty()){

            int size = q.size();
            boolean rot = false;
            for(int i=0; i<size; i++){

                Pair p = q.poll();

                int []dx = {-1,1,0,0};
                int []dy = {0,0,-1,1};

                for(int k=0; k<4; k++){
                    int x = p.row + dx[k];
                    int y = p.col + dy[k];

                    if(x < 0 || y < 0 || x >= n || y >= m || grid[x][y] == 0 || grid[x][y] == 2) continue;

                    grid[x][y] = 2;
                    rot = true;
                    q.offer(new Pair(x,y));

                }
            }
            if(rot)
                counter++;

        }
        if(Arrays.stream(grid).flatMapToInt(Arrays::stream).anyMatch(s -> s == 1))
            return -1;

        return counter;
    }
}