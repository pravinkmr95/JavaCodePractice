package LeetcodeJava;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> output = new ArrayList<>();
        int top=0, bottom = matrix.length-1, left=0, right=matrix[0].length-1;
        while (left <= right && top <= bottom){
            for (int i=left; i<=right; i++){
                output.add(matrix[top][i]);
            }
            top++;
            for (int i=top; i<=bottom; i++){
                output.add(matrix[i][right]);
            }
            right--;

            if (top <= bottom){
                for (int i=right; i>=left; i--){
                    output.add(matrix[bottom][i]);
                }
                bottom--;
            }
            if (left <= right){
                for (int i=bottom; i>=top; i--){
                    output.add(matrix[i][left]);
                }
                left++;
            }
        }
        return output;
    }
    public static void main(String[] args) {
        int[][] matrix = {
                {1,2,3},
                {4,5,6},
                {7,8,9}};
        SpiralMatrix spiralMatrix = new SpiralMatrix();
        System.out.println(spiralMatrix.spiralOrder(matrix));

        int[][] matrix1 = {
                {1,2,3,4},
                {5,6,7,8},
                {9,10,11,12}
        };
        System.out.println(spiralMatrix.spiralOrder(matrix1));
    }
}
