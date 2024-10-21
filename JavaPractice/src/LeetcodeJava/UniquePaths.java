package LeetcodeJava;

import java.util.Arrays;

public class UniquePaths {
    public int uniquePaths(int m, int n) {
        int[][] pathArray = new int[m][n];
        Arrays.fill(pathArray[0], 1);
        for (int i=1; i<m; i++){
            pathArray[i][0] = 1;
        }
        for (int i=1; i<m; i++){
            for (int j=1; j<n; j++){
                pathArray[i][j] = pathArray[i-1][j] + pathArray[i][j-1];
            }
        }
        return pathArray[m-1][n-1];
    }

    public static void main(String[] args) {
        UniquePaths uniquePaths = new UniquePaths();
        System.out.println(uniquePaths.uniquePaths(3, 7));
        System.out.println(uniquePaths.uniquePaths(3, 2));
    }
}
