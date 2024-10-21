package LeetcodeJava;

import java.util.HashSet;
import java.util.Set;

public class NumberOfDistinctIslands {
    public void dfs(int[][] grid, boolean[][] visited, int i, int j, char dir, StringBuilder sb){
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] != 1 || visited[i][j]){
            return;
        }
        visited[i][j] = true;
        sb.append(dir);
        dfs(grid, visited, i-1, j, 'u', sb);
        dfs(grid, visited, i, j-1, 'l', sb);
        dfs(grid, visited, i+1, j, 'd', sb);
        dfs(grid, visited, i, j+1, 'r', sb);
        sb.append('b');
    }

    public int countDistinctIslands(int[][] grid) {
        int rows = grid.length;
        int columns = grid[0].length;
        boolean[][] visited = new boolean[rows][columns];
        Set<String> outputSet = new HashSet<>();
        for (int i=0; i<rows; i++){
            for (int j =0; j<columns; j++) {
                if (grid[i][j] == 1 && !visited[i][j]) {
                    StringBuilder sb = new StringBuilder();
                    dfs(grid, visited, i, j, 'o', sb);
                    outputSet.add(sb.toString());
                }
            }
        }
        return outputSet.size();
    }

    public static void main(String[] args) {
        int[][] grid = {
                {1, 1, 0, 0, 0},
                {1, 1, 0, 0, 0},
                {0, 0, 0, 1, 1},
                {0, 0, 0, 1, 1}};
        NumberOfDistinctIslands numberOfDistinctIslands = new NumberOfDistinctIslands();
        System.out.println(numberOfDistinctIslands.countDistinctIslands(grid));

        int[][] grid1 = {
                {1, 1, 0, 1, 1},
                {1, 0, 0, 0, 0},
                {0, 0, 0, 0, 1},
                {1, 1, 0, 1, 1}};
        System.out.println(numberOfDistinctIslands.countDistinctIslands(grid1));
    }
}
