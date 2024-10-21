package LeetcodeJava;

import java.util.Arrays;

public class RotateImage {
    public void reverse(int[] arr){
        int left = 0;
        int right = arr.length-1;
        while (left < right){
            int temp=arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
            left++;
            right--;
        }
    }
    public void rotate(int[][] matrix) {
        for (int i=0; i<matrix.length; i++){
            for (int j=0; j<i; j++){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
        for (int i=0; i<matrix.length; i++){
            reverse(matrix[i]);
        }
    }

    public void print(int[][] matrix){
        for (int[] row: matrix){
            System.out.println(Arrays.toString(row));
        }
    }

    public static void main(String[] args) {
        int[][] matrix = {{1,2,3},{4,5,6},{7,8,9}};

        RotateImage rotateImage = new RotateImage();
        rotateImage.print(matrix);
        rotateImage.rotate(matrix);
        rotateImage.print(matrix);
    }
}
