package LeetcodeJava;

import InterfacePractice.A;

import java.util.Arrays;

public class SetMatrixZeros {
    public void setZeroes(int[][] matrix) {
        int[] rows = new int[matrix.length];
        Arrays.fill(rows, -1);
        int[] columns = new int[matrix[0].length];
        Arrays.fill(columns, -1);

        for (int i=0; i< matrix.length; i++){
            for (int j=0; j< matrix[0].length; j++){
                if (matrix[i][j] == 0){
                    rows[i] = 0;
                    columns[j] = 0;
                }
            }
        }
//        System.out.println(Arrays.toString(rows));
//        System.out.println(Arrays.toString(columns));
        for (int i=0; i<matrix.length; i++){
            for (int j=0; j<matrix[0].length; j++){
                if (rows[i] == 0){
                    matrix[i][j] = 0;
                }
                if (columns[j] == 0){
                    matrix[i][j] = 0;
                }
            }
        }
    }

    public void setZeroesOptimal(int[][] matrix){

    }

    public void print(int[][] matrix){
        for (int[] row: matrix){
            System.out.println(Arrays.toString(row));
        }
        System.out.println();
    }
    public static void main(String[] args) {
        int[][] matrix = {
                {1,1,1},
                {1,0,1},
                {1,1,1}
        };
        SetMatrixZeros setMatrixZeros = new SetMatrixZeros();
        setMatrixZeros.print(matrix);

        setMatrixZeros.setZeroes(matrix);
        //System.out.println(Arrays.deepToString(matrix));
        setMatrixZeros.print(matrix);
    }
}
