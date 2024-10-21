package LeetcodeJava;

public class NumberOfIslands {
    public void dfs(char[][] grid, boolean[][] visited, int i, int j){
        visited[i][j] = true;
        int[][] dirArr = {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};
        for (int[] dir: dirArr){
            int tempI = i + dir[0];
            int tempJ = j + dir[1];
            if (tempI >= 0 && tempI < grid.length && tempJ >= 0 &&
                    tempJ < grid[0].length && grid[tempI][tempJ] == '1' && !visited[tempI][tempJ]){
                dfs(grid, visited, tempI, tempJ);
            }
        }
    }

    public int numIslands(char[][] grid) {
        int rows = grid.length;
        int columns = grid[0].length;
        boolean[][] visited = new boolean[rows][columns];
        int output = 0;
        for (int i=0; i<rows; i++){
            for (int j=0; j<columns; j++){
                if (grid[i][j] == '1' && !visited[i][j]){
                    dfs(grid, visited, i, j);
                    output++;
                }
            }
        }
        return output;
    }

    public static void main(String[] args) {
        char[][] grid = {
                {'1', '1', '1', '1', '0'},
                {'1', '1', '0', '1', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '0', '0', '0'}};
        NumberOfIslands numberOfIslands = new NumberOfIslands();
        System.out.println(numberOfIslands.numIslands(grid));
        
        char[][] grid1 = {
                {'1','1','0','0','0'},
                {'1','1','0','0','0'},
                {'0','0','1','0','0'},
                {'0','0','0','1','1'}};
        System.out.println(numberOfIslands.numIslands(grid1));
    }
    
}