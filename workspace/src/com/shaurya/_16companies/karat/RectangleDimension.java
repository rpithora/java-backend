package com.shaurya._16companies.karat;

public class RectangleDimension {
    public static void main(String[] args) {
        char[][] grid = {{'1', '1', '1', '1', '1'},
                {'1', '1', '0', '0', '0'},
                {'1', '1', '0', '0', '0'},
                {'1', '1', '1', '1', '1'}};
        RectangleDimension findRectangle = new RectangleDimension();
        findRectangle.find(grid);
    }

    private void find(char[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        for(int i=0; i<row; i++){
            for (int j=0; j<col; j++){
                if(grid[i][j] == 0){
                    System.out.println(" Found at :: Starting Point : " + i + " " + j);
                }
            }
        }
    }
}
