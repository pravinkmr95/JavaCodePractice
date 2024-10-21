package LeetcodeJava;

public class MaxAreaIsland {
    public void dfs(int[][] grid, boolean[][] visited, int i, int j, int[] currentCount){
        visited[i][j] = true;
        currentCount[0]++;
        int[][] dirArr = {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};
        for (int[] dir: dirArr){
            int tempI = i + dir[0];
            int tempJ = j + dir[1];
            if (tempI >= 0 && tempI < grid.length && tempJ >= 0 &&
                    tempJ < grid[0].length && grid[tempI][tempJ] == 1 && !visited[tempI][tempJ]){
                dfs(grid, visited, tempI, tempJ, currentCount);
            }
        }
    }

    public int maxAreaOfIsland(int[][] grid) {
        int rows = grid.length;
        int columns = grid[0].length;
        boolean[][] visited = new boolean[rows][columns];
        int output = 0;
        for (int i=0; i<rows; i++){
            for (int j=0; j<columns; j++){
                if (grid[i][j] == 1 && !visited[i][j]){
                    int[] arr = {0};
                    dfs(grid, visited, i, j, arr);
                    output = Math.max(output, arr[0]);
                }
            }
        }
        return output;
    }

    public static void main(String[] args) {
        int[][] grid = {
                {0,0,1,0,0,0,0,1,0,0,0,0,0},
                {0,0,0,0,0,0,0,1,1,1,0,0,0},
                {0,1,1,0,1,0,0,0,0,0,0,0,0},
                {0,1,0,0,1,1,0,0,1,0,1,1,0},
                {0,1,0,0,1,1,0,0,1,1,1,0,0},
                {0,0,0,0,0,0,0,0,0,0,1,0,0},
                {0,0,0,0,0,0,0,1,1,1,0,0,0},
                {0,0,0,0,0,0,0,1,1,0,0,0,0}
        };
        MaxAreaIsland maxAreaIsland = new MaxAreaIsland();
        System.out.println(maxAreaIsland.maxAreaOfIsland(grid));


    }


}
