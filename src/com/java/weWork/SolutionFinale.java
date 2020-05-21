package com.java.weWork;

import java.util.Scanner;

public class SolutionFinale {

	//static String matrix[][] = { {"1","1","0","0","0"},{"1","1","0","0","0"},{"0","0","1","0","0"},{"0","0","0","1","1"} };
	static String matrix[][] = { {"1","1","1","1","1"},{"1","0","0","0","1"},{"1","0","0","0","0"},{"1","1","1","0","1"} };
	static Boolean visited[][];
	public static void markIsland(int x, int y) {
		if (x < 0 || x > matrix.length - 1 || y < 0 || y > matrix[x].length - 1) {
            return;
        }
        if (visited[x][y] == true) {
            return;
        }
        visited[x][y] = true;
        if (matrix[x][y] == "0") {
            return;
        }
        markIsland(x - 1, y);
        markIsland(x + 1, y);
        markIsland(x, y - 1);
        markIsland(x, y + 1);
	}
	public static int numOffices(String[][] grid) {
        int result = 0;
        for (int x = 0; x < grid.length; x++) {
            for (int y = 0; y < grid[x].length; y++) {
                if (!visited[x][y] && grid[x][y] == "1") {
                    result++;
                    markIsland(x, y);
                }
                visited[x][y] = true;
            }
        }

        return result;
    }
	public static void main(String[] args) {		
        visited = new Boolean[4][5];
        for(int i = 0; i<4; i++) {
        	for(int j = 0; j<5; j++) {
        		visited[i][j] = false;
        	}
        }
        
        System.out.print(" " + numOffices(matrix));
	}

}
