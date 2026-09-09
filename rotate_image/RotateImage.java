import java.util.*;


/*
* javac RotateImage.java; java -ea RotateImage
* https://leetcode.com/problems/rotate-image/
step 1 - transpose
step 2 - reverse each row

Transpose
1 2 3
4 5 6
7 8 9
->
1 4 7
2 5 8
3 6 9

Reverse row
7 4 1
8 5 2
9 6 3
*/


public class RotateImage {
    public void rotate(int[][] matrix) {
        int n = matrix.length;

        System.out.println("Input is " + Arrays.deepToString(matrix));

        // 1. Transpose
        for (int r = 0; r < n; r++) {
            for (int c = r + 1; c < n; c++) {
                int temp = matrix[r][c];
                matrix[r][c] = matrix[c][r];
                matrix[c][r] = temp;
            }
        }

        // 2. Reverse each row
        for (int[] row : matrix) {
            int left = 0;
            int right = n - 1;

            while (left < right) {
                int temp = row[left];
                row[left] = row[right];
                row[right] = temp;

                left++;
                right--;
            }
        }
        System.out.println("Output is " + Arrays.deepToString(matrix));
    }

    public static void main(String[] args) {
        RotateImage s = new RotateImage();

        // Single element
        int[][] m1 = {
            {1}
        };
        s.rotate(m1);
        assert Arrays.deepEquals(
            m1,
            new int[][] {
                {1}
            }
        );

        // 2 x 2
        int[][] m2 = {
            {1, 2},
            {3, 4}
        };
        s.rotate(m2);
        assert Arrays.deepEquals(
            m2,
            new int[][] {
                {3, 1},
                {4, 2}
            }
        );

        // 3 x 3
        int[][] m3 = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
        };
        s.rotate(m3);
        assert Arrays.deepEquals(
            m3,
            new int[][] {
                {7, 4, 1},
                {8, 5, 2},
                {9, 6, 3}
            }
        );

        // 4 x 4
        int[][] m4 = {
            {5, 1, 9, 11},
            {2, 4, 8, 10},
            {13, 3, 6, 7},
            {15, 14, 12, 16}
        };
        s.rotate(m4);
        assert Arrays.deepEquals(
            m4,
            new int[][] {
                {15, 13, 2, 5},
                {14, 3, 4, 1},
                {12, 6, 8, 9},
                {16, 7, 10, 11}
            }
        );

    }
}