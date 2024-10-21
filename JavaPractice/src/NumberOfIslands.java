public class NumberOfIslands {
    public int[][] dir = {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};

    public void dfs(char[][] grid, boolean[][] visited, int i, int j, int length, int width){
        visited[i][j] = true;
        for (int[] temp: dir){
            int temp_i = i + temp[0];
            int temp_j = j + temp[1];
            if (temp_i >= 0 && temp_i < length && temp_j >= 0 && temp_j < width && grid[temp_i][temp_j] == '1' && !visited[temp_i][temp_j]){
                dfs(grid, visited, temp_i, temp_j, length, width);
            }
        }
    }

    public int numberOfIslands(char[][] grid){
        int length = grid.length;
        int width = grid[0].length;
        boolean[][] visited = new boolean[length][width];
        int output = 0;
        for (int i=0; i < length; i++){
            for (int j=0; j < width; j++){
                if (grid[i][j] == '1' && !visited[i][j]){
                    dfs(grid, visited, i, j, length, width);
                    output++;
                }
            }
        }
        return output;
    }

    public static void main(String[] args) {
        char[][] grid = {
                { '1', '1', '0', '0', '0' },
                { '0', '1', '0', '0', '1' },
                { '1', '0', '0', '1', '1' },
                { '0', '0', '0', '0', '0' },
                { '1', '0', '1', '1', '0' }
        };
        NumberOfIslands obj = new NumberOfIslands();
        System.out.println(obj.numberOfIslands(grid));

    }
}

